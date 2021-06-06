package com.guirilima.santander.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Long id;
    private String name;
    private Double price;
    private LocalDate date;
    private Double variation;

}
