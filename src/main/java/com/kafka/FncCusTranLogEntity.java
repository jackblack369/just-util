/*
package com.kafka;


import javax.persistence.*;

@Entity
@Table(name="FNC_CUS_TRAN_LOG")
public class FncCusTranLogEntity extends BaseEntity {


  @Column(name="SYS_NO")
  private String SYS_NO;

  @Column(name="TA_NO")
  private String TA_NO;

  @Column(name="DEAL_NO")
  private String DEAL_NO;

  @Column(name="NATURE_DATE")
  private String NATURE_DATE;

  @Column(name="NATURE_TIME")
  private String NATURE_TIME;

  @Column(name="CHANNEL")
  private String CHANNEL;

  @Column(name="CHANNEL_NO")
  private String CHANNEL_NO;

  @Column(name="CHANNEL_DEAL_NO")
  private String CHANNEL_DEAL_NO;

  @Column(name="CHANNEL_BUSI_CODE")
  private String CHANNEL_BUSI_CODE;

  @Column(name="CHANNEL_DATE")
  private String CHANNEL_DATE;

  @Column(name="CHANNEL_TIME")
  private String CHANNEL_TIME;

  @Column(name="HOST_DEAL_NO")
  private String HOST_DEAL_NO;

  @Column(name="HOST_DATE")
  private String HOST_DATE;

  @Column(name="HOST_TIME")
  private String HOST_TIME;

  @Column(name="HOST_RET_CODE")
  private String HOST_RET_CODE;

  @Column(name="HOST_RET_MSG")
  private String HOST_RET_MSG;

  @Column(name="BUSI_CODE")
  private String BUSI_CODE;

  @Column(name="TRAN_STATUS")
  private String TRAN_STATUS;

  @Column(name="TRAN_DATE")
  private String TRAN_DATE;

  @Column(name="TRAN_ACK_DATE")
  private String TRAN_ACK_DATE;

  @Column(name="RET_CODE")
  private String RET_CODE;

  @Column(name="RET_MSG")
  private String RET_MSG;

  @Column(name="BANK_NO")
  private String BANK_NO;

  @Column(name="BRANCH_NO")
  private String BRANCH_NO;

  @Column(name="SUB_BRANCH_NO")
  private String SUB_BRANCH_NO;

  @Column(name="FNC_NO")
  private String FNC_NO;

  @Column(name="BANK_ACCT")
  private String BANK_ACCT;

  @Column(name="SUB_BANK_ACCT")
  private String SUB_BANK_ACCT;

  @Column(name="ISSU_BANK_NO")
  private String ISSU_BANK_NO;

  @Column(name="ISSU_BRANCH_NO")
  private String ISSU_BRANCH_NO;

  @Column(name="ISSU_SUB_BRANCH_NO")
  private String ISSU_SUB_BRANCH_NO;

  @Column(name="CUS_NUM")
  private String CUS_NUM;

  @Column(name="CUS_NAME")
  private String CUS_NAME;

  @Column(name="CUS_TYPE")
  private String CUS_TYPE;

  @Column(name="CUS_LEV")
  private String CUS_LEV;

  @Column(name="CRE_TYPE")
  private String CRE_TYPE;

  @Column(name="CRE_NUM")
  private String CRE_NUM;

  @Column(name="CARD_LEV")
  private String CARD_LEV;

  @Column(name="CARD_TYPE")
  private String CARD_TYPE;

  @Column(name="AGENT_CHK_TYPE")
  private String AGENT_CHK_TYPE;

  @Column(name="AGENT_NAME")
  private String AGENT_NAME;

  @Column(name="AGENT_CRE_TYPE")
  private String AGENT_CRE_TYPE;

  @Column(name="AGENT_CRE_NUM")
  private String AGENT_CRE_NUM;

  @Column(name="LEGAL_PER_NAME")
  private String LEGAL_PER_NAME;

  @Column(name="LEGAL_PER_CRE_TYPE")
  private String LEGAL_PER_CRE_TYPE;

  @Column(name="LEGAL_PER_CRE_NUM")
  private String LEGAL_PER_CRE_NUM;

  @Column(name="FM_MANAGER")
  private String FM_MANAGER;

  @Column(name="ORI_DEAL_NO")
  private String ORI_DEAL_NO;

  @Column(name="ORI_BANK_ACCT")
  private String ORI_BANK_ACCT;

  @Column(name="ORI_SUB_BANK_ACCT")
  private String ORI_SUB_BANK_ACCT;

  @Column(name="CUS_RISK_LEV")
  private String CUS_RISK_LEV;

  @Column(name="IS_RISK_MATCH")
  private String IS_RISK_MATCH;

  @Column(name="PRD_NO")
  private String PRD_NO;

  @Column(name="PRD_ID")
  private String PRD_ID;

  @Column(name="PRD_NAME")
  private String PRD_NAME;

  @Column(name="RISK_LEV")
  private String RISK_LEV;

  @Column(name="APP_AMT")
  private String APP_AMT;

  @Column(name="ACK_VOL")
  private String ACK_VOL;

  @Column(name="ACK_AMT")
  private String ACK_AMT;

  @Column(name="NET_VALUE")
  private String NET_VALUE;

  @Column(name="HOST_FROZ_CODE")
  private String HOST_FROZ_CODE;

  @Column(name="MATU_DATE")
  private String MATU_DATE;

  @Column(name="CLR_PAY_DAY")
  private String CLR_PAY_DAY;

  @Column(name="MATCH_CUS_NUM")
  private String MATCH_CUS_NUM;

  @Column(name="MATCH_CUS_NAME")
  private String MATCH_CUS_NAME;

  @Column(name="MATCH_CUS_TYPE")
  private String MATCH_CUS_TYPE;

  @Column(name="MATCH_CUS_LEV")
  private String MATCH_CUS_LEV;

  @Column(name="MATCH_CARD_LEV")
  private String MATCH_CARD_LEV;

  @Column(name="MATCH_CRE_NUM")
  private String MATCH_CRE_NUM;

  @Column(name="CHK_STATE")
  private String CHK_STATE;

  @Column(name="MATCH_CRE_TYPE")
  private String MATCH_CRE_TYPE;

  @Column(name="CHARGE_DISCOUNT")
  private String CHARGE_DISCOUNT;

  @Column(name="CHARGE")
  private String CHARGE;

  @Column(name="FEE_SRV_AMT")
  private String FEE_SRV_AMT;

  @Column(name="PRINT_NUMBER")
  private String PRINT_NUMBER;

  @Column(name="CREATE_USER")
  private String CREATE_USER;

  @Column(name="CHECK_USER")
  private String CHECK_USER;

  @Column(name="GRANT_USER")
  private String GRANT_USER;

  @Column(name="CREATE_DATE")
  private String CREATE_DATE;

  @Column(name="CREATE_TIME")
  private String CREATE_TIME;

  @Column(name="LST_MNT_DATE")
  private String LST_MNT_DATE;

  @Column(name="LST_MNT_TIME")
  private String LST_MNT_TIME;

  @Column(name="LST_MNT_USER")
  private String LST_MNT_USER;

  @Column(name="REMARK")
  private String REMARK;

  @Column(name="DIV_UUID")
  private String DIV_UUID;

  @Column(name="SUB_BUSI_CODE")
  private String SUB_BUSI_CODE;

  @Column(name="NEED_CLEAR_CHECK")
  private String NEED_CLEAR_CHECK;

  @Column(name="CAPITAL_TYPE")
  private String CAPITAL_TYPE;

  @Column(name="CYY")
  private String CYY;

  @Column(name="CUS_SHARE_TYPE")
  private String CUS_SHARE_TYPE;

  @Column(name="TRANSFER_TYPE")
  private String TRANSFER_TYPE;

  @Column(name="DOC_NO")
  private String DOC_NO;

  @Column(name="MAIN_DEAL_NO")
  private String MAIN_DEAL_NO;

  @Column(name="AUTO_CHANGE_BUY")
  private String AUTO_CHANGE_BUY;

  @Column(name="IS_LOCK")
  private String IS_LOCK;

  @Column(name="MATCH_BANK_ACCT")
  private String MATCH_BANK_ACCT;

  @Column(name="MATCH_SUB_BANK_ACCT")
  private String MATCH_SUB_BANK_ACCT;

  @Column(name="INCOME_AMT")
  private String INCOME_AMT;

  @Column(name="VALUE_DATE")
  private String VALUE_DATE;

  @Column(name="INCOME_RATE")
  private String INCOME_RATE;

  @Column(name="CUSTOM_HOLD_DAYS")
  private String CUSTOM_HOLD_DAYS;

  @Column(name="CURRENT_PERIOD")
  private String CURRENT_PERIOD;

  @Column(name="RATIFY_STATUS")
  private String RATIFY_STATUS;

  @Column(name="APP_VOL")
  private String APP_VOL;

  @Column(name="FEE_AMT")
  private String FEE_AMT;

  @Column(name="FEE_SRV_DISCOUNT")
  private String FEE_SRV_DISCOUNT;

  @Column(name="FEE_DISCOUNT")
  private String FEE_DISCOUNT;

  @Column(name="IS_TRANSIT_ACCOUNT")
  private String IS_TRANSIT_ACCOUNT;

  @Column(name="OUT_BANK_ACCT")
  private String OUT_BANK_ACCT;

  @Column(name="AGREEMENT_NO")
  private String AGREEMENT_NO;

  @Column(name="CLOSE_END_DAY")
  private String CLOSE_END_DAY;

  @Column(name="PERIOD_NO")
  private String PERIOD_NO;

  @Column(name="MARKETING_CODE")
  private String MARKETING_CODE;


  public String getSysNo() {
    return this.sysNo;
  }

  public void setSysNo(String sysNo) {
    this.sysNo = sysNo;
  }

  public String getTaNo() {
    return this.taNo;
  }

  public void setTaNo(String taNo) {
    this.taNo = taNo;
  }

  public String getDealNo() {
    return this.dealNo;
  }

  public void setDealNo(String dealNo) {
    this.dealNo = dealNo;
  }

  public String getNatureDate() {
    return this.natureDate;
  }

  public void setNatureDate(String natureDate) {
    this.natureDate = natureDate;
  }

  public String getNatureTime() {
    return this.natureTime;
  }

  public void setNatureTime(String natureTime) {
    this.natureTime = natureTime;
  }

  public String getChannel() {
    return this.channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getChannelNo() {
    return this.channelNo;
  }

  public void setChannelNo(String channelNo) {
    this.channelNo = channelNo;
  }

  public String getChannelDealNo() {
    return this.channelDealNo;
  }

  public void setChannelDealNo(String channelDealNo) {
    this.channelDealNo = channelDealNo;
  }

  public String getChannelBusiCode() {
    return this.channelBusiCode;
  }

  public void setChannelBusiCode(String channelBusiCode) {
    this.channelBusiCode = channelBusiCode;
  }

  public String getChannelDate() {
    return this.channelDate;
  }

  public void setChannelDate(String channelDate) {
    this.channelDate = channelDate;
  }

  public String getChannelTime() {
    return this.channelTime;
  }

  public void setChannelTime(String channelTime) {
    this.channelTime = channelTime;
  }

  public String getHostDealNo() {
    return this.hostDealNo;
  }

  public void setHostDealNo(String hostDealNo) {
    this.hostDealNo = hostDealNo;
  }

  public String getHostDate() {
    return this.hostDate;
  }

  public void setHostDate(String hostDate) {
    this.hostDate = hostDate;
  }

  public String getHostTime() {
    return this.hostTime;
  }

  public void setHostTime(String hostTime) {
    this.hostTime = hostTime;
  }

  public String getHostRetCode() {
    return this.hostRetCode;
  }

  public void setHostRetCode(String hostRetCode) {
    this.hostRetCode = hostRetCode;
  }

  public String getHostRetMsg() {
    return this.hostRetMsg;
  }

  public void setHostRetMsg(String hostRetMsg) {
    this.hostRetMsg = hostRetMsg;
  }

  public String getBusiCode() {
    return this.busiCode;
  }

  public void setBusiCode(String busiCode) {
    this.busiCode = busiCode;
  }

  public String getTranStatus() {
    return this.tranStatus;
  }

  public void setTranStatus(String tranStatus) {
    this.tranStatus = tranStatus;
  }

  public String getTranDate() {
    return this.tranDate;
  }

  public void setTranDate(String tranDate) {
    this.tranDate = tranDate;
  }

  public String getTranAckDate() {
    return this.tranAckDate;
  }

  public void setTranAckDate(String tranAckDate) {
    this.tranAckDate = tranAckDate;
  }

  public String getRetCode() {
    return this.retCode;
  }

  public void setRetCode(String retCode) {
    this.retCode = retCode;
  }

  public String getRetMsg() {
    return this.retMsg;
  }

  public void setRetMsg(String retMsg) {
    this.retMsg = retMsg;
  }

  public String getBankNo() {
    return this.bankNo;
  }

  public void setBankNo(String bankNo) {
    this.bankNo = bankNo;
  }

  public String getBranchNo() {
    return this.branchNo;
  }

  public void setBranchNo(String branchNo) {
    this.branchNo = branchNo;
  }

  public String getSubBranchNo() {
    return this.subBranchNo;
  }

  public void setSubBranchNo(String subBranchNo) {
    this.subBranchNo = subBranchNo;
  }

  public String getFncNo() {
    return this.fncNo;
  }

  public void setFncNo(String fncNo) {
    this.fncNo = fncNo;
  }

  public String getBankAcct() {
    return this.bankAcct;
  }

  public void setBankAcct(String bankAcct) {
    this.bankAcct = bankAcct;
  }

  public String getSubBankAcct() {
    return this.subBankAcct;
  }

  public void setSubBankAcct(String subBankAcct) {
    this.subBankAcct = subBankAcct;
  }

  public String getIssuBankNo() {
    return this.issuBankNo;
  }

  public void setIssuBankNo(String issuBankNo) {
    this.issuBankNo = issuBankNo;
  }

  public String getIssuBranchNo() {
    return this.issuBranchNo;
  }

  public void setIssuBranchNo(String issuBranchNo) {
    this.issuBranchNo = issuBranchNo;
  }

  public String getIssuSubBranchNo() {
    return this.issuSubBranchNo;
  }

  public void setIssuSubBranchNo(String issuSubBranchNo) {
    this.issuSubBranchNo = issuSubBranchNo;
  }

  public String getCusNum() {
    return this.cusNum;
  }

  public void setCusNum(String cusNum) {
    this.cusNum = cusNum;
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

  public String getCusLev() {
    return this.cusLev;
  }

  public void setCusLev(String cusLev) {
    this.cusLev = cusLev;
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

  public String getCardLev() {
    return this.cardLev;
  }

  public void setCardLev(String cardLev) {
    this.cardLev = cardLev;
  }

  public String getCardType() {
    return this.cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getAgentChkType() {
    return this.agentChkType;
  }

  public void setAgentChkType(String agentChkType) {
    this.agentChkType = agentChkType;
  }

  public String getAgentName() {
    return this.agentName;
  }

  public void setAgentName(String agentName) {
    this.agentName = agentName;
  }

  public String getAgentCreType() {
    return this.agentCreType;
  }

  public void setAgentCreType(String agentCreType) {
    this.agentCreType = agentCreType;
  }

  public String getAgentCreNum() {
    return this.agentCreNum;
  }

  public void setAgentCreNum(String agentCreNum) {
    this.agentCreNum = agentCreNum;
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

  public String getLegalPerCreNum() {
    return this.legalPerCreNum;
  }

  public void setLegalPerCreNum(String legalPerCreNum) {
    this.legalPerCreNum = legalPerCreNum;
  }

  public String getFmManager() {
    return this.fmManager;
  }

  public void setFmManager(String fmManager) {
    this.fmManager = fmManager;
  }

  public String getOriDealNo() {
    return this.oriDealNo;
  }

  public void setOriDealNo(String oriDealNo) {
    this.oriDealNo = oriDealNo;
  }

  public String getOriBankAcct() {
    return this.oriBankAcct;
  }

  public void setOriBankAcct(String oriBankAcct) {
    this.oriBankAcct = oriBankAcct;
  }

  public String getOriSubBankAcct() {
    return this.oriSubBankAcct;
  }

  public void setOriSubBankAcct(String oriSubBankAcct) {
    this.oriSubBankAcct = oriSubBankAcct;
  }

  public String getCusRiskLev() {
    return this.cusRiskLev;
  }

  public void setCusRiskLev(String cusRiskLev) {
    this.cusRiskLev = cusRiskLev;
  }

  public String getIsRiskMatch() {
    return this.isRiskMatch;
  }

  public void setIsRiskMatch(String isRiskMatch) {
    this.isRiskMatch = isRiskMatch;
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

  public String getRiskLev() {
    return this.riskLev;
  }

  public void setRiskLev(String riskLev) {
    this.riskLev = riskLev;
  }

  public String getAppAmt() {
    return this.appAmt;
  }

  public void setAppAmt(String appAmt) {
    this.appAmt = appAmt;
  }

  public String getAckVol() {
    return this.ackVol;
  }

  public void setAckVol(String ackVol) {
    this.ackVol = ackVol;
  }

  public String getAckAmt() {
    return this.ackAmt;
  }

  public void setAckAmt(String ackAmt) {
    this.ackAmt = ackAmt;
  }

  public String getNetValue() {
    return this.netValue;
  }

  public void setNetValue(String netValue) {
    this.netValue = netValue;
  }

  public String getHostFrozCode() {
    return this.hostFrozCode;
  }

  public void setHostFrozCode(String hostFrozCode) {
    this.hostFrozCode = hostFrozCode;
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

  public String getMatchCusNum() {
    return this.matchCusNum;
  }

  public void setMatchCusNum(String matchCusNum) {
    this.matchCusNum = matchCusNum;
  }

  public String getMatchCusName() {
    return this.matchCusName;
  }

  public void setMatchCusName(String matchCusName) {
    this.matchCusName = matchCusName;
  }

  public String getMatchCusType() {
    return this.matchCusType;
  }

  public void setMatchCusType(String matchCusType) {
    this.matchCusType = matchCusType;
  }

  public String getMatchCusLev() {
    return this.matchCusLev;
  }

  public void setMatchCusLev(String matchCusLev) {
    this.matchCusLev = matchCusLev;
  }

  public String getMatchCardLev() {
    return this.matchCardLev;
  }

  public void setMatchCardLev(String matchCardLev) {
    this.matchCardLev = matchCardLev;
  }

  public String getMatchCreNum() {
    return this.matchCreNum;
  }

  public void setMatchCreNum(String matchCreNum) {
    this.matchCreNum = matchCreNum;
  }

  public String getChkState() {
    return this.chkState;
  }

  public void setChkState(String chkState) {
    this.chkState = chkState;
  }

  public String getMatchCreType() {
    return this.matchCreType;
  }

  public void setMatchCreType(String matchCreType) {
    this.matchCreType = matchCreType;
  }

  public String getChargeDiscount() {
    return this.chargeDiscount;
  }

  public void setChargeDiscount(String chargeDiscount) {
    this.chargeDiscount = chargeDiscount;
  }

  public String getCharge() {
    return this.charge;
  }

  public void setCharge(String charge) {
    this.charge = charge;
  }

  public String getFeeSrvAmt() {
    return this.feeSrvAmt;
  }

  public void setFeeSrvAmt(String feeSrvAmt) {
    this.feeSrvAmt = feeSrvAmt;
  }

  public String getPrintNumber() {
    return this.printNumber;
  }

  public void setPrintNumber(String printNumber) {
    this.printNumber = printNumber;
  }

  public String getCreateUser() {
    return this.createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getCheckUser() {
    return this.checkUser;
  }

  public void setCheckUser(String checkUser) {
    this.checkUser = checkUser;
  }

  public String getGrantUser() {
    return this.grantUser;
  }

  public void setGrantUser(String grantUser) {
    this.grantUser = grantUser;
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

  public String getLstMntUser() {
    return this.lstMntUser;
  }

  public void setLstMntUser(String lstMntUser) {
    this.lstMntUser = lstMntUser;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getDivUuid() {
    return this.divUuid;
  }

  public void setDivUuid(String divUuid) {
    this.divUuid = divUuid;
  }

  public String getSubBusiCode() {
    return this.subBusiCode;
  }

  public void setSubBusiCode(String subBusiCode) {
    this.subBusiCode = subBusiCode;
  }

  public String getNeedClearCheck() {
    return this.needClearCheck;
  }

  public void setNeedClearCheck(String needClearCheck) {
    this.needClearCheck = needClearCheck;
  }

  public String getCapitalType() {
    return this.capitalType;
  }

  public void setCapitalType(String capitalType) {
    this.capitalType = capitalType;
  }

  public String getCyy() {
    return this.cyy;
  }

  public void setCyy(String cyy) {
    this.cyy = cyy;
  }

  public String getCusShareType() {
    return this.cusShareType;
  }

  public void setCusShareType(String cusShareType) {
    this.cusShareType = cusShareType;
  }

  public String getTransferType() {
    return this.transferType;
  }

  public void setTransferType(String transferType) {
    this.transferType = transferType;
  }

  public String getDocNo() {
    return this.docNo;
  }

  public void setDocNo(String docNo) {
    this.docNo = docNo;
  }

  public String getMainDealNo() {
    return this.mainDealNo;
  }

  public void setMainDealNo(String mainDealNo) {
    this.mainDealNo = mainDealNo;
  }

  public String getAutoChangeBuy() {
    return this.autoChangeBuy;
  }

  public void setAutoChangeBuy(String autoChangeBuy) {
    this.autoChangeBuy = autoChangeBuy;
  }

  public String getIsLock() {
    return this.isLock;
  }

  public void setIsLock(String isLock) {
    this.isLock = isLock;
  }

  public String getMatchBankAcct() {
    return this.matchBankAcct;
  }

  public void setMatchBankAcct(String matchBankAcct) {
    this.matchBankAcct = matchBankAcct;
  }

  public String getMatchSubBankAcct() {
    return this.matchSubBankAcct;
  }

  public void setMatchSubBankAcct(String matchSubBankAcct) {
    this.matchSubBankAcct = matchSubBankAcct;
  }

  public String getIncomeAmt() {
    return this.incomeAmt;
  }

  public void setIncomeAmt(String incomeAmt) {
    this.incomeAmt = incomeAmt;
  }

  public String getValueDate() {
    return this.valueDate;
  }

  public void setValueDate(String valueDate) {
    this.valueDate = valueDate;
  }

  public String getIncomeRate() {
    return this.incomeRate;
  }

  public void setIncomeRate(String incomeRate) {
    this.incomeRate = incomeRate;
  }

  public String getCustomHoldDays() {
    return this.customHoldDays;
  }

  public void setCustomHoldDays(String customHoldDays) {
    this.customHoldDays = customHoldDays;
  }

  public String getCurrentPeriod() {
    return this.currentPeriod;
  }

  public void setCurrentPeriod(String currentPeriod) {
    this.currentPeriod = currentPeriod;
  }

  public String getRatifyStatus() {
    return this.ratifyStatus;
  }

  public void setRatifyStatus(String ratifyStatus) {
    this.ratifyStatus = ratifyStatus;
  }

  public String getAppVol() {
    return this.appVol;
  }

  public void setAppVol(String appVol) {
    this.appVol = appVol;
  }

  public String getFeeAmt() {
    return this.feeAmt;
  }

  public void setFeeAmt(String feeAmt) {
    this.feeAmt = feeAmt;
  }

  public String getFeeSrvDiscount() {
    return this.feeSrvDiscount;
  }

  public void setFeeSrvDiscount(String feeSrvDiscount) {
    this.feeSrvDiscount = feeSrvDiscount;
  }

  public String getFeeDiscount() {
    return this.feeDiscount;
  }

  public void setFeeDiscount(String feeDiscount) {
    this.feeDiscount = feeDiscount;
  }

  public String getIsTransitAccount() {
    return this.isTransitAccount;
  }

  public void setIsTransitAccount(String isTransitAccount) {
    this.isTransitAccount = isTransitAccount;
  }

  public String getOutBankAcct() {
    return this.outBankAcct;
  }

  public void setOutBankAcct(String outBankAcct) {
    this.outBankAcct = outBankAcct;
  }

  public String getAgreementNo() {
    return this.agreementNo;
  }

  public void setAgreementNo(String agreementNo) {
    this.agreementNo = agreementNo;
  }

  public String getCloseEndDay() {
    return this.closeEndDay;
  }

  public void setCloseEndDay(String closeEndDay) {
    this.closeEndDay = closeEndDay;
  }

  public String getPeriodNo() {
    return this.periodNo;
  }

  public void setPeriodNo(String periodNo) {
    this.periodNo = periodNo;
  }

  public String getMarketingCode() {
    return this.marketingCode;
  }

  public void setMarketingCode(String marketingCode) {
    this.marketingCode = marketingCode;
  }
}
*/
