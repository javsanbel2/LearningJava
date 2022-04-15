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

// OUTPUT:

//    Normal teacher
//      [Teacher] Just another day as a teacher
//      [Return] teaching
//    ===========
//    Super Hero Teacher
//      [Teacher] Just another day as a teacher
//      What a day! These kids are killing me, at least I earned some money and have 150.0. 79 years more and I retire!
//      [Return] teaching

  }
}
