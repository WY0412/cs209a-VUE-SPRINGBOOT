package com.southwind.controller;


import com.southwind.dto.SimpleRequestData;
import com.southwind.entity.VaccinationData;
import com.southwind.entity.WhoCovid19GlobalTableData;
import com.southwind.service.VaccinationDataService;
import com.southwind.vo.ColNameAndIndex;
import com.southwind.vo.ReturnDataVO;
import com.southwind.vo.SimpleReturnDataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-12-19
 */
@Api(tags = "VaccinationDataController")
@RestController
@RequestMapping("//vaccinationData")
public class VaccinationDataController {
    @Autowired
    private  VaccinationDataService vaccinationDataService;

    @ApiOperation(value = "getChartData")
    @PostMapping("/getChartData")
    public List<SimpleReturnDataVO> getChartData(@RequestBody SimpleRequestData simpleRequestData){
        List<Integer> columnsToBeVisited = simpleRequestData.getColumnsToBeVisited();
        List<String> countryName = simpleRequestData.getCountryNames();
        return vaccinationDataService.findRequiredDataForChart(columnsToBeVisited,countryName);
    }

    @ApiOperation(value = "getNames")
    @GetMapping("/getNames")
    public List<String> getNames(){
        return vaccinationDataService.getNames();
    }

    @ApiOperation(value = "getAllData")
    @GetMapping("/getAllData")
    public List<VaccinationData> getAllData(){
        return vaccinationDataService.getAllData();
    }

    @ApiOperation(value = "getUsableColumns")
    @GetMapping("/getUsableColumns")
    public List<ColNameAndIndex> getUsableColumns(){
        return vaccinationDataService.getColNameAndIndex();
    }

}

