package com.yesipchuk.demo.modelJDBC;

public class TypeOfUsing {
  private Long id;
  private String type_of_using;

  public TypeOfUsing(Long id, String type_of_using) {
    this.id = id;
    this.type_of_using = type_of_using;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType_of_using() {
    return type_of_using;
  }

  public void setType_of_using(String type_of_using) {
    this.type_of_using = type_of_using;
  }
}