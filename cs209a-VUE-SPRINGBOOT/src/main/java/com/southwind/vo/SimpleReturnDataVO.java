package com.southwind.vo;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Data
public class SimpleReturnDataVO {
    private String countryName;
    private List<SingleAttributeVO> attributeList;
}
