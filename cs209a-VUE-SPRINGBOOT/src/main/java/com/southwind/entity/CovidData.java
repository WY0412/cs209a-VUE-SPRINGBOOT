package com.southwind.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-12-17
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CovidData implements Serializable {

    private static final long serialVersionUID=1L;
    //1
    private String isoCode;
    //2
    private String continent;
    //3
    private String location;
    //4
    private LocalDate date;
    //5
    private Double totalCases;
    //6
    private Double newCases;
    //7
    private Double newCasesSmoothed;
    //8
    private Double totalDeaths;
    //9
    private Double newDeaths;
    //10
    private Double newDeathsSmoothed;
    //11
    private Double totalCasesPerMillion;
    //12
    private Double newCasesPerMillion;
    //13
    private Double newCasesSmoothedPerMillion;
    //14
    private Double totalDeathsPerMillion;
    //15
    private Double newDeathsPerMillion;
    //16
    private Double newDeathsSmoothedPerMillion;
    //17
    private Double reproductionRate;
    //18
    private Double icuPatients;
    //19
    private Double icuPatientsPerMillion;
    //20
    private Double hospPatients;
    //21
    private Double hospPatientsPerMillion;
    //22
    private Double weeklyIcuAdmissions;
    //23
    private Double weeklyIcuAdmissionsPerMillion;
    //24
    private Double weeklyHospAdmissions;
    //25
    private Double weeklyHospAdmissionsPerMillion;
    //26
    private Double newTests;
    //27
    private Double totalTests;

    private Double totalTestsPerThousand;

    private Double newTestsPerThousand;

    private Double newTestsSmoothed;

    private Double newTestsSmoothedPerThousand;

    private Double positiveRate;

    private Double testsPerCase;

    private String testsUnits;

    private Double totalVaccinations;

    private Double peopleVaccinated;

    private Double peopleFullyVaccinated;

    private Double totalBoosters;

    private Double newVaccinations;

    private Double newVaccinationsSmoothed;

    private Double totalVaccinationsPerHundred;

    private Double peopleVaccinatedPerHundred;

    private Double peopleFullyVaccinatedPerHundred;

    private Double totalBoostersPerHundred;

    private Double newVaccinationsSmoothedPerMillion;

    private Double stringencyIndex;

    private Double population;

    private Double populationDensity;

    private Double medianAge;

    @TableField(value = "aged_65_older")
    private Double aged65Older;
    @TableField(value = "aged_70_older")
    private Double aged70Older;

    private Double gdpPerCapita;

    private Double extremePoverty;

    private Double cardiovascDeathRate;

    private Double diabetesPrevalence;

    private Double femaleSmokers;

    private Double maleSmokers;

    private Double handwashingFacilities;

    private Double hospitalBedsPerThousand;

    private Double lifeExpectancy;

    private Double humanDevelopmentIndex;

    private Double excessMortalityCumulative;

    private Double excessMortalityCumulativeAbsolute;

    private Double excessMortality;

    private Double excessMortalityCumulativePerMillion;

    @TableField("ID")
    private Integer id;

    public Object getColumnByIndex(Integer index){
      switch (index){
        case 1:
          return isoCode;
        case 2:
          return continent;
        case 3:
          return location;
        case 4:
          return date;
        case 5:
          return totalCases;
        case 6:
          return newCases;
        case 7:
          return newCasesSmoothed;
        case 8:
          return totalDeaths;
        case 9:
          return newDeaths;
        case 10:
          return newDeathsSmoothed;
        case 11:
          return totalCasesPerMillion;
        case 12:
          return newCasesPerMillion;
        case 13:
          return newCasesSmoothedPerMillion;
        case 14:
          return totalDeathsPerMillion;
        case 15:
          return newDeathsPerMillion;
        case 16:
          return newDeathsSmoothedPerMillion;
        case 17:
          return reproductionRate;
        case 18:
          return icuPatients;
        case 19:
          return icuPatientsPerMillion;
        case 20:
          return hospPatients;
        case 21:
          return hospPatientsPerMillion;
        case 22:
          return weeklyIcuAdmissions;
        case 23:
          return weeklyIcuAdmissionsPerMillion;
        case 24:
          return weeklyHospAdmissions;
        case 25:
          return weeklyHospAdmissionsPerMillion;
        case 26:
          return newTests;
        case 27:
          return totalTests;
        case 28:
          return totalTestsPerThousand;
        case 29:
          return newTestsPerThousand;
        case 30:
          return newTestsSmoothed;
        case 31:
          return newTestsSmoothedPerThousand;
        case 32:
          return positiveRate;
        case 33:
          return testsPerCase;
        case 34:
          return testsUnits;
        case 35:
          return totalVaccinations;
        case 36:
          return peopleVaccinated;
        case 37:
          return peopleFullyVaccinated;
        case 38:
          return totalBoosters;
        case 39:
          return newVaccinations;
        case 40:
          return newVaccinationsSmoothed;
        case 41:
          return totalVaccinationsPerHundred;
        case 42:
          return peopleVaccinatedPerHundred;
        case 43:
          return peopleFullyVaccinatedPerHundred;
        case 44:
          return totalBoostersPerHundred;
        case 45:
          return newVaccinationsSmoothedPerMillion;
        case 46:
          return stringencyIndex;
        case 47:
          return population;
        case 48:
          return populationDensity;
        case 49:
          return medianAge;
        case 50:
          return aged65Older;
        case 51:
          return aged70Older;
        case 52:
          return gdpPerCapita;
        case 53:
          return extremePoverty;
        case 54:
          return cardiovascDeathRate;
        case 55:
          return diabetesPrevalence;
        case 56:
          return femaleSmokers;
        case 57:
          return maleSmokers;
        case 58:
          return handwashingFacilities;
        case 59:
          return hospitalBedsPerThousand;
        case 60:
          return lifeExpectancy;
        case 61:
          return humanDevelopmentIndex;
        case 62:
          return excessMortalityCumulative;
        case 63:
          return excessMortalityCumulativeAbsolute;
        case 64:
          return excessMortality;
        case 65:
          return excessMortalityCumulativePerMillion;
        case 66:
          return id;
      }
      return null;

    }

}
