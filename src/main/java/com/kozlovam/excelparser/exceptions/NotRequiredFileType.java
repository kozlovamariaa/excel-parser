package com.kozlovam.excelparser.exceptions;

public class NotRequiredFileType extends Exception{
    private String fileType;
    public NotRequiredFileType(String message, String fileType) {
        super(message);
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "Error. Unable to identify the type of file."
                +" Message: " + getMessage() + fileType;
    }
}