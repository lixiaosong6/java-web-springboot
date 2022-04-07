package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.sale.service.TestService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test2 {
  @Autowired
  TestService testService;

  @Resource
  private RedisTemplate<String, String> redisTemplate;

  @Test // Redis
  public void redis() {
    redisTemplate.opsForValue().set("key2", "444");
    System.out.println(redisTemplate.opsForValue().get("key2"));
  }

  @Test // hibernate.jdbcTemplate
  public void hibernate() {
  }
}
