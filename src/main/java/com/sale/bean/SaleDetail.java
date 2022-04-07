package com.sale.bean;

public class SaleDetail {
  private String sale_id;
  private String team_num;
  private String team_max_num;
  private String check_status;
  private String check_s_date;
  private String check_e_date;

  public String getSale_id() {
    return sale_id;
  }

  public void setSale_id(String sale_id) {
    this.sale_id = sale_id;
  }

  public String getTeam_num() {
    return team_num;
  }

  public void setTeam_num(String team_num) {
    this.team_num = team_num;
  }

  public String getTeam_max_num() {
    return team_max_num;
  }

  public void setTeam_max_num(String team_max_num) {
    this.team_max_num = team_max_num;
  }

  public String getCheck_status() {
    return check_status;
  }

  public void setCheck_status(String check_status) {
    this.check_status = check_status;
  }

  public String getCheck_s_date() {
    return check_s_date;
  }

  public void setCheck_s_date(String check_s_date) {
    this.check_s_date = check_s_date;
  }

  public String getCheck_e_date() {
    return check_e_date;
  }

  public void setCheck_e_date(String check_e_date) {
    this.check_e_date = check_e_date;
  }

}
