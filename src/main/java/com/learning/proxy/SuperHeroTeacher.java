package com.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.learning.proxy.mockLibrary.People;
import com.learning.proxy.mockLibrary.Teacher;

public class SuperHeroTeacher {

  static final Class<?>[] INTERFACES = new Class<?>[] { People.class };

  private static class SuperHeroTeacherHandler implements InvocationHandler {
    // I add some parameters to the teacher
    private Object teacher;
    private String name;
    private Double money;
    private Integer yearsToRetire;

    private SuperHeroTeacherHandler(Object teacher, String name, Double money, Integer yearsToRetire) {
      this.teacher = teacher;
      this.name = name;
      this.money = money;
      this.yearsToRetire = yearsToRetire;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      // Method in teacher (mockLibrary) has been invoked.
      Object invoke = method.invoke(teacher, args);

      // We make sure the method is invoked is "work"
      if (method.getName().equals("work")) {
        if (yearsToRetire <= 1) {
          System.out.printf("Your Super hero finished all his obligations! Now he can retire and live with %s dollars!! \n", money);
        } else {
          yearsToRetire -= 1; // he really hate work
          money += 100;
          System.out.printf("What a day! These kids are killing me, at least I earned some money and have %s. %s years more and I retire! \n", money, yearsToRetire);
        }
      }
      return invoke;
    }
  }

  public static People of(String name, Double money, Integer yearsToRetire) {
    People teacher = new Teacher();
    SuperHeroTeacherHandler superHeroTeacherHandler = new SuperHeroTeacherHandler(teacher, name, money, yearsToRetire);
    return (People) Proxy.newProxyInstance(teacher.getClass().getClassLoader(), INTERFACES, superHeroTeacherHandler);
  }


}
