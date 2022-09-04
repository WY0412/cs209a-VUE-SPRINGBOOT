package com.southwind.service;

import com.southwind.entity.CovidData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.vo.ColNameAndIndex;
import com.southwind.vo.ReturnDataVO;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-12-17
 */
public interface CovidDataService extends IService<CovidData> {
    //HashMap<String, List<CountryAndCasesVO>> findAllCasesByCountry(List<String> country);
    List<ReturnDataVO> findRequiredDataForChart(List<Integer> columnsToBeVisited,List<String> countryName, LocalDate date,Integer duration);
    List<String> getNames();
    List<CovidData> getAllDataInOneDay(LocalDate date);
    List<ColNameAndIndex> getColNameAndIndex();
}
