package pro.idax.api.client.util;

import org.apache.commons.lang3.StringUtils;
import pro.idax.api.client.domain.*;
import pro.idax.api.client.enums.IdaxCodeEnum;
import pro.idax.api.client.exception.IdaxApiError;
import pro.idax.api.client.exception.IdaxApiException;


/**
 * @program: CheckParamValidUtil
 * @description: CheckParamValidUtil
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:10
 */
public class CheckParamValidUtil {

    /**
     * checkParamValidGetOrderInfo
     *
     * @param orderInfoRequest
     */
    public static void checkParamValidGetOrderInfo(OrderInfoRequest orderInfoRequest) {
        if (StringUtils.isEmpty(orderInfoRequest.getKey())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(orderInfoRequest.getPair())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (orderInfoRequest.getTimestamp() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (orderInfoRequest.getOrderId() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
    }

    /**
     * checkParamValidGetOrderHistory
     *
     * @param orderHistoryRequest
     */
    public static void checkParamValidGetOrderHistory(OrderHistoryRequest orderHistoryRequest) {
        if (StringUtils.isEmpty(orderHistoryRequest.getKey())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(orderHistoryRequest.getPair())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (orderHistoryRequest.getTimestamp() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (orderHistoryRequest.getOrderState() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (orderHistoryRequest.getCurrentPage() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (orderHistoryRequest.getPageLength() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
    }

    /**
     * checkParamValidGetUserInfo
     *
     * @param userInfoRequest
     */
    public static void checkParamValidGetUserInfo(UserInfoRequest userInfoRequest) {
        if (StringUtils.isEmpty(userInfoRequest.getKey())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (userInfoRequest.getTimestamp() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
    }

    /**
     * checkParamValidGetTradeHistory
     *
     * @param tradeHistoryRequest
     */
    public static void checkParamValidGetTradeHistory(TradeHistoryRequest tradeHistoryRequest) {
        if (StringUtils.isEmpty(tradeHistoryRequest.getKey())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(tradeHistoryRequest.getPair())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (tradeHistoryRequest.getTimestamp() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (tradeHistoryRequest.getSince() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
    }

    /**
     * checkParamValidPlaceOrder
     *
     * @param placeOrderRequest
     */
    public static void checkParamValidPlaceOrder(PlaceOrderRequest placeOrderRequest) {
        if (StringUtils.isEmpty(placeOrderRequest.getKey())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(placeOrderRequest.getPair())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(placeOrderRequest.getOrderType())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(placeOrderRequest.getOrderSide())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (placeOrderRequest.getTimestamp() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (placeOrderRequest.getPrice() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (placeOrderRequest.getAmount() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
    }

    /**
     * checkParamValidCancelOrder
     *
     * @param cancelOrderRequest
     */
    public static void checkParamValidCancelOrder(CancelOrderRequest cancelOrderRequest) {
        if (StringUtils.isEmpty(cancelOrderRequest.getKey())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(cancelOrderRequest.getOrderId())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }

    }

    /**
     * checkParamValidGetOrderList
     *
     * @param orderListRequest
     */
    public static void checkParamValidGetOrderList(OrderListRequest orderListRequest) {
        if (StringUtils.isEmpty(orderListRequest.getKey())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(orderListRequest.getPair())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (StringUtils.isEmpty(orderListRequest.getOrderId())) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }
        if (orderListRequest.getTimestamp() == null) {
            throw new IdaxApiException(new IdaxApiError(IdaxCodeEnum.INTERFACE_PARAM_MISSING));
        }

    }

}
