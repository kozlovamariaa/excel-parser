package com.kozlovam.excelparser.controllers;


import com.kozlovam.excelparser.exceptions.NotRequiredFileType;
import com.kozlovam.excelparser.helper.ExcelHelper;
import com.kozlovam.excelparser.services.ExcelService;
import com.kozlovam.excelparser.exceptions.NotRequiredFileType;
import com.kozlovam.excelparser.helper.ExcelHelper;
import com.kozlovam.excelparser.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/animals")
public class MainController {
    @Autowired
    ExcelHelper excelHelper;
    @Autowired
    ExcelService exelService;

    @PostMapping("/import")
    public ResponseEntity sendExel(@RequestParam("file") MultipartFile file) throws IOException {
        if(excelHelper.hasExcelFormat(file)){
            if(exelService.save(file)){
                return ResponseEntity.status(HttpStatus.OK).body("Сохранение прошло успешно");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка, введите другое животное");
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new NotRequiredFileType("Неверный формат файла: ", file.getContentType()).toString());
        }
    }
}