package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.CovidData;
import com.southwind.entity.WhoCovid19GlobalTableData;
import com.southwind.mapper.WhoCovid19GlobalTableDataMapper;
import com.southwind.service.WhoCovid19GlobalTableDataService;
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
public class WhoCovid19GlobalTableDataServiceImpl extends ServiceImpl<WhoCovid19GlobalTableDataMapper, WhoCovid19GlobalTableData> implements WhoCovid19GlobalTableDataService {
    HashMap<Integer,String> columnNamesMap = new HashMap<>(){
        {
            put(1, "name");
            put(2, "whoRegion");
            put(3, "casesCumulativeTotal");
            put(4, "casesCumulativeTotalPer100000Population");
            put(5, "casesNewlyReportedInLast7Days");
            put(6, "casesNewlyReportedInLast7DaysPer100000Population");
            put(7, "casesNewlyReportedInLast24Hours");
            put(8, "deathsCumulativeTotal");
            put(9, "deathsNewlyReportedInLast7Days");
            put(10, "deathsCumulativeTotalPer100000Population");
            put(11, "deathsNewlyReportedInLast7DaysPer100000Population");
            put(12, "deathsNewlyReportedInLast24Hours");
        }
    };
    @Autowired(required = false)
    private WhoCovid19GlobalTableDataMapper whoCovid19GlobalTableDataMapper;

    @Override
    public List<SimpleReturnDataVO> findRequiredDataForChart(List<Integer> columnsToBeVisited, List<String> countryName) {
        Collections.sort(columnsToBeVisited);
        List<SimpleReturnDataVO> returnDataVOList = new ArrayList<>();
        String groupColumnName = "name";
        for(String curCountry:countryName){
            SimpleReturnDataVO simpleReturnDataVO = new SimpleReturnDataVO();
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq(groupColumnName,curCountry);
            WhoCovid19GlobalTableData whoCovid19GlobalTableData = whoCovid19GlobalTableDataMapper.selectOne(wrapper);
            List<SingleAttributeVO> singleAttributeVOList = new ArrayList<>();
            for(int i = 0;i<columnsToBeVisited.size();i++) {
                SingleAttributeVO singleAttributeVO = new SingleAttributeVO();
                Integer index = columnsToBeVisited.get(i);
                String columnName = columnNamesMap.get(index);
                singleAttributeVO.setName(columnName);
                singleAttributeVO.setVal(whoCovid19GlobalTableData.getColumnByIndex(index));
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
        queryWrapper.select("distinct name");
        List<WhoCovid19GlobalTableData> dataList = whoCovid19GlobalTableDataMapper.selectList(queryWrapper);
        List<String> nameList = new ArrayList<>();
        for (WhoCovid19GlobalTableData whoCovid19GlobalTableData: dataList){
            nameList.add(whoCovid19GlobalTableData.getName());
        }
        return nameList;
    }

    @Override
    public List<WhoCovid19GlobalTableData> getAllData() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<WhoCovid19GlobalTableData> dataList = whoCovid19GlobalTableDataMapper.selectList(queryWrapper);
        return dataList;
    }

    @Override
    public List<ColNameAndIndex> getColNameAndIndex() {
        List<ColNameAndIndex> colNameAndIndexList = new ArrayList<>();
        for(int i = 1;i<columnNamesMap.size();i++){
            if (i!=1&i!=2){
                ColNameAndIndex colNameAndIndex = new ColNameAndIndex();
                colNameAndIndex.setName(columnNamesMap.get(i));
                colNameAndIndex.setIndex(i);
                colNameAndIndexList.add(colNameAndIndex);
            }
        }
        return colNameAndIndexList;
    }
}
