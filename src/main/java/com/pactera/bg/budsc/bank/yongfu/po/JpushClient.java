package com.pactera.bg.budsc.bank.yongfu.po;

public class JpushClient {

  private String registrationId;
  private String notificationTitle;
  private String msgTitle;
  private String msgContent;
  private String extrasParam;

  public String getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
  }

  public String getNotificationTitle() {
    return notificationTitle;
  }

  public void setNotificationTitle(String notificationTitle) {
    this.notificationTitle = notificationTitle;
  }

  public String getMsgTitle() {
    return msgTitle;
  }

  public void setMsgTitle(String msgTitle) {
    this.msgTitle = msgTitle;
  }

  public String getMsgContent() {
    return msgContent;
  }

  public void setMsgContent(String msgContent) {
    this.msgContent = msgContent;
  }

  public String getExtrasParam() {
    return extrasParam;
  }

  public void setExtrasParam(String extrasParam) {
    this.extrasParam = extrasParam;
  }
}