package com.learning.proxy.mockLibrary;

public class Teacher implements People {

  @Override
  public String work() {
    System.out.println("[Teacher] Just another day as a teacher");
    return "[Return] teaching";
  }

}
