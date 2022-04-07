package com.sale.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sale.bean.ChackInfo;
import com.sale.bean.SaleDayCount;
import com.sale.bean.SaleDetail;
import com.sale.bean.SaleMonthCount;
import com.sale.bean.SaleOrderInfo;
import com.sale.bean.SalePayInfo;
import com.sale.controller.TestController;
import com.sale.dao.ChackInfoDao;
import com.sale.dao.SaleDayCountDao;
import com.sale.dao.SaleDetailDao;
import com.sale.dao.SaleMonthCountDao;
import com.sale.dao.SaleOrderInfoDao;
import com.sale.dao.SalePayInfoDao;
import com.sale.util.DateUtil;

@Component
public class DayCountTask {

  @Autowired
  SalePayInfoDao salePayInfoDao;
  @Autowired
  SaleOrderInfoDao saleOrderInfoDao;
  @Autowired
  SaleDayCountDao saleDayCountDao;
  @Autowired
  SaleDetailDao saleDetailDao;
  @Autowired
  ChackInfoDao chackInfoDao;
  @Autowired
  SaleMonthCountDao saleMonthCountDao;

  private final static Logger logger = LoggerFactory.getLogger(TestController.class);

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    logger.info("现在时间：" + DateUtil.getCompleteTime());
    logger.info("当前时间：" + DateUtil.getCompleteTime());
  }

  // 业务员行为日统计
  // @Scheduled(fixedDelay = 100000) // 每10s执行1次
  public void send() {
    SaleOrderInfo saleOrderInfo = new SaleOrderInfo();
    saleOrderInfo.setCreate_date(DateUtil.getOtherDate(-1, "yyyyMMdd"));
    saleOrderInfo.setFee_status("1");// 1 已返佣
    List<SaleOrderInfo> saleOrderInfos = saleOrderInfoDao.querySaleOrderInfoBySaleId(saleOrderInfo);
    for (SaleOrderInfo saleOrderInfo2 : saleOrderInfos) {
      SaleDayCount saleDayCount = new SaleDayCount();
      saleDayCount.setCount_date(DateUtil.getDate());
      saleDayCount.setCreate_time(DateUtil.getCompleteTime());
      saleDayCount.setSale_id(saleOrderInfo2.getSale_id());
      saleDayCount.setCount_type("01");
      saleDayCount.setP_id(saleOrderInfo2.getP_id());
      saleDayCount.setSale_num(saleOrderInfo2.getTotal_count());
      saleDayCount.setSale_fee(saleOrderInfo2.getUser_amt_1());
      saleDayCount.setSys_mer_id(saleOrderInfo2.getSys_mer_id());
      saleDayCountDao.insertSaleDayCount(saleDayCount);
    }

    List<SaleOrderInfo> saleOrderInfos1 = saleOrderInfoDao
        .querySaleOrderInfoByTeamL1Id(saleOrderInfo);

    for (SaleOrderInfo saleOrderInfo2 : saleOrderInfos1) {
      if (StringUtils.isEmpty(saleOrderInfo2.getTeam_l1_id())
          || "0".equals(saleOrderInfo2.getTeam_l2_id())) {
        continue;
      }

      SaleDayCount saleDayCount = new SaleDayCount();
      saleDayCount.setSale_id(saleOrderInfo2.getTeam_l1_id());
      saleDayCount.setSale_num_l1(saleOrderInfo2.getTotal_count());
      saleDayCount.setSale_fee_l1(saleOrderInfo2.getUser_amt_2());
      int result = saleDayCountDao.update(saleDayCount);
      if (0 == result) {
        SaleDayCount sdc = new SaleDayCount();
        sdc.setCount_date(DateUtil.getDate());
        sdc.setCreate_time(DateUtil.getCompleteTime());
        sdc.setSale_id(saleOrderInfo2.getTeam_l1_id());
        sdc.setSale_num("0");
        sdc.setSale_fee("0");
        sdc.setCount_type("01");
        sdc.setP_id(saleOrderInfo2.getP_id());
        sdc.setSale_num_l1(saleOrderInfo2.getTotal_count());
        sdc.setSale_fee_l1(saleOrderInfo2.getUser_amt_2());
        sdc.setSys_mer_id(saleOrderInfo2.getSys_mer_id());
        saleDayCountDao.insertSaleDayCount(sdc);
      }
    }

    List<SaleOrderInfo> saleOrderInfos2 = saleOrderInfoDao
        .querySaleOrderInfoByTeamL2Id(saleOrderInfo);
    for (SaleOrderInfo saleOrderInfo2 : saleOrderInfos2) {
      if (StringUtils.isEmpty(saleOrderInfo2.getTeam_l2_id())
          || "0".equals(saleOrderInfo2.getTeam_l2_id())) {
        continue;
      }

      SaleDayCount saleDayCount = new SaleDayCount();
      saleDayCount.setSale_id(saleOrderInfo2.getTeam_l2_id());
      saleDayCount.setSale_num_l2(saleOrderInfo2.getTotal_count());
      saleDayCount.setSale_fee_l2(saleOrderInfo2.getUser_amt_3());
      int result = saleDayCountDao.update(saleDayCount);
      if (0 == result) {
        SaleDayCount sdc = new SaleDayCount();
        sdc.setCount_date(DateUtil.getDate());
        sdc.setCreate_time(DateUtil.getCompleteTime());
        sdc.setSale_id(saleOrderInfo2.getTeam_l2_id());
        sdc.setSale_num("0");
        sdc.setSale_fee("0");
        sdc.setCount_type("01");
        sdc.setP_id(saleOrderInfo2.getP_id());
        sdc.setSale_num_l2(saleOrderInfo2.getTotal_count());
        sdc.setSale_fee_l2(saleOrderInfo2.getUser_amt_3());
        sdc.setSys_mer_id(saleOrderInfo2.getSys_mer_id());
        saleDayCountDao.insertSaleDayCount(sdc);
      }
    }

    SalePayInfo salePayInfo = new SalePayInfo();
    salePayInfo.setPay_status("1");// 1 支付成功
    salePayInfo.setSettle_date(DateUtil.getOtherDate(-1, "yyyyMMdd"));
    List<SalePayInfo> salePayInfos = salePayInfoDao.querySalePayInfoBySaleId(salePayInfo);
    for (SalePayInfo salePayInfo2 : salePayInfos) {
      SaleDayCount saleDayCount = new SaleDayCount();
      saleDayCount.setCount_date(DateUtil.getDate());
      saleDayCount.setCreate_time(DateUtil.getCompleteTime());
      saleDayCount.setSale_id(salePayInfo2.getSale_id());
      saleDayCount.setCount_type("02");
      // saleDayCount.setP_id(salePayInfo2.getP_id());
      saleDayCount.setSale_num(salePayInfo2.getTotal_count());
      saleDayCount.setSale_fee(salePayInfo2.getUser_amt_1());
      saleDayCount.setSys_mer_id(salePayInfo2.getSys_mer_id());
      saleDayCountDao.insertSaleDayCount(saleDayCount);
    }
    List<SalePayInfo> salePayInfos1 = salePayInfoDao.querySalePayInfoByTeamL1Id(salePayInfo);
    for (SalePayInfo salePayInfo2 : salePayInfos1) {
      if (StringUtils.isEmpty(salePayInfo2.getTeam_l1_id())
          || "0".equals(salePayInfo2.getTeam_l2_id())) {
        continue;
      }
      SaleDayCount saleDayCount = new SaleDayCount();
      saleDayCount.setSale_id(salePayInfo2.getTeam_l1_id());
      saleDayCount.setSale_num_l1(salePayInfo2.getTotal_count());
      saleDayCount.setSale_fee_l1(salePayInfo2.getUser_amt_2());
      int result = saleDayCountDao.update(saleDayCount);
      if (0 == result) {
        SaleDayCount sdc = new SaleDayCount();
        sdc.setCount_date(DateUtil.getDate());
        sdc.setCreate_time(DateUtil.getCompleteTime());
        sdc.setSale_id(salePayInfo2.getTeam_l1_id());
        sdc.setSale_num("0");
        sdc.setSale_fee("0");
        sdc.setCount_type("01");
        saleDayCount.setSale_num_l1(salePayInfo2.getTotal_count());
        saleDayCount.setSale_fee_l1(salePayInfo2.getUser_amt_2());
        sdc.setSys_mer_id(salePayInfo2.getSys_mer_id());
        saleDayCountDao.insertSaleDayCount(sdc);
      }
    }

    List<SalePayInfo> salePayInfos2 = salePayInfoDao.querySalePayInfoByTeamL2Id(salePayInfo);
    for (SalePayInfo salePayInfo2 : salePayInfos2) {
      if (StringUtils.isEmpty(salePayInfo2.getTeam_l2_id())
          || "0".equals(salePayInfo2.getTeam_l2_id())) {
        continue;
      }
      SaleDayCount saleDayCount = new SaleDayCount();
      saleDayCount.setSale_id(salePayInfo2.getTeam_l2_id());
      saleDayCount.setSale_num_l2(salePayInfo2.getTotal_count());
      saleDayCount.setSale_fee_l2(salePayInfo2.getUser_amt_3());
      int result = saleDayCountDao.update(saleDayCount);
      if (0 == result) {
        SaleDayCount sdc = new SaleDayCount();
        sdc.setCount_date(DateUtil.getDate());
        sdc.setCreate_time(DateUtil.getCompleteTime());
        sdc.setSale_id(salePayInfo2.getTeam_l2_id());
        sdc.setSale_num("0");
        sdc.setSale_fee("0");
        sdc.setCount_type("01");
        saleDayCount.setSale_num_l2(salePayInfo2.getTotal_count());
        saleDayCount.setSale_fee_l2(salePayInfo2.getUser_amt_3());
        sdc.setSys_mer_id(salePayInfo2.getSys_mer_id());
        saleDayCountDao.insertSaleDayCount(sdc);
      }
    }
  }

  //
  // @Scheduled(cron = "0 */1 * * * ?")
  public void currentTime() {
    SaleDetail saleDetail = new SaleDetail();
    saleDetail.setCheck_e_date(DateUtil.getDate());
    saleDetail.setCheck_status("1");
    List<SaleDetail> saleDetails = saleDetailDao.selectSaleDetailList(saleDetail);
    for (SaleDetail saleDetail2 : saleDetails) {

      Boolean falg = false;

      ChackInfo chackInfo = new ChackInfo();
      chackInfo.setSale_type("04");
      chackInfo = chackInfoDao.getChackInfo(chackInfo);

      Map<String, String> map = new HashMap<>();
      map.put("startTime", saleDetail2.getCheck_s_date());
      map.put("endTime", saleDetail2.getCheck_e_date());
      map.put("count_type", "01");// 01 营销产品统计
      map.put("sale_id", saleDetail2.getSale_id());
      SaleDayCount saleDayCount = saleDayCountDao.selectSaleDayCount(map);
      if (null != saleDayCount) {

        if (Long.parseLong(saleDayCount.getSale_num()) >= Long
            .parseLong(chackInfo.getBus_count())) {
          falg = true;
        } else {
          map.put("count_type", "02");// 02 拓展团员统计
          SaleDayCount sdc = saleDayCountDao.selectSaleDayCount(map);
          if (null != sdc) {
            if (Long.parseLong(sdc.getSale_num()) >= Long.parseLong(chackInfo.getUser_count())) {
              falg = true;
            }
          }
        }
      } else {
        map.put("count_type", "02");// 02 拓展团员统计
        SaleDayCount sdc = saleDayCountDao.selectSaleDayCount(map);
        if (null != sdc) {
          if (Long.parseLong(sdc.getSale_num()) >= Long.parseLong(chackInfo.getUser_count())) {
            falg = true;
          }
        }
      }
      if (falg)
        saleDetail2.setCheck_status("2");
      else
        saleDetail2.setCheck_status("3");

      saleDetailDao.updateSaleDetail(saleDetail2);
    }
  }

  // 每天统计在当月的这一天是否达到有效人力
  public void currentTime2() {
    SaleDetail saleDetail = new SaleDetail();
    saleDetail.setCheck_e_date(DateUtil.getDate());
    saleDetail.setCheck_status("1");
    List<SaleDetail> saleDetails = saleDetailDao.selectSaleDetailList(saleDetail);
    for (SaleDetail saleDetail2 : saleDetails) {

      Boolean falg = false;

      ChackInfo chackInfo = new ChackInfo();
      chackInfo.setSale_type("05");
      chackInfo = chackInfoDao.getChackInfo(chackInfo);

      Map<String, String> map = new HashMap<>();
      map.put("startTime", DateUtil.getCompleteTime("yyyyMM") + "00000000");
      map.put("endTime", DateUtil.getCompleteTime());
      map.put("count_type", "01");// 01 营销产品统计
      map.put("sale_id", saleDetail2.getSale_id());
      SaleDayCount saleDayCount = saleDayCountDao.selectSaleDayCount(map);
      if (null != saleDayCount) {
        if (Long.parseLong(saleDayCount.getSale_num()) >= Long
            .parseLong(chackInfo.getBus_count())) {
          falg = true;
        }
      }
      if (falg)
        saleDetail2.setCheck_status("2");
      else
        saleDetail2.setCheck_status("3");

      saleDetailDao.updateSaleDetail(saleDetail2);

      SaleDayCount sdc = new SaleDayCount();

      if (falg)
        sdc.setValid("1");
      else
        sdc.setValid("0");
      sdc.setSale_id(saleDayCount.getSale_id());
      sdc.setCount_date(DateUtil.getOtherDate(-1, "yyyyMMdd"));
      saleDayCountDao.update(sdc);
    }
  }

  @Scheduled(cron = "0 */1 * * * ?")
  public void task2() {
    Map<String, String> map = new HashMap<>();
    map.put("date", DateUtil.getLastMonth());
    map.put("count_type", "01");// 01 营销产品统计
    List<SaleDayCount> saleDayCounts = saleDayCountDao.selectWithMonth(map);
    for (SaleDayCount saleDayCount : saleDayCounts) {
      SaleMonthCount saleMonthCount = new SaleMonthCount();
      saleMonthCount.setCount_date(DateUtil.getDate());
      saleMonthCount.setCreate_time(DateUtil.getTime());
      saleMonthCount.setSale_id(saleDayCount.getSale_id());
      saleMonthCount.setCount_type("01");
      saleMonthCount.setP_id(saleDayCount.getP_id());
      saleMonthCount.setSale_num(saleDayCount.getSale_num());
      saleMonthCount.setSale_fee(saleDayCount.getSale_fee());
      saleMonthCount.setSale_num_l1(saleDayCount.getSale_num_l1());
      saleMonthCount.setSale_fee_l1(saleDayCount.getSale_fee_l1());
      saleMonthCount.setSale_num_l2(saleDayCount.getSale_num_l2());
      saleMonthCount.setSale_fee_l2(saleDayCount.getSale_fee_l2());
      // saleMonthCount.setTeam_l1_id(saleDayCount.get);
      // saleMonthCount.setTeam_l2_id(team_l2_id);
      saleMonthCount.setSys_mer_id(saleDayCount.getSys_mer_id());

      ChackInfo chackInfo = new ChackInfo();
      chackInfo.setSale_type("05");
      chackInfo = chackInfoDao.getChackInfo(chackInfo);
      if (Long.parseLong(chackInfo.getBus_count()) <= Long.parseLong(saleDayCount.getSale_num()))
        saleMonthCount.setValid("1");
      else
        saleMonthCount.setValid("0");
      saleMonthCountDao.insert(saleMonthCount);
    }

    map.put("count_type", "02");// 02 拓展团员统计
    List<SaleDayCount> sdc = saleDayCountDao.selectWithMonth(map);
    for (SaleDayCount saleDayCount : sdc) {
      SaleMonthCount saleMonthCount = new SaleMonthCount();
      saleMonthCount.setCount_date(DateUtil.getDate());
      saleMonthCount.setCreate_time(DateUtil.getTime());
      saleMonthCount.setSale_id(saleDayCount.getSale_id());
      saleMonthCount.setCount_type("02");
      saleMonthCount.setP_id(saleDayCount.getP_id());
      saleMonthCount.setSale_num(saleDayCount.getSale_num());
      saleMonthCount.setSale_fee(saleDayCount.getSale_fee());
      saleMonthCount.setSale_num_l1(saleDayCount.getSale_num_l1());
      saleMonthCount.setSale_fee_l1(saleDayCount.getSale_fee_l1());
      saleMonthCount.setSale_num_l2(saleDayCount.getSale_num_l2());
      saleMonthCount.setSale_fee_l2(saleDayCount.getSale_fee_l2());
      // saleMonthCount.setTeam_l1_id(saleDayCount.get);
      // saleMonthCount.setTeam_l2_id(team_l2_id);
      saleMonthCount.setSys_mer_id(saleDayCount.getSys_mer_id());

      saleMonthCountDao.insert(saleMonthCount);
    }
  }
}
