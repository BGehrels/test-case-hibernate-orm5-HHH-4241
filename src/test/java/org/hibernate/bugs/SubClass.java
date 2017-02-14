package org.hibernate.bugs;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.Tables;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import java.math.BigDecimal;

@DiscriminatorValue("1")
@Entity
@SecondaryTables({
  @SecondaryTable(name = "mandatory_table"),
  @SecondaryTable(name = "energy_certificates", pkJoinColumns = @PrimaryKeyJoinColumn(name = "REAL_ESTATE_ID"))
})
@Tables({
  @Table(appliesTo = "mandatory_table", fetch = FetchMode.SUBSELECT, optional = false),
  @Table(appliesTo = "energy_certificates", fetch = FetchMode.SUBSELECT, optional = true)
})
public class SubClass extends BaseClass {
  @Column(name = "mandatoryTableField", table = "MANDATORY_TABLE")
  private BigDecimal mandatoryTableField;

  @Column(name = "OPTIONAL_TABLE_FIELD", table = "energy_certificates")
  private Integer optionalTableField;

  public BigDecimal getMandatoryTableField() {
    return mandatoryTableField;
  }

  public void setMandatoryTableField(BigDecimal parkingSpacePrice) {
    this.mandatoryTableField = parkingSpacePrice;
  }
}
