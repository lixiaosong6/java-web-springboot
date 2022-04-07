package com.sale.dao;

import java.util.List;

import com.sale.bean.SaleDetail;

public interface SaleDetailDao {
  List<SaleDetail> selectSaleDetailList(SaleDetail saleDetail);

  int updateSaleDetail(SaleDetail saleDetail);
}
