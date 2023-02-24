package com.learning.designpatterns.creational;

class Person
{
  public int id;
  public String name;

  public Person(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public String toString() {
    return String.format("Person {id: %s, name: %s}", id, name);
  }
}

class PersonFactory {
  private int count = 0;

  public Person createPerson(String name) {
    return new Person(count++, name);
  }
}

class Human {
  public String name;

  private Human(String name) {
    this.name = name;
  }

  public static class Factory {
    public static Human fromName(String name) {
      return new Human(name);
    }
  }

  public String toString() {
    return String.format("Human {name: %s}", name);
  }
}

class Demo {
  public static void main(String[] args) {
    PersonFactory pf = new PersonFactory();
    Person javi = pf.createPerson("Javi");
    Person jose = pf.createPerson("Jose");

    System.out.println(javi);
    System.out.println(jose);

    // Nested factory
    Human deliveryGuy = Human.Factory.fromName("pedro");
    System.out.println(deliveryGuy);

  }
}
