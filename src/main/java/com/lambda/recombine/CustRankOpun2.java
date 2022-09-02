package com.lambda.recombine;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class CustRankOpun2 {

    /**
     * 机构代码
     */
    @JsonProperty
    private String OPUN_COD;
    /**
     * 机构中文名
     */
    @JsonProperty
    private String OPUN_FLNM_CHN;
    /**
     * 机构简称
     */
    @JsonProperty
    private String OPUN_INIL_CHN;
    /**
     * 上级管理机构
     */
    @JsonProperty
    private String RPT_MANAGE_BRH;
    /**
     * 机构客户排名信息
     */
    private List<CustInfo2> LIST_CUST;

}
