package english;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public List<String[]> readExcelFile(String filePath) {
        List<String[]> wordPairs = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(6);
            for (Row row : sheet) {
                if (row.getPhysicalNumberOfCells() >= 2) {
                    Cell englishCell = row.getCell(0);
                    Cell translationCell = row.getCell(1);
                    if (englishCell != null && translationCell != null) {
                        wordPairs.add(new String[]{
                                englishCell.getStringCellValue(),
                                translationCell.getStringCellValue()
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordPairs;
    }
}
