package com.southwind.controller;

import com.southwind.dto.RequestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CovidDataControllerTest {

    @Autowired
    private CovidDataController covidDataController;

    @Test
    void test(){
        RequestData requestData = new RequestData();
        List<Integer> columns = new ArrayList<>();
        columns.add(5);
        columns.add(8);
        List<String> countries = new ArrayList<>();
        countries.add("China");
        countries.add("Brazil");
        LocalDate date = LocalDate.parse("2021-10-01");
        Integer duration = 20;
        requestData.setColumnsToBeVisited(columns);
        requestData.setCountryNames(countries);
        requestData.setDate(date);
        requestData.setDuration(duration);
        covidDataController.getChartData(requestData);
        //covidDataController.list().forEach(System.out::println);
    }



}