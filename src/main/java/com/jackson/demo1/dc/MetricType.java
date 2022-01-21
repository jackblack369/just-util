package com.jackson.demo1.dc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum MetricType{
    /**
     */
    @JsonProperty(value = "DR_TOTAL")
    DR_TOTAL,
    /**
     */
    @JsonProperty(value ="PUB")
    DR_PUB,
    /**
     */
    @JsonProperty(value ="SAV")
    DR_SAV,
    /**
     */
    @JsonProperty(value ="PREM")
    DR_PREM,
    /**
     */
    @JsonProperty(value ="CR_TOTAL")
    CR_TOTAL,
    /**
     */
    @JsonProperty(value ="DISCNT")
    CR_DISCNT,
    /**
     */
    @JsonProperty(value ="LOI")
    CR_LOI,
    /**
     */
    @JsonProperty(value ="HON")
    CR_HON,
    /**
     */
    @JsonProperty(value ="GOA")
    CR_GOA

}





