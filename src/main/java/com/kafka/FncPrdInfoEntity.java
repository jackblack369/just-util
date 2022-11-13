/*
package com.kafka;


import javax.persistence.*;

@Entity
@Table(name="FNC_PRD_INFO")
public class FncPrdInfoEntity extends BaseEntity {


  @Id
  @Column(name="TA_NO")
  private String TA_NO;

  @Id
  @Column(name="PRD_NO")
  private String PRD_NO;

  @Column(name="PRD_ID")
  private String PRD_ID;

  @Column(name="PRD_NAME")
  private String PRD_NAME;

  @Column(name="FIRST_CONSIGN_ORG_NO")
  private String FIRST_CONSIGN_ORG_NO;

  @Column(name="PRD_SOURCE")
  private String PRD_SOURCE;

  @Column(name="CONSIGN_FLAG")
  private String CONSIGN_FLAG;

  @Column(name="DISTRI_FLAG")
  private String DISTRI_FLAG;

  @Column(name="ISSUE_ORG_NO")
  private String ISSUE_ORG_NO;

  @Column(name="PRD_TYPE")
  private String PRD_TYPE;

  @Column(name="PROFIT_FLAG")
  private String PROFIT_FLAG;

  @Column(name="RISK_LEV")
  private String RISK_LEV;

  @Column(name="FORCE_BUY_FLAG")
  private String FORCE_BUY_FLAG;

  @Column(name="ESTABLISH_FLAG")
  private String ESTABLISH_FLAG;

  @Column(name="LIFECYCLE")
  private String LIFECYCLE;

  @Column(name="CYY")
  private String CYY;

  @Column(name="TRUSTEE_NO")
  private String TRUSTEE_NO;

  @Column(name="IS_SUSPEND_FLAG")
  private String IS_SUSPEND_FLAG;

  @Column(name="IS_PRIVATE_FLAG")
  private String IS_PRIVATE_FLAG;

  @Column(name="BASIS")
  private String BASIS;

  @Column(name="PROP_RATE_MIN")
  private String PROP_RATE_MIN;

  @Column(name="PROP_RATE_MAX")
  private String PROP_RATE_MAX;

  @Column(name="IS_BOOK")
  private String IS_BOOK;

  @Column(name="NO_COUNTER_MAX_BOOK")
  private String NO_COUNTER_MAX_BOOK;

  @Column(name="BOOK_START_DATE")
  private String BOOK_START_DATE;

  @Column(name="BOOK_START_TIME")
  private String BOOK_START_TIME;

  @Column(name="BOOK_END_DATE")
  private String BOOK_END_DATE;

  @Column(name="BOOK_END_TIME")
  private String BOOK_END_TIME;

  @Column(name="SUB_CAPITAL_MODE")
  private String SUB_CAPITAL_MODE;

  @Column(name="RAISE_CANCLE_FLAG")
  private String RAISE_CANCLE_FLAG;

  @Column(name="NO_COUNTER_CANCELF_LAG")
  private String NO_COUNTER_CANCELF_LAG;

  @Column(name="RAISE_START_DATE")
  private String RAISE_START_DATE;

  @Column(name="RAISE_START_TIME")
  private String RAISE_START_TIME;

  @Column(name="RAISE_END_DATE")
  private String RAISE_END_DATE;

  @Column(name="RAISE_END_TIME")
  private String RAISE_END_TIME;

  @Column(name="ESTABLISH_DATE")
  private String ESTABLISH_DATE;

  @Column(name="VALUE_DATE")
  private String VALUE_DATE;

  @Column(name="MATU_DATE")
  private String MATU_DATE;

  @Column(name="CLR_PAY_DAY")
  private String CLR_PAY_DAY;

  @Column(name="LIQU_FLAG")
  private String LIQU_FLAG;

  @Column(name="PLAN_RAISE_AMT_MAX")
  private String PLAN_RAISE_AMT_MAX;

  @Column(name="PLAN_RAISE_AMT_MIN")
  private String PLAN_RAISE_AMT_MIN;

  @Column(name="SSUM_BUY_MAX")
  private String SSUM_BUY_MAX;

  @Column(name="ISUM_BUY_MAX")
  private String ISUM_BUY_MAX;

  @Column(name="SSUB_START_AMT")
  private String SSUB_START_AMT;

  @Column(name="SSUP_SUB_AMT")
  private String SSUP_SUB_AMT;

  @Column(name="ISUB_START_AMT")
  private String ISUB_START_AMT;

  @Column(name="ISUP_SUB_AMT")
  private String ISUP_SUB_AMT;

  @Column(name="DECLARE_START_DATE")
  private String DECLARE_START_DATE;

  @Column(name="DECLARE_START_TIME")
  private String DECLARE_START_TIME;

  @Column(name="DECLARE_MATU_DATE")
  private String DECLARE_MATU_DATE;

  @Column(name="DECLARE_MATU_TIME")
  private String DECLARE_MATU_TIME;

  @Column(name="ACT_PRJ_NO")
  private String ACT_PRJ_NO;

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

  @Column(name="TERM")
  private String TERM;

  @Column(name="TERM_TYPE")
  private String TERM_TYPE;

  @Column(name="COLLECT_CAPITAL_STATUS")
  private String COLLECT_CAPITAL_STATUS;

  @Column(name="FORCE_COLL_ESTAB_FLAG")
  private String FORCE_COLL_ESTAB_FLAG;

  @Column(name="ESTAB_FAIL_CAPITAL_STATUS")
  private String ESTAB_FAIL_CAPITAL_STATUS;

  @Column(name="ENDPAY_CAPITAL_STATUS")
  private String ENDPAY_CAPITAL_STATUS;

  @Column(name="MAIN_PRD_NO")
  private String MAIN_PRD_NO;

  @Column(name="INTER_START_AMT")
  private String INTER_START_AMT;

  @Column(name="INTER_SUB_AMT")
  private String INTER_SUB_AMT;

  @Column(name="INTER_BUY_MAX")
  private String INTER_BUY_MAX;

  @Column(name="SINGLE_FLAG")
  private String SINGLE_FLAG;

  @Column(name="IS_REDEEM_FLAG")
  private String IS_REDEEM_FLAG;

  @Column(name="PLAN_TYPE")
  private String PLAN_TYPE;

  @Column(name="PERF_BENCH")
  private String PERF_BENCH;

  @Column(name="EXCESS_PREF_ALL_RATIO")
  private String EXCESS_PREF_ALL_RATIO;


  public String getTaNo() {
    return this.taNo;
  }

  public void setTaNo(String taNo) {
    this.taNo = taNo;
  }

  public String getPrdNo() {
    return this.prdNo;
  }

  public void setPrdNo(String prdNo) {
    this.prdNo = prdNo;
  }

  public String getPrdId() {
    return this.prdId;
  }

  public void setPrdId(String prdId) {
    this.prdId = prdId;
  }

  public String getPrdName() {
    return this.prdName;
  }

  public void setPrdName(String prdName) {
    this.prdName = prdName;
  }

  public String getFirstConsignOrgNo() {
    return this.firstConsignOrgNo;
  }

  public void setFirstConsignOrgNo(String firstConsignOrgNo) {
    this.firstConsignOrgNo = firstConsignOrgNo;
  }

  public String getPrdSource() {
    return this.prdSource;
  }

  public void setPrdSource(String prdSource) {
    this.prdSource = prdSource;
  }

  public String getConsignFlag() {
    return this.consignFlag;
  }

  public void setConsignFlag(String consignFlag) {
    this.consignFlag = consignFlag;
  }

  public String getDistriFlag() {
    return this.distriFlag;
  }

  public void setDistriFlag(String distriFlag) {
    this.distriFlag = distriFlag;
  }

  public String getIssueOrgNo() {
    return this.issueOrgNo;
  }

  public void setIssueOrgNo(String issueOrgNo) {
    this.issueOrgNo = issueOrgNo;
  }

  public String getPrdType() {
    return this.prdType;
  }

  public void setPrdType(String prdType) {
    this.prdType = prdType;
  }

  public String getProfitFlag() {
    return this.profitFlag;
  }

  public void setProfitFlag(String profitFlag) {
    this.profitFlag = profitFlag;
  }

  public String getRiskLev() {
    return this.riskLev;
  }

  public void setRiskLev(String riskLev) {
    this.riskLev = riskLev;
  }

  public String getForceBuyFlag() {
    return this.forceBuyFlag;
  }

  public void setForceBuyFlag(String forceBuyFlag) {
    this.forceBuyFlag = forceBuyFlag;
  }

  public String getEstablishFlag() {
    return this.establishFlag;
  }

  public void setEstablishFlag(String establishFlag) {
    this.establishFlag = establishFlag;
  }

  public String getLifecycle() {
    return this.lifecycle;
  }

  public void setLifecycle(String lifecycle) {
    this.lifecycle = lifecycle;
  }

  public String getCyy() {
    return this.cyy;
  }

  public void setCyy(String cyy) {
    this.cyy = cyy;
  }

  public String getTrusteeNo() {
    return this.trusteeNo;
  }

  public void setTrusteeNo(String trusteeNo) {
    this.trusteeNo = trusteeNo;
  }

  public String getIsSuspendFlag() {
    return this.isSuspendFlag;
  }

  public void setIsSuspendFlag(String isSuspendFlag) {
    this.isSuspendFlag = isSuspendFlag;
  }

  public String getIsPrivateFlag() {
    return this.isPrivateFlag;
  }

  public void setIsPrivateFlag(String isPrivateFlag) {
    this.isPrivateFlag = isPrivateFlag;
  }

  public String getBasis() {
    return this.basis;
  }

  public void setBasis(String basis) {
    this.basis = basis;
  }

  public String getPropRateMin() {
    return this.propRateMin;
  }

  public void setPropRateMin(String propRateMin) {
    this.propRateMin = propRateMin;
  }

  public String getPropRateMax() {
    return this.propRateMax;
  }

  public void setPropRateMax(String propRateMax) {
    this.propRateMax = propRateMax;
  }

  public String getIsBook() {
    return this.isBook;
  }

  public void setIsBook(String isBook) {
    this.isBook = isBook;
  }

  public String getNoCounterMaxBook() {
    return this.noCounterMaxBook;
  }

  public void setNoCounterMaxBook(String noCounterMaxBook) {
    this.noCounterMaxBook = noCounterMaxBook;
  }

  public String getBookStartDate() {
    return this.bookStartDate;
  }

  public void setBookStartDate(String bookStartDate) {
    this.bookStartDate = bookStartDate;
  }

  public String getBookStartTime() {
    return this.bookStartTime;
  }

  public void setBookStartTime(String bookStartTime) {
    this.bookStartTime = bookStartTime;
  }

  public String getBookEndDate() {
    return this.bookEndDate;
  }

  public void setBookEndDate(String bookEndDate) {
    this.bookEndDate = bookEndDate;
  }

  public String getBookEndTime() {
    return this.bookEndTime;
  }

  public void setBookEndTime(String bookEndTime) {
    this.bookEndTime = bookEndTime;
  }

  public String getSubCapitalMode() {
    return this.subCapitalMode;
  }

  public void setSubCapitalMode(String subCapitalMode) {
    this.subCapitalMode = subCapitalMode;
  }

  public String getRaiseCancleFlag() {
    return this.raiseCancleFlag;
  }

  public void setRaiseCancleFlag(String raiseCancleFlag) {
    this.raiseCancleFlag = raiseCancleFlag;
  }

  public String getNoCounterCancelfLag() {
    return this.noCounterCancelfLag;
  }

  public void setNoCounterCancelfLag(String noCounterCancelfLag) {
    this.noCounterCancelfLag = noCounterCancelfLag;
  }

  public String getRaiseStartDate() {
    return this.raiseStartDate;
  }

  public void setRaiseStartDate(String raiseStartDate) {
    this.raiseStartDate = raiseStartDate;
  }

  public String getRaiseStartTime() {
    return this.raiseStartTime;
  }

  public void setRaiseStartTime(String raiseStartTime) {
    this.raiseStartTime = raiseStartTime;
  }

  public String getRaiseEndDate() {
    return this.raiseEndDate;
  }

  public void setRaiseEndDate(String raiseEndDate) {
    this.raiseEndDate = raiseEndDate;
  }

  public String getRaiseEndTime() {
    return this.raiseEndTime;
  }

  public void setRaiseEndTime(String raiseEndTime) {
    this.raiseEndTime = raiseEndTime;
  }

  public String getEstablishDate() {
    return this.establishDate;
  }

  public void setEstablishDate(String establishDate) {
    this.establishDate = establishDate;
  }

  public String getValueDate() {
    return this.valueDate;
  }

  public void setValueDate(String valueDate) {
    this.valueDate = valueDate;
  }

  public String getMatuDate() {
    return this.matuDate;
  }

  public void setMatuDate(String matuDate) {
    this.matuDate = matuDate;
  }

  public String getClrPayDay() {
    return this.clrPayDay;
  }

  public void setClrPayDay(String clrPayDay) {
    this.clrPayDay = clrPayDay;
  }

  public String getLiquFlag() {
    return this.liquFlag;
  }

  public void setLiquFlag(String liquFlag) {
    this.liquFlag = liquFlag;
  }

  public String getPlanRaiseAmtMax() {
    return this.planRaiseAmtMax;
  }

  public void setPlanRaiseAmtMax(String planRaiseAmtMax) {
    this.planRaiseAmtMax = planRaiseAmtMax;
  }

  public String getPlanRaiseAmtMin() {
    return this.planRaiseAmtMin;
  }

  public void setPlanRaiseAmtMin(String planRaiseAmtMin) {
    this.planRaiseAmtMin = planRaiseAmtMin;
  }

  public String getSsumBuyMax() {
    return this.ssumBuyMax;
  }

  public void setSsumBuyMax(String ssumBuyMax) {
    this.ssumBuyMax = ssumBuyMax;
  }

  public String getIsumBuyMax() {
    return this.isumBuyMax;
  }

  public void setIsumBuyMax(String isumBuyMax) {
    this.isumBuyMax = isumBuyMax;
  }

  public String getSsubStartAmt() {
    return this.ssubStartAmt;
  }

  public void setSsubStartAmt(String ssubStartAmt) {
    this.ssubStartAmt = ssubStartAmt;
  }

  public String getSsupSubAmt() {
    return this.ssupSubAmt;
  }

  public void setSsupSubAmt(String ssupSubAmt) {
    this.ssupSubAmt = ssupSubAmt;
  }

  public String getIsubStartAmt() {
    return this.isubStartAmt;
  }

  public void setIsubStartAmt(String isubStartAmt) {
    this.isubStartAmt = isubStartAmt;
  }

  public String getIsupSubAmt() {
    return this.isupSubAmt;
  }

  public void setIsupSubAmt(String isupSubAmt) {
    this.isupSubAmt = isupSubAmt;
  }

  public String getDeclareStartDate() {
    return this.declareStartDate;
  }

  public void setDeclareStartDate(String declareStartDate) {
    this.declareStartDate = declareStartDate;
  }

  public String getDeclareStartTime() {
    return this.declareStartTime;
  }

  public void setDeclareStartTime(String declareStartTime) {
    this.declareStartTime = declareStartTime;
  }

  public String getDeclareMatuDate() {
    return this.declareMatuDate;
  }

  public void setDeclareMatuDate(String declareMatuDate) {
    this.declareMatuDate = declareMatuDate;
  }

  public String getDeclareMatuTime() {
    return this.declareMatuTime;
  }

  public void setDeclareMatuTime(String declareMatuTime) {
    this.declareMatuTime = declareMatuTime;
  }

  public String getActPrjNo() {
    return this.actPrjNo;
  }

  public void setActPrjNo(String actPrjNo) {
    this.actPrjNo = actPrjNo;
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

  public String getTerm() {
    return this.term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public String getTermType() {
    return this.termType;
  }

  public void setTermType(String termType) {
    this.termType = termType;
  }

  public String getCollectCapitalStatus() {
    return this.collectCapitalStatus;
  }

  public void setCollectCapitalStatus(String collectCapitalStatus) {
    this.collectCapitalStatus = collectCapitalStatus;
  }

  public String getForceCollEstabFlag() {
    return this.forceCollEstabFlag;
  }

  public void setForceCollEstabFlag(String forceCollEstabFlag) {
    this.forceCollEstabFlag = forceCollEstabFlag;
  }

  public String getEstabFailCapitalStatus() {
    return this.estabFailCapitalStatus;
  }

  public void setEstabFailCapitalStatus(String estabFailCapitalStatus) {
    this.estabFailCapitalStatus = estabFailCapitalStatus;
  }

  public String getEndpayCapitalStatus() {
    return this.endpayCapitalStatus;
  }

  public void setEndpayCapitalStatus(String endpayCapitalStatus) {
    this.endpayCapitalStatus = endpayCapitalStatus;
  }

  public String getMainPrdNo() {
    return this.mainPrdNo;
  }

  public void setMainPrdNo(String mainPrdNo) {
    this.mainPrdNo = mainPrdNo;
  }

  public String getInterStartAmt() {
    return this.interStartAmt;
  }

  public void setInterStartAmt(String interStartAmt) {
    this.interStartAmt = interStartAmt;
  }

  public String getInterSubAmt() {
    return this.interSubAmt;
  }

  public void setInterSubAmt(String interSubAmt) {
    this.interSubAmt = interSubAmt;
  }

  public String getInterBuyMax() {
    return this.interBuyMax;
  }

  public void setInterBuyMax(String interBuyMax) {
    this.interBuyMax = interBuyMax;
  }

  public String getSingleFlag() {
    return this.singleFlag;
  }

  public void setSingleFlag(String singleFlag) {
    this.singleFlag = singleFlag;
  }

  public String getIsRedeemFlag() {
    return this.isRedeemFlag;
  }

  public void setIsRedeemFlag(String isRedeemFlag) {
    this.isRedeemFlag = isRedeemFlag;
  }

  public String getPlanType() {
    return this.planType;
  }

  public void setPlanType(String planType) {
    this.planType = planType;
  }

  public String getPerfBench() {
    return this.perfBench;
  }

  public void setPerfBench(String perfBench) {
    this.perfBench = perfBench;
  }

  public String getExcessPrefAllRatio() {
    return this.excessPrefAllRatio;
  }

  public void setExcessPrefAllRatio(String excessPrefAllRatio) {
    this.excessPrefAllRatio = excessPrefAllRatio;
  }
}
*/
