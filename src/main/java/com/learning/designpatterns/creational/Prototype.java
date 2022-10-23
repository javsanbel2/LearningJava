package com.learning.designpatterns.creational;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

class Point
{
  public int x, y;

  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public Point clone() {
    return new Point(x, y);
  }

  @Override
  public String toString() {
    return String.format("Point{x:%s, y:%s}", x, y);
  }
}

class Line implements Serializable
{
  public Point start, end;

  public Line(Point start, Point end)
  {
    this.start = start;
    this.end = end;
  }

  public Line deepCopy() {
    return new Line(start.clone(), end.clone());
  }

  public Line serializationCopy() {
    return SerializationUtils.clone(this);
  }

  @Override
  public String toString() {
    return String.format("Line{\n%s,\n%s\n}", start, end);
  }
}

class PrototypeDemo {
  public static void main(String[] args) {
    Line line1 = new Line(new Point(1,2), new Point(2, 3));
    Line line2 = line1.deepCopy();
    line2.end.x = 100;
    Line line3 = line1.deepCopy();
    line3.end.x = 200;

    System.out.println(line1);
    System.out.println(line2);
    System.out.println(line3);
  }
}

