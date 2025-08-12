package excelReadWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {
    @DataProvider
    public Object[][] getData() throws IOException {
        List<Object[]> returnObjectArray = new ArrayList<Object[]>();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook("studentDetails.xlsx");
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("sheet 1");
        Iterator<Row> rowIterator = xssfSheet.rowIterator();
        if (rowIterator.hasNext()) rowIterator.next(); // skip headers
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            List<Object> objectList = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(cell.getCellType().equals(CellType.STRING)){
                    objectList.add(cell.getStringCellValue());
                }else {
                    objectList.add((int) cell.getNumericCellValue());
                }
            }
            returnObjectArray.add(objectList.toArray(new Object[0]));
        }
        return returnObjectArray.toArray(new Object[0][]);
    }

    @Test(dataProvider = "getData")
    public void printStudentDetails(String name, int age){
        System.out.printf("Name: %s, Age: %d\n", name, age);
    }
}
