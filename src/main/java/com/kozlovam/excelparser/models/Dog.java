package com.kozlovam.excelparser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Dog")
public class Dog extends Animal implements DogInterface{
    @Column(name = "speed", nullable = false)
    private String runSpeed;
}
