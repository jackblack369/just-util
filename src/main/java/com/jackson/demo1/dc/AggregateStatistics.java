package com.jackson.demo1.dc;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jackson.demo1.MoneySerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class AggregateStatistics {
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal AMT;
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal TLD;
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal LD_AMP;
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal TLM;
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal LM_AMP;
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal TLY;
    /**
     */
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal TY_AMP;

}
