package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sale.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test3 {

  @Test // properties
  public void properties() {
    System.out.println("1");
  }

 
}
