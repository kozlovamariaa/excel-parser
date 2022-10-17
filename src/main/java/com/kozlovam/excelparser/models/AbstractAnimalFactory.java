package com.kozlovam.excelparser.models;

public interface AbstractAnimalFactory {
    DogInterface createDog();
    BirdInterface createBird();
}