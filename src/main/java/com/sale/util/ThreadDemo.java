package com.sale.util;

class MyThread extends Thread {

  private String name;

  public MyThread(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 200; i++) {
      System.out.println(i + ">>>>" + name);
    }
  }
}

public class ThreadDemo {
  public static void main(String[] args) {
    MyThread t = new MyThread("A");
    MyThread t1 = new MyThread("B");
    MyThread t2 = new MyThread("C");

    t.start();
    t1.start();
    t2.start();
  }
}
