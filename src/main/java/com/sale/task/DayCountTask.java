package com.sale.task;

import com.sale.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.sale.controller.UserController;
import com.sale.util.DateUtil;

@Component
public class DayCountTask {

  @Autowired
  StudentMapper studentMapper;

  private final static Logger logger = LoggerFactory.getLogger(UserController.class);

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    logger.info("现在时间：" + DateUtil.getCompleteTime());
    logger.info("当前时间：" + DateUtil.getCompleteTime());
  }
}
