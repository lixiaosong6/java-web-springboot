package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import com.sale.Application;

//@RunWith(SpringJUnit4ClassRunner.class) //// SpringJUnit支持，由此引入Spring-Test框架支持！
//@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
//@WebAppConfiguration /// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test1 {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  /**
   * 邮件构造
   */
  @Autowired
  private JavaMailSender mailSender;

  // public ApplicationTests(RestTemplateBuilder restTemplateBuilder) {
  // this.restTemplate = restTemplateBuilder.build();
  // }

  @Resource(name = "stringRedisTemplate")
  ValueOperations<Object, Object> valOps;

  public static void main(String[] args) {
  }

  @Test // redis
  public void test2() throws Exception {
    stringRedisTemplate.opsForValue().set("key", "333");
    System.out.println(stringRedisTemplate.opsForValue().get("key"));
    System.out.println(valOps.get("key"));
  }

  // @Test//
  // public Details someRestCall(String name) {
  // return this.restTemplate.getForObject("/{name}/details", Details.class,
  // name);
  // }

  @Test // mail
  public void sendSimpleEmail() {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("360211323@qq.com");// 发送者.
    message.setTo("996416660@qq.com");// 接收者.
    message.setSubject("测试邮件（邮件主题）");// 邮件主题.
    message.setText("这是邮件内容");// 邮件内容.
    mailSender.send(message);// 发送邮件
  }
}
