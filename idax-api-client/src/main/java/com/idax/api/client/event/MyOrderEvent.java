package com.idax.api.client.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Admin
 * @Title: MyOrderEvent
 * @ProjectName idax-java-api
 * @Description: TODO
 * @date 2018/12/518:39
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MyOrderEvent {

    @JsonProperty("createtime")
    private String createTime;
    @JsonProperty("feerate")
    private BigDecimal feeRate;
    @JsonProperty("filledamount")
    private BigDecimal filledAmount;
    @JsonProperty("filledQty")
    private BigDecimal filledqty;
    @JsonProperty("frozen")
    private BigDecimal frozen;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("orderside")
    private Integer orderSide;
    @JsonProperty("orderstate")
    private Integer orderState;
    @JsonProperty("ordertype")
    private Integer orderType;
    @JsonProperty("pairname")
    private String symbol;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("total")
    private BigDecimal total;
    @JsonProperty("updatetime")
    private String updateTime;
    @JsonProperty("userid")
    private Integer userId;

}
