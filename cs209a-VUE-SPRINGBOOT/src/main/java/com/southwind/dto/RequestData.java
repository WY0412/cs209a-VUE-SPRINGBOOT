package com.southwind.dto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class RequestData {
    private List<Integer> columnsToBeVisited;
    private List<String> countryNames;
    private LocalDate date;
    private Integer duration;
}
