package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.CovidData;
import com.southwind.mapper.CovidDataMapper;
import com.southwind.service.CovidDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-12-17
 */
@Service
public class CovidDataServiceImpl extends ServiceImpl<CovidDataMapper, CovidData> implements CovidDataService {
    HashMap<Integer,String> columnNamesMap = new HashMap<>(){
        {
            put(1,"isoCode");
            put(2,"continent");
            put(3,"location");
            put(4,"date");
            put(5,"totalCases");
            put(6,"newCases");
            put(7,"newCasesSmoothed");
            put(8,"totalDeaths");
            put(9,"newDeaths");
            put(10,"newDeathsSmoothed");
            put(11,"totalCasesPerMillion");
            put(12,"newCasesPerMillion");
            put(13,"newCasesSmoothedPerMillion");
            put(14,"totalDeathsPerMillion");
            put(15,"newDeathsPerMillion");
            put(16,"newDeathsSmoothedPerMillion");
            put(17,"reproductionRate");
            put(18,"icuPatients");
            put(19,"icuPatientsPerMillion");
            put(20,"hospPatients");
            put(21,"hospPatientsPerMillion");
            put(22,"weeklyIcuAdmissions");
            put(23,"weeklyIcuAdmissionsPerMillion");
            put(24,"weeklyHospAdmissions");
            put(25,"weeklyHospAdmissionsPerMillion");
            put(26,"newTests");
            put(27,"totalTests");
            put(28,"totalTestsPerThousand");
            put(29,"newTestsPerThousand");
            put(30,"newTestsSmoothed");
            put(31,"newTestsSmoothedPerThousand");
            put(32,"positiveRate");
            put(33,"testsPerCase");
            put(34,"testsUnits");
            put(35,"totalVaccinations");
            put(36,"peopleVaccinated");
            put(37,"peopleFullyVaccinated");
            put(38,"totalBoosters");
            put(39,"newVaccinations");
            put(40,"newVaccinationsSmoothed");
            put(41,"totalVaccinationsPerHundred");
            put(42,"peopleVaccinatedPerHundred");
            put(43,"peopleFullyVaccinatedPerHundred");
            put(44,"totalBoostersPerHundred");
            put(45,"newVaccinationsSmoothedPerMillion");
            put(46,"stringencyIndex");
            put(47,"population");
            put(48,"populationDensity");
            put(49,"medianAge");
            put(50,"aged65Older");
            put(51,"aged70Older");
            put(52,"gdpPerCapita");
            put(53,"extremePoverty");
            put(54,"cardiovascDeathRate");
            put(55,"diabetesPrevalence");
            put(56,"femaleSmokers");
            put(57,"maleSmokers");
            put(58,"handwashingFacilities");
            put(59,"hospitalBedsPerThousand");
            put(60,"lifeExpectancy");
            put(61,"humanDevelopmentIndex");
            put(62,"excessMortalityCumulative");
            put(63,"excessMortalityCumulativeAbsolute");
            put(64,"excessMortality");
            put(65,"excessMortalityCumulativePerMillion");
            put(66,"ID");
        }
    };
    @Autowired(required = false)
    private CovidDataMapper covidDataMapper;
    /*
    @Override
    public HashMap<String, List<CountryAndCasesVO>> findAllCasesByCountry(List<String> country) {
        HashMap<String,List<CountryAndCasesVO>> res = new HashMap<>();
        for(String curCountry:country){
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("location",curCountry);
            wrapper.ge("date","2021-10-25");
            List<CovidData> covidDataList = covidDataMapper.selectList(wrapper);
            List<CountryAndCasesVO> countryAndCasesVOList = new ArrayList<>();
            for (CovidData covidData : covidDataList){
                CountryAndCasesVO countryAndCasesVO = new CountryAndCasesVO();
                countryAndCasesVO.setDate(covidData.getDate());
                countryAndCasesVO.setNewCase(covidData.getNewCases());
                countryAndCasesVO.setTotalCase(covidData.getTotalCases());
                countryAndCasesVOList.add(countryAndCasesVO);
            }
            res.put(curCountry,countryAndCasesVOList);
        }
        return res;
    }

     */

    @Override
    public List<ReturnDataVO> findRequiredDataForChart(List<Integer> columnsToBeVisited, List<String> countryName, LocalDate date, Integer duration) {
        Collections.sort(columnsToBeVisited);
        List<ReturnDataVO> returnDataVOList = new ArrayList<>();
        String groupColumnName = "location";

        for(String curCountry:countryName){
            ReturnDataVO returnDataVO = new ReturnDataVO();
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq(groupColumnName,curCountry);
            wrapper.ge("date",date.toString());
            wrapper.lt("date",date.plusDays(duration).toString());
            List<CovidData> covidDataList = covidDataMapper.selectList(wrapper);
            List<List<SingleAttributeVO>> singleDayDataVOList = new ArrayList<>();
            for (CovidData covidData : covidDataList){
                //SingleDayDataVO singleDayDataVO = new SingleDayDataVO();
                List<SingleAttributeVO> singleAttributeVOList = new ArrayList<>();
                SingleAttributeVO dateAttribute = new SingleAttributeVO();
                dateAttribute.setName("date");
                dateAttribute.setVal(covidData.getColumnByIndex(4));
                singleAttributeVOList.add(dateAttribute);
                for(int i = 0;i<columnsToBeVisited.size();i++) {
                    SingleAttributeVO singleAttributeVO = new SingleAttributeVO();
                    Integer index = columnsToBeVisited.get(i);
                    String columnName = columnNamesMap.get(index);
                    singleAttributeVO.setName(columnName);
                    singleAttributeVO.setVal(covidData.getColumnByIndex(index));
                    singleAttributeVOList.add(singleAttributeVO);
                }
                singleDayDataVOList.add(singleAttributeVOList);
            }
            returnDataVO.setCountryName(curCountry);
            returnDataVO.setSingleDayDataVOList(singleDayDataVOList);
            returnDataVOList.add(returnDataVO);
        }
        return returnDataVOList;
    }

    @Override
    public List<String> getNames() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("distinct location");
        List<CovidData> dataList = covidDataMapper.selectList(queryWrapper);
        List<String> nameList = new ArrayList<>();
        for (CovidData curData: dataList){
            nameList.add(curData.getLocation());
        }
        return nameList;

    }

    @Override
    public List<CovidData> getAllDataInOneDay(LocalDate date) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("date",date.toString());
        List<CovidData> dataList = covidDataMapper.selectList(queryWrapper);
        return dataList;
    }

    @Override
    public List<ColNameAndIndex> getColNameAndIndex() {
        List<ColNameAndIndex> colNameAndIndexList = new ArrayList<>();
        for(int i = 1;i<columnNamesMap.size();i++){
            if (i!=1&i!=2&i!=3&i!=4&i!=34){
                ColNameAndIndex colNameAndIndex = new ColNameAndIndex();
                colNameAndIndex.setName(columnNamesMap.get(i));
                colNameAndIndex.setIndex(i);
                colNameAndIndexList.add(colNameAndIndex);
            }
        }
        return colNameAndIndexList;
    }
}
