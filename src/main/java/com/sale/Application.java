package com.sale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

// 指定扫描的包路径
@SpringBootApplication
@EnableScheduling // 发现注解@Scheduled的任务并后台执行
@MapperScan(basePackages = {"com.sale.mapper"})
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
    //1、创建FastJson信息转换对象
    FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
    //2、创建FastJsonConfig对象并设定序列化规则  序列化规则详见SerializerFeature类中，后面会讲
    FastJsonConfig fastJsonConfig= new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteNonStringKeyAsString);
    //本人就坑在WriteNonStringKeyAsString 将不是String类型的key转换成String类型，否则前台无法将Json字符串转换成Json对象

    //3、中文乱码解决方案
    List<MediaType> fastMedisTypes = new ArrayList<MediaType>();
    fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定Json格式且编码为utf-8
    fastConverter.setSupportedMediaTypes(fastMedisTypes);
    //4、将转换规则应用于转换对象
    fastConverter.setFastJsonConfig(fastJsonConfig);
    return new HttpMessageConverters(fastConverter);
  }

  public static void main(String[] args) {
    System.setProperty("spring.devtools.restart.enabled", "false");// 热部署开关
    SpringApplication.run(Application.class, args);
  }

}