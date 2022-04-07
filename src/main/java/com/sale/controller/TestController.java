package com.sale.controller;

import com.sale.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 
 * @Description:
 * @Author: muzi
 * @Date: 2017年3月29日 下午4:35:39
 */
// @RestController
// @EnableAutoConfiguration
@Controller
public class TestController {

  // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
  @Value("${application.hello:Hello Angel}")
  private String hello;

  private final static Logger logger = LoggerFactory.getLogger(TestController.class);

  @RequestMapping("/")
  String home(Map<String, Object> model) {
    model.put("hello", hello);
    logger.info(DateUtil.getCompleteTime());
    return "hello";
    // ModelAndView mv = new ModelAndView("index");
    // return mv;
  }

  @RequestMapping("/modelview")
  ModelAndView modelview() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("hello");
    mav.addObject("hello", "helloModelview");
    return mav;
    // ModelAndView mv = new ModelAndView("index");
    // return mv;
  }

  @RequestMapping("/hello/{myName}")
  @ResponseBody
  String index(@PathVariable String myName) {
    return "Hello " + myName + "!!!";
  }

  /**
   * 异常
   * 
   * @Description:
   * @Auther: muzi
   * @Date: 2017年4月5日 下午2:06:33
   */
  @RequestMapping("/zeroException")
  public int zeroException() {
    return 100 / 1;
  }

  /**
   * H5
   * 
   * @Description:
   * @Auther: muzi
   * @Date: 2017年4月5日 下午2:06:33
   */
  @RequestMapping("/regist")
  public String regist() {
    return "regist";
  }

  /**
   * login(shiro)
   * 
   * @Description:
   * @Auther: muzi
   * @Date: 2017年4月5日 下午2:06:33
   */
  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  /**
   * login(shiro)
   * 
   * @Description:
   * @Auther: muzi
   * @Date: 2017年4月5日 下午2:06:33
   */
  @RequestMapping("/loginIng")
  public String loginIng(String username, String password) {
    System.out.println("username=" + username);
    System.out.println("password=" + password);
    return "index";
  }

  @RequestMapping("/index")
  public String index() {
    return "index";
  }

  @RequestMapping("/chart")
  public String chart() {
    return "chart1";
  }

}
