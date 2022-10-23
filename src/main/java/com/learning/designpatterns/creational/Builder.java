package com.learning.designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

import com.learning.utils.Tuple;

// I could also use a class that defines a CodeElement. But I created a Tuple so, I can use it in other exercises.
class CodeBuilder {
    private String className;
    private List<Tuple<String, String>> elements = new ArrayList<>();

    public CodeBuilder(String className) {
      this.className = className;
    }

    public CodeBuilder addField(String variableName, String type) {
      this.elements.add(new Tuple<>(type, variableName));
      return this;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("public class ").append(className).append("\n");
      sb.append("{\n");
      elements.stream().forEach(e -> {
        sb.append(String.format("  public %s %s;\n", e.x, e.y));
      });
      sb.append("}");

      return sb.toString();
    }
}

class Test {
  public static void main(String[] args) {
    CodeBuilder cb = new CodeBuilder("Person");
    cb.addField("name", "String").addField("age", "int");
    System.out.println(cb);
  }
}
