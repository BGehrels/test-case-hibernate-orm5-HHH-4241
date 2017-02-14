package org.hibernate.bugs;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.INTEGER)
@Entity
@Inheritance(strategy = SINGLE_TABLE)
@Table(name = "BASE_CLASS")
public abstract class BaseClass {

  @Column(name = "ID")
  @GeneratedValue
  @Id
  private Long id;

  public Long getId() {
    return id;
  }
}
