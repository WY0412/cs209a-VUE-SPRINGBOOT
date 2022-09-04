package com.southwind.service;

import com.southwind.entity.CovidData;
import com.southwind.entity.WhoCovid19GlobalTableData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.vo.ColNameAndIndex;
import com.southwind.vo.ReturnDataVO;
import com.southwind.vo.SimpleReturnDataVO;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-12-19
 */
public interface WhoCovid19GlobalTableDataService extends IService<WhoCovid19GlobalTableData> {
    List<SimpleReturnDataVO> findRequiredDataForChart(List<Integer> columnsToBeVisited, List<String> countryName);
    List<String> getNames();
    List<WhoCovid19GlobalTableData> getAllData();
    List<ColNameAndIndex> getColNameAndIndex();
}
