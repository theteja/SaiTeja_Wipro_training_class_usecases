package utilities;



import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static String getData(
            int row,
            int cell) throws Exception {

        FileInputStream fis =
            new FileInputStream(
                "src/test/resources/testdata/LoginData.xlsx"
            );

        XSSFWorkbook wb =
            new XSSFWorkbook(fis);

        XSSFSheet sheet =
            wb.getSheet("Sheet1");

        return sheet.getRow(row)
                    .getCell(cell)
                    .getStringCellValue();
    }
}
