package com.southwind.controller;


import com.southwind.dto.DataDate;
import com.southwind.dto.RequestData;
import com.southwind.entity.CovidData;
import com.southwind.service.CovidDataService;
import com.southwind.vo.ColNameAndIndex;
import com.southwind.vo.ReturnDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-12-17
 */
@Api(tags = "CovidDataController")
@RestController
@RequestMapping("/covidData")
public class CovidDataController {
    @Autowired
    private CovidDataService covidDataService;

    /*
    @ApiOperation(value = "covidUse")
    @PostMapping("/findAll")
    public HashMap<String, List<CountryAndCasesVO>> getAllCases(@RequestBody Countries countries){
        List<String> countryList = countries.getCountryList();
        return covidDataService.findAllCasesByCountry(countryList);
    }

    @ApiOperation(value = "covidTest")
    @GetMapping("/list")
    public List<CovidData> list(){
        return this.covidDataService.list();
    }
     */

    @ApiOperation(value = "getChartData")
    @PostMapping("/getChartData")
    public List<ReturnDataVO> getChartData(@RequestBody RequestData requestData){
        List<Integer> columnsToBeVisited = requestData.getColumnsToBeVisited();
        List<String> countryName = requestData.getCountryNames();
        LocalDate date = requestData.getDate();
        Integer duration = requestData.getDuration();
        return covidDataService.findRequiredDataForChart(columnsToBeVisited,countryName,date,duration);
    }

    @ApiOperation(value = "getNames")
    @GetMapping("/getNames")
    public List<String> getNames(){
        return covidDataService.getNames();
    }

    @ApiOperation(value = "getAllDataInOneDay")
    @PostMapping("/getAllDataInOneDay")
    public List<CovidData> getAllDataInOneDay(@RequestBody DataDate dataDate){
        return covidDataService.getAllDataInOneDay(dataDate.getDate());
    }
    @ApiOperation(value = "getUsableColumns")
    @GetMapping("/getUsableColumns")
    public List<ColNameAndIndex> getUsableColumns(){
        return covidDataService.getColNameAndIndex();
    }
}

