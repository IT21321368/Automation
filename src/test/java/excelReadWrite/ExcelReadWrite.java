package excelReadWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ExcelReadWrite {
    private static List<Object[]> studentDetails = Arrays.asList(
            new Object[]{"Name","Age"},
            new Object[]{"Amal",25},
            new Object[]{"Kamal",20},
            new Object[]{"Saman",55}
    );

    public static void WriteToExcel() throws IOException {
        OutputStream outputStream = new FileOutputStream("studentDetails.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("sheet 1");

        IntStream.range(0,studentDetails.size()).forEach((index)->{
            XSSFRow xssfRow = xssfSheet.createRow(index);
            Object[] stdDetails = studentDetails.get(index);
            List<Object> objValues = Arrays.stream(stdDetails).toList();

            IntStream.range(0, objValues.size()).forEach((index2)->{
                XSSFCell xssfCell = null;
                if(objValues.get(index2) instanceof String){
                    xssfCell = xssfRow.createCell(index2, CellType.STRING);
                    xssfCell.setCellValue((String) objValues.get(index2));
                }else {
                    xssfCell = xssfRow.createCell(index2, CellType.NUMERIC);
                    xssfCell.setCellValue((int) objValues.get(index2));
                }
            });
        });

        xssfWorkbook.write(outputStream);

    }

    public static void ReadFromExcel() throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream("studentDetails.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream)) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheet("sheet 1");

                List<Object[]> readData = new ArrayList<>();
                for (Row row : xssfSheet){
                    List<Object> rowData = new ArrayList<>();
                    for (Cell cell : row){
                        switch (cell.getCellType()){
                            case STRING -> rowData.add(cell.getStringCellValue());
                            case NUMERIC -> rowData.add(cell.getNumericCellValue());
                        }
                    }
                    readData.add(rowData.toArray());
                }
            readData.forEach(arr -> System.out.println(Arrays.toString(arr)));

        }
    }

    public static void main(String[] args) throws IOException {
//        ExcelReadWrite.WriteToExcel();
        ExcelReadWrite.ReadFromExcel();
    }
}

