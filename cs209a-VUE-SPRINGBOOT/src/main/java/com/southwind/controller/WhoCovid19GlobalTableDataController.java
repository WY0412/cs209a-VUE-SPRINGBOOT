package com.southwind.controller;


import com.southwind.dto.DataDate;
import com.southwind.dto.RequestData;
import com.southwind.dto.SimpleRequestData;
import com.southwind.entity.CovidData;
import com.southwind.entity.WhoCovid19GlobalTableData;
import com.southwind.service.WhoCovid19GlobalTableDataService;
import com.southwind.vo.ColNameAndIndex;
import com.southwind.vo.ReturnDataVO;
import com.southwind.vo.SimpleReturnDataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-12-19
 */
@Api(tags = "WhoCovid19GlobalTableDataController")
@RestController
@RequestMapping("//whoCovid19GlobalTableData")
public class WhoCovid19GlobalTableDataController {
    @Autowired
    private WhoCovid19GlobalTableDataService whoCovid19GlobalTableDataService;

    @ApiOperation(value = "getChartData")
    @PostMapping("/getChartData")
    public List<SimpleReturnDataVO> getChartData(@RequestBody SimpleRequestData simpleRequestData){
        List<Integer> columnsToBeVisited = simpleRequestData.getColumnsToBeVisited();
        List<String> countryName = simpleRequestData.getCountryNames();
        return whoCovid19GlobalTableDataService.findRequiredDataForChart(columnsToBeVisited,countryName);
    }

    @ApiOperation(value = "getNames")
    @GetMapping("/getNames")
    public List<String> getNames(){
        return whoCovid19GlobalTableDataService.getNames();
    }

    @ApiOperation(value = "getAllData")
    @GetMapping("/getAllData")
    public List<WhoCovid19GlobalTableData> getAllData(){
        return whoCovid19GlobalTableDataService.getAllData();
    }
    @ApiOperation(value = "getUsableColumns")
    @GetMapping("/getUsableColumns")
    public List<ColNameAndIndex> getUsableColumns(){
        return whoCovid19GlobalTableDataService.getColNameAndIndex();
    }

}

