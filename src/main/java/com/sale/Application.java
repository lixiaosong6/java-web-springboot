package com.sale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

// 指定扫描的包路径
//@ComponentScan("com.lijialiang.*")
//same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
@EnableScheduling // 发现注解@Scheduled的任务并后台执行
@MapperScan("com.sale.dao")
@ServletComponentScan // 这个就是扫描相应的Servlet包;
// @EnableAsync //开启通过异步调用的方式来并发执行

// @ImportResource(locations = {"classpath:consumer-risk.xml" })//dubbo(不能开热部署)

// @ComponentScan(basePackages = {
// "com.lijialiang.*", "com.risk.*" })
public class Application {

  /**
   * 使用fastJson
   * 
   * @Description:
   * @Auther: muzi
   * @Date: 2022年04月07日10:49:43
   */
  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {
    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    fastConverter.setFastJsonConfig(fastJsonConfig);
    HttpMessageConverter<?> converter = fastConverter;
    return new HttpMessageConverters(converter);
  }

  public static void main(String[] args) {
    System.setProperty("spring.devtools.restart.enabled", "false");// 热部署开关
    SpringApplication.run(Application.class, args);
  }

}