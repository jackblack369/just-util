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

/**
 * 客户排名收付前十排名返回
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class CustRankResult2 {

    /**
     * 机构排名列表
     */
    private List<CustRankOpun2> LIST_OPUN;

    @JsonProperty
    private String TIMESTAMP;
    /**
     * 日期
     */
    @JsonProperty
    private String DATE;
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
}
