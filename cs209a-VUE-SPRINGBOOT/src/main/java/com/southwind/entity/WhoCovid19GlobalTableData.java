package com.southwind.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-12-19
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class WhoCovid19GlobalTableData implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

    @TableField("WHO_region")
    private String whoRegion;

    private Integer casesCumulativeTotal;
    @TableField("cases_cumulative_total_per_100000_population")
    private Double casesCumulativeTotalPer100000Population;
    @TableField("cases_newly_reported_in_last_7_days")
    private Integer casesNewlyReportedInLast7Days;
    @TableField("cases_newly_reported_in_last_7_days_per_100000_population")
    private Double casesNewlyReportedInLast7DaysPer100000Population;
    @TableField("cases_newly_reported_in_last_24_hours")
    private Integer casesNewlyReportedInLast24Hours;

    private Integer deathsCumulativeTotal;
    @TableField("deaths_newly_reported_in_last_7_days")
    private Integer deathsNewlyReportedInLast7Days;
    @TableField("deaths_cumulative_total_per_100000_population")
    private Double deathsCumulativeTotalPer100000Population;
    @TableField("deaths_newly_reported_in_last_7_days_per_100000_population")
    private Double deathsNewlyReportedInLast7DaysPer100000Population;
    @TableField("deaths_newly_reported_in_last_24_hours")
    private Integer deathsNewlyReportedInLast24Hours;

    public Object getColumnByIndex(Integer index){
      switch (index){
        case 1:
          return name;
        case 2:
          return whoRegion;
        case 3:
          return casesCumulativeTotal;
        case 4:
          return casesCumulativeTotalPer100000Population;
        case 5:
          return casesNewlyReportedInLast7Days;
        case 6:
          return casesNewlyReportedInLast7DaysPer100000Population;
        case 7:
          return casesNewlyReportedInLast24Hours;
        case 8:
          return deathsCumulativeTotal;
        case 9:
          return deathsNewlyReportedInLast7Days;
        case 10:
          return deathsCumulativeTotalPer100000Population;
        case 11:
          return deathsNewlyReportedInLast7DaysPer100000Population;
        case 12:
          return deathsNewlyReportedInLast24Hours;
      }
      return null;
    }
}
