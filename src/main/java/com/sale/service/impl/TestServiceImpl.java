package com.sale.service.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sale.service.TestService;

/**
 * 
 * @Description:
 * @Author: muzi
 * @Date: 2017年3月29日 下午4:39:23
 */
@Service
public class TestServiceImpl implements TestService {

  @Resource // 使用JdbcTemplate
  private JdbcTemplate jdbcTemplate;

}
