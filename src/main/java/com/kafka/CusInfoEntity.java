/*
package com.kafka;


import javax.persistence.*;

@Entity
@Table(name="CUS_INFO")
public class CusInfoEntity extends BaseEntity {


  @Id
  @Column(name="CUS_NUM")
  private String CUS_NUM;

  @Column(name="HOST_CUS_NUM")
  private String HOST_CUS_NUM;

  @Column(name="CUS_NAME")
  private String CUS_NAME;

  @Column(name="CUS_TYPE")
  private String CUS_TYPE;

  @Column(name="CRE_TYPE")
  private String CRE_TYPE;

  @Column(name="CRE_NUM")
  private String CRE_NUM;

  @Column(name="CUS_LEV")
  private String CUS_LEV;

  @Column(name="VIP_FLAG")
  private String VIP_FLAG;

  @Column(name="BRT_DAY")
  private String BRT_DAY;

  @Column(name="SEX")
  private String SEX;

  @Column(name="PHONE_NO")
  private String PHONE_NO;

  @Column(name="TEL_NO")
  private String TEL_NO;

  @Column(name="EMAIL")
  private String EMAIL;

  @Column(name="FAX_NO")
  private String FAX_NO;

  @Column(name="POSTCODE")
  private String POSTCODE;

  @Column(name="ADDRESS")
  private String ADDRESS;

  @Column(name="EDUCATION")
  private String EDUCATION;

  @Column(name="POLITY_FACE")
  private String POLITY_FACE;

  @Column(name="LEGAL_PER_CRE_NUM")
  private String LEGAL_PER_CRE_NUM;

  @Column(name="LEGAL_PER_NAME")
  private String LEGAL_PER_NAME;

  @Column(name="LEGAL_PER_CRE_TYPE")
  private String LEGAL_PER_CRE_TYPE;

  @Column(name="EFFECT_FLAG")
  private String EFFECT_FLAG;

  @Column(name="CREATE_USER")
  private String CREATE_USER;

  @Column(name="CREATE_DATE")
  private String CREATE_DATE;

  @Column(name="CREATE_TIME")
  private String CREATE_TIME;

  @Column(name="LST_MNT_USER")
  private String LST_MNT_USER;

  @Column(name="LST_MNT_DATE")
  private String LST_MNT_DATE;

  @Column(name="LST_MNT_TIME")
  private String LST_MNT_TIME;

  @Column(name="REMARK")
  private String REMARK;

  @Column(name="DEBT_FLAG")
  private String DEBT_FLAG;


  public String getCusNum() {
    return this.cusNum;
  }

  public void setCusNum(String cusNum) {
    this.cusNum = cusNum;
  }

  public String getHostCusNum() {
    return this.hostCusNum;
  }

  public void setHostCusNum(String hostCusNum) {
    this.hostCusNum = hostCusNum;
  }

  public String getCusName() {
    return this.cusName;
  }

  public void setCusName(String cusName) {
    this.cusName = cusName;
  }

  public String getCusType() {
    return this.cusType;
  }

  public void setCusType(String cusType) {
    this.cusType = cusType;
  }

  public String getCreType() {
    return this.creType;
  }

  public void setCreType(String creType) {
    this.creType = creType;
  }

  public String getCreNum() {
    return this.creNum;
  }

  public void setCreNum(String creNum) {
    this.creNum = creNum;
  }

  public String getCusLev() {
    return this.cusLev;
  }

  public void setCusLev(String cusLev) {
    this.cusLev = cusLev;
  }

  public String getVipFlag() {
    return this.vipFlag;
  }

  public void setVipFlag(String vipFlag) {
    this.vipFlag = vipFlag;
  }

  public String getBrtDay() {
    return this.brtDay;
  }

  public void setBrtDay(String brtDay) {
    this.brtDay = brtDay;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPhoneNo() {
    return this.phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getTelNo() {
    return this.telNo;
  }

  public void setTelNo(String telNo) {
    this.telNo = telNo;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFaxNo() {
    return this.faxNo;
  }

  public void setFaxNo(String faxNo) {
    this.faxNo = faxNo;
  }

  public String getPostcode() {
    return this.postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEducation() {
    return this.education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getPolityFace() {
    return this.polityFace;
  }

  public void setPolityFace(String polityFace) {
    this.polityFace = polityFace;
  }

  public String getLegalPerCreNum() {
    return this.legalPerCreNum;
  }

  public void setLegalPerCreNum(String legalPerCreNum) {
    this.legalPerCreNum = legalPerCreNum;
  }

  public String getLegalPerName() {
    return this.legalPerName;
  }

  public void setLegalPerName(String legalPerName) {
    this.legalPerName = legalPerName;
  }

  public String getLegalPerCreType() {
    return this.legalPerCreType;
  }

  public void setLegalPerCreType(String legalPerCreType) {
    this.legalPerCreType = legalPerCreType;
  }

  public String getEffectFlag() {
    return this.effectFlag;
  }

  public void setEffectFlag(String effectFlag) {
    this.effectFlag = effectFlag;
  }

  public String getCreateUser() {
    return this.createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getCreateDate() {
    return this.createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getLstMntUser() {
    return this.lstMntUser;
  }

  public void setLstMntUser(String lstMntUser) {
    this.lstMntUser = lstMntUser;
  }

  public String getLstMntDate() {
    return this.lstMntDate;
  }

  public void setLstMntDate(String lstMntDate) {
    this.lstMntDate = lstMntDate;
  }

  public String getLstMntTime() {
    return this.lstMntTime;
  }

  public void setLstMntTime(String lstMntTime) {
    this.lstMntTime = lstMntTime;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getDebtFlag() {
    return this.debtFlag;
  }

  public void setDebtFlag(String debtFlag) {
    this.debtFlag = debtFlag;
  }
}
*/
