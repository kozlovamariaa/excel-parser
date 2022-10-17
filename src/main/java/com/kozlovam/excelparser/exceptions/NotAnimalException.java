package com.kozlovam.excelparser.exceptions;

public class NotAnimalException extends Exception{
    private String animal;
    public NotAnimalException(String message, String animal) {
        super(message);
        this.animal = animal;
    }
    @Override
    public String toString() {
        return "Error. Unable to identify the animal."
                +", message: " + getMessage() + animal;
    }
}