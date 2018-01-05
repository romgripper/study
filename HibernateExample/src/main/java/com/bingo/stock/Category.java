package com.bingo.stock;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

  private Integer categoryId;
  private String name;
  private String desc;
  private Set<Stock> stocks = new HashSet<>();

  public Category() {}

  public Category(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CATEGORY_ID", unique = true, nullable = false)
  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  @Column(name = "NAME", nullable = false, length = 10)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Since 'DESC' is a SQL keyword, it should be quoted
  @Column(name = "`DESC`", nullable = false)
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
  public Set<Stock> getStocks() {
    return stocks;
  }

  public void setStocks(Set<Stock> stocks) {
    this.stocks = stocks;
  }

  @Override
  public String toString() {
    return "Category [" + categoryId + ", " + name + ", " + desc + "]";
  }
}
