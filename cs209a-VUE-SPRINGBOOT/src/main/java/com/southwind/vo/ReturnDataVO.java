package com.southwind.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Data
public class ReturnDataVO {
    private String countryName;
    private List<List<SingleAttributeVO>> singleDayDataVOList;
}
