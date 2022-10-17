package com.kozlovam.excelparser.services;

import com.kozlovam.excelparser.dao.AnimalDao;
import com.kozlovam.excelparser.helper.ExcelHelper;
import com.kozlovam.excelparser.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {
    private List<Animal> animalsList = new ArrayList<>();
    @Autowired
    ExcelHelper excelHelper;
    @Autowired
    AnimalDao animalDao;

    public boolean save(MultipartFile file) {
        try {
            animalsList = excelHelper.excelToAnimals(file.getInputStream());
            if (animalsList == null){
                return false;
            }
            animalDao.save(animalsList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
        return true;
    }
}