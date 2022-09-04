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
 * @since 2021-12-19
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class VaccinationData implements Serializable {

    private static final long serialVersionUID=1L;

    private String country;

    @TableField("ISO3")
    private String iso3;

    @TableField("WHO_region")
    private String whoRegion;

    private String dataSource;

    private LocalDate dateUpdated;

    private Integer totalVaccinations;

    private Integer personsVaccinatedPerDose;

    private Double totalVaccinationsPerHundred;

    private Double personsVaccinatedPlusDosePerHundred;

    private Integer personsFullyVaccinated;

    private Double personsFullyVaccinatedPerHundred;

    private String vaccinesUsed;

    private LocalDate firstVaccineDate;

    private Integer numberVaccinesTypesUsed;


    public Object getColumnByIndex(Integer index){
      switch (index){
        case 1:
          return country;
        case 2:
          return iso3;
        case 3:
          return whoRegion;
        case 4:
          return dataSource;
        case 5:
          return dateUpdated;
        case 6:
          return totalVaccinations;
        case 7:
          return personsVaccinatedPerDose;
        case 8:
          return totalVaccinationsPerHundred;
        case 9:
          return personsVaccinatedPlusDosePerHundred;
        case 10:
          return personsFullyVaccinated;
        case 11:
          return personsFullyVaccinatedPerHundred;
        case 12:
          return vaccinesUsed;
        case 13:
          return firstVaccineDate;
        case 14:
          return numberVaccinesTypesUsed;

      }
      return null;
    }
}
