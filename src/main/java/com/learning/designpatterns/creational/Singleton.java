package com.learning.designpatterns.creational;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * Since implementing a singleton is easy, you have a different challenge: write a method called isSingleton() .
 * This method takes a factory method that returns an object and it's up to you to determine
 * whether or not that object is a singleton instance.
 */
class SingletonChecker {
  public static boolean isSingleton(Supplier<Object> func) {
    Object obj = func.get();
    List<Constructor<?>> constructors = Arrays.stream(obj.getClass().getDeclaredConstructors()).collect(Collectors.toList());
    boolean hasPrivateConstructor = constructors.size() == 1 && constructors.get(0).toString().startsWith("private");
    boolean hasGetInstanceMethod = Arrays.stream(obj.getClass().getDeclaredMethods())
        .anyMatch(method -> method.getName().equals("getInstance") && method.getReturnType().equals(obj.getClass()));

    return hasPrivateConstructor && hasGetInstanceMethod;
  }
}

class Singleton {
  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return INSTANCE;
  }
}

class NonSingleton {
  String name;

  public NonSingleton(String name) {
    this.name = name;
  }
}

class SingletonTest {
  @Test
  public void testSingletonCheckerForSingleton() {
    Singleton singleton = Singleton.getInstance();
    assertTrue(SingletonChecker.isSingleton(() -> singleton));
  }

  @Test
  public void testSingletonCheckerForNonSingleton() {
    NonSingleton nonSingleton = new NonSingleton("name");
    assertFalse(SingletonChecker.isSingleton(() -> nonSingleton));
  }
}
