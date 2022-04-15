package com.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.learning.proxy.mockLibrary.People;
import com.learning.proxy.mockLibrary.Teacher;

public class Main {
  public static void main(String[] args) {
    People normalTeacher = new Teacher();
    People superHeroTeacher = SuperHeroTeacher.of("Carlos", 50.0, 80);


    System.out.println("Normal teacher");
    System.out.println(normalTeacher.work());
    System.out.println("===========");
    System.out.println("Super Hero Teacher");
    System.out.println(superHeroTeacher.work());

  }
}
