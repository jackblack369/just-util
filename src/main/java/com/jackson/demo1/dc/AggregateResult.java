package com.jackson.demo1.dc;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jackson.demo1.MoneySerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public class AggregateResult {
    /**
     */
    @JsonProperty
    private int CORPORATION;
    /**
     */
    @JsonProperty
    private String OPUN_COD;
    /**
     */
    @JsonProperty
    private String OPUN_FLNM_CHN;
    /**
     */
    @JsonProperty
    private String OPUN_INIL_CHN;
    /**
     */
    @JsonProperty
    private String RPT_MANAGE_BRH;
    /**
     */
    @JsonProperty
    private String OPUN_ADDR;
    /**
     */
    @JsonProperty
    private Integer AREA_CODE;
    /**
     */
    @JsonProperty
    private Integer BNK_MON;
    /**
     */
    @JsonProperty
    private Integer INSTN_TYP;
    /**
     */
    @JsonProperty
    private String DATE;
    /**
     */
    @JsonProperty
    private Long TIMESTAMP;
    @JsonProperty
    private String YEAR;
    @JsonProperty
    private String MONTH;
    @JsonProperty
    private String DAY;
    @JsonProperty
    private String HOUR;
    @JsonProperty
    private String MINUTE;
    @JsonProperty
    private String SECOND;
    /**
     */
    @JsonProperty
    private Long T_CNT;
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal PROPERTY;
    /**
     */
    @JsonProperty
    private List<Map<String, Object>> T_CHNL_CNTS;
    /**
     */
    @JsonProperty
    private Map<MetricType, AggregateStatistics> DR = new HashMap();
    /**
     */
    @JsonProperty
    private Map<MetricType, AggregateStatistics> CR = new HashMap();
    @JsonProperty
    private int VD_HIE;
    @JsonProperty
    private boolean IS_RANK;
}
