package com.kozlovam.excelparser.helper;


import com.kozlovam.excelparser.exceptions.NotAnimalException;
import com.kozlovam.excelparser.exceptions.NotRequiredFileType;
import com.kozlovam.excelparser.models.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Component
public class ExcelHelper {
    private static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private AnimalFactory animalFactory = new AnimalFactory();

    public boolean hasExcelFormat(MultipartFile file) {
        try{
            if (TYPE.equals(file.getContentType())){
                return true;
            } else {
                throw new NotRequiredFileType("Формат: ", file.getContentType());
            }
        } catch (NotRequiredFileType notRequiredFileType) {
            notRequiredFileType.printStackTrace();
            return false;
        }
    }

    public List<Animal> excelToAnimals(InputStream is) {
        List<Animal> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsize = sheet.getPhysicalNumberOfRows();
            for (int j = 1; j < rowsize; j++) {
                int firsCell = 0;
                Row row = sheet.getRow(j);
                Cell cell = row.getCell(firsCell);
                if (cell.getStringCellValue().equals("Dog")) {
                    Dog dog = (Dog) animalFactory.createDog();
                    dog.setName(row.getCell(1).toString());
                    dog.setRunSpeed(row.getCell(2).toString());
                    list.add(dog);
                } else if (cell.getStringCellValue().equals("Bird")) {
                    Bird bird = (Bird) animalFactory.createBird();
                    bird.setName(row.getCell(1).toString());
                    double d = row.getCell(2).getNumericCellValue();
                    BigDecimal bigDecimal = BigDecimal.valueOf(d);
                    bird.setFlightSpeed(bigDecimal);
                    list.add(bird);
                } else{
                    throw new NotAnimalException("Введено: ", cell.getStringCellValue());
                }
            }
            workbook.close();
        } catch (NotAnimalException e) {
            e.printStackTrace();
            return null;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}