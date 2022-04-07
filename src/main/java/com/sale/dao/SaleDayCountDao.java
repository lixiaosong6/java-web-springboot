package com.sale.dao;

import java.util.List;
import java.util.Map;

import com.sale.bean.SaleDayCount;

/**
 * 
 * @Description:
 * @Author: muzi
 * @Date: 2018年9月10日 下午4:11:48
 */
public interface SaleDayCountDao {
  int insertSaleDayCount(SaleDayCount saleDayCount);

  int update(SaleDayCount saleDayCount);

  int updateWithDate(SaleDayCount saleDayCount);

  SaleDayCount selectSaleDayCount(Map<String, String> map);

  List<SaleDayCount> selectWithMonth(Map<String, String> map);
}
