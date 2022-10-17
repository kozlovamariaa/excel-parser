package com.kozlovam.excelparser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Bird")
public class Bird extends Animal implements BirdInterface{
    @Column(name = "speed", nullable = false)
    private BigDecimal flightSpeed;
}
