package com.kozlovam.excelparser.models;

public class AnimalFactory implements AbstractAnimalFactory {

    @Override
    public DogInterface createDog() {
        return new Dog();
    }

    @Override
    public BirdInterface createBird() {
        return new Bird();
    }
}

