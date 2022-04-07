package com.sale.bean;

import java.io.Serializable;

public class SaleDayCount implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String d_count_id;
  private String count_date;
  private String create_time;
  private String sale_id;
  private String count_type;
  private String p_id;
  private String sale_num;
  private String sale_fee;
  private String sale_num_l1;
  private String sale_fee_l1;
  private String sale_num_l2;
  private String sale_fee_l2;
  private String sys_mer_id;
  private String valid;

  public String getD_count_id() {
    return d_count_id;
  }

  public void setD_count_id(String d_count_id) {
    this.d_count_id = d_count_id;
  }

  public String getCount_date() {
    return count_date;
  }

  public void setCount_date(String count_date) {
    this.count_date = count_date;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public String getSale_id() {
    return sale_id;
  }

  public void setSale_id(String sale_id) {
    this.sale_id = sale_id;
  }

  public String getCount_type() {
    return count_type;
  }

  public void setCount_type(String count_type) {
    this.count_type = count_type;
  }

  public String getP_id() {
    return p_id;
  }

  public void setP_id(String p_id) {
    this.p_id = p_id;
  }

  public String getSale_num() {
    return sale_num;
  }

  public void setSale_num(String sale_num) {
    this.sale_num = sale_num;
  }

  public String getSale_fee() {
    return sale_fee;
  }

  public void setSale_fee(String sale_fee) {
    this.sale_fee = sale_fee;
  }

  public String getSale_num_l1() {
    return sale_num_l1;
  }

  public void setSale_num_l1(String sale_num_l1) {
    this.sale_num_l1 = sale_num_l1;
  }

  public String getSale_fee_l1() {
    return sale_fee_l1;
  }

  public void setSale_fee_l1(String sale_fee_l1) {
    this.sale_fee_l1 = sale_fee_l1;
  }

  public String getSale_num_l2() {
    return sale_num_l2;
  }

  public void setSale_num_l2(String sale_num_l2) {
    this.sale_num_l2 = sale_num_l2;
  }

  public String getSale_fee_l2() {
    return sale_fee_l2;
  }

  public void setSale_fee_l2(String sale_fee_l2) {
    this.sale_fee_l2 = sale_fee_l2;
  }

  public String getSys_mer_id() {
    return sys_mer_id;
  }

  public void setSys_mer_id(String sys_mer_id) {
    this.sys_mer_id = sys_mer_id;
  }

  public String getValid() {
    return valid;
  }

  public void setValid(String valid) {
    this.valid = valid;
  }

}
