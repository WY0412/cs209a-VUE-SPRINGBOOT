package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.CovidData;
import com.southwind.entity.VaccinationData;
import com.southwind.entity.WhoCovid19GlobalTableData;
import com.southwind.mapper.VaccinationDataMapper;
import com.southwind.service.VaccinationDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.vo.ColNameAndIndex;
import com.southwind.vo.ReturnDataVO;
import com.southwind.vo.SimpleReturnDataVO;
import com.southwind.vo.SingleAttributeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-12-19
 */
@Service
public class VaccinationDataServiceImpl extends ServiceImpl<VaccinationDataMapper, VaccinationData> implements VaccinationDataService {
    HashMap<Integer,String> columnNamesMap = new HashMap<>(){
        {
            put(1, "country");
            put(2, "iso3");
            put(3, "whoRegion");
            put(4, "dataSource");
            put(5, "dateUpdated");
            put(6, "totalVaccinations");
            put(7, "personsVaccinatedPerDose");
            put(8,"totalVaccinationsPerHundred");
            put(9, "personsVaccinatedPlusDosePerHundred");
            put(10, "personsFullyVaccinated");
            put(11, "personsFullyVaccinatedPerHundred");
            put(12, "vaccinesUsed");
            put(13, "firstVaccineDate");
            put(14,"numberVaccinesTypesUsed");
        }
    };
    @Autowired(required = false)
    private VaccinationDataMapper vaccinationDataMapper;
    @Override
    public List<SimpleReturnDataVO> findRequiredDataForChart(List<Integer> columnsToBeVisited, List<String> countryName) {
        Collections.sort(columnsToBeVisited);
        List<SimpleReturnDataVO> returnDataVOList = new ArrayList<>();
        String groupColumnName = "country";
        for(String curCountry:countryName){
            SimpleReturnDataVO simpleReturnDataVO = new SimpleReturnDataVO();
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq(groupColumnName,curCountry);
            VaccinationData vaccinationData = vaccinationDataMapper.selectOne(wrapper);
            List<SingleAttributeVO> singleAttributeVOList = new ArrayList<>();
            for(int i = 0;i<columnsToBeVisited.size();i++) {
                SingleAttributeVO singleAttributeVO = new SingleAttributeVO();
                Integer index = columnsToBeVisited.get(i);
                String columnName = columnNamesMap.get(index);
                singleAttributeVO.setName(columnName);
                singleAttributeVO.setVal(vaccinationData.getColumnByIndex(index));
                singleAttributeVOList.add(singleAttributeVO);
            }
            simpleReturnDataVO.setCountryName(curCountry);
            simpleReturnDataVO.setAttributeList(singleAttributeVOList);
            returnDataVOList.add(simpleReturnDataVO);
        }
        return returnDataVOList;
    }

    @Override
    public List<String> getNames() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("distinct country");
        List<VaccinationData> dataList = vaccinationDataMapper.selectList(queryWrapper);
        List<String> nameList = new ArrayList<>();
        for (VaccinationData vaccinationData: dataList){
            nameList.add(vaccinationData.getCountry());
        }
        return nameList;
    }

    @Override
    public List<VaccinationData> getAllData() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<VaccinationData> dataList = vaccinationDataMapper.selectList(queryWrapper);
        return dataList;
    }

    @Override
    public List<ColNameAndIndex> getColNameAndIndex() {
        List<ColNameAndIndex> colNameAndIndexList = new ArrayList<>();
        for(int i = 1;i<columnNamesMap.size();i++){
            if (i!=1&i!=2&i!=3&i!=4&i!=5&i!=12&i!=13){
                ColNameAndIndex colNameAndIndex = new ColNameAndIndex();
                colNameAndIndex.setName(columnNamesMap.get(i));
                colNameAndIndex.setIndex(i);
                colNameAndIndexList.add(colNameAndIndex);
            }
        }
        return colNameAndIndexList;
    }
}
