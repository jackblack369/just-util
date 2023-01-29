package com.lambda.recombine;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustInfo2{
    /**
     * 客户名称
     */
    @JsonProperty(value = "CUST_NAME")
    private String custName;
    /**
     * 客户账号
     */
    @JsonProperty(value = "CUST_NO")
    private String custNo;

    /**
     * 交易时间
     */
    @JsonProperty(value = "TRADE_TIME")
    private String tradeTime;
    /**
     * 交易类型
     */
    @JsonProperty(value = "TRADE_TYPE")
    private String tradeType;
    /**
     * 交易金额（汇总所有交易对手）
     */
    @JsonProperty(value = "TRADE_AMT")
    private BigDecimal tradeAmt;
    /**
     * 交易笔数（汇总所有交易的对手）
     */
    @JsonProperty(value = "TRADE_CNT")
    private String tradeCnt;


    public String unionKey() {
        return this.custNo+this.getTradeAmt();
    }

    public String deduplicateByKey() {
        return this.custNo;
    }

}
