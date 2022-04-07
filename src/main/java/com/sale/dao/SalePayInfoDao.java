package com.sale.dao;

import java.util.List;

import com.sale.bean.SalePayInfo;

public interface SalePayInfoDao {
  /**
   * 
   * @Description:
   * @Auther: muzi
   * @Date: 2018年9月10日 下午5:13:12
   */
  List<SalePayInfo> querySalePayInfoBySaleId(SalePayInfo salePayInfo);

  List<SalePayInfo> querySalePayInfoByTeamL1Id(SalePayInfo salePayInfo);

  List<SalePayInfo> querySalePayInfoByTeamL2Id(SalePayInfo salePayInfo);
}
