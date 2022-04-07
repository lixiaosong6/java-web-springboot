package com.sale.dao;

import java.util.List;

import com.sale.bean.SaleOrderInfo;

public interface SaleOrderInfoDao {
  List<SaleOrderInfo> querySaleOrderInfoBySaleId(SaleOrderInfo saleOrderInfo);

  List<SaleOrderInfo> querySaleOrderInfoByTeamL1Id(SaleOrderInfo saleOrderInfo);

  List<SaleOrderInfo> querySaleOrderInfoByTeamL2Id(SaleOrderInfo saleOrderInfo);
}
