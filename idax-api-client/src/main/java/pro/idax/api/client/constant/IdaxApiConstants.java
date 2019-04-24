package pro.idax.api.client.constant;

import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * @program: IdaxApiConstants
 * @description: Constants used throughout idax's API.
 * @author: zhuWei (ynzhuwei888@126.com)
 * @create: 2019/02/25 17:10
 */
public class IdaxApiConstants {


  /**
   * Default ToStringStyle used by toString methods. 
   * Override this to change the output format of the overridden toString methods. 
   *  - Example ToStringStyle.JSON_STYLE
   */
  public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;

  /**
   * no sign
   */
  public static final String URL_DEPTH = "/api/v2/depth?pair=#{symbol}";

  public static final String URL_TICKER = "/api/v2/ticker?pair=#{symbol}";

  public static final String URL_K_LINE = "/api/v2/kline";

  public static final String URL_TRADE = "/api/v2/trades?pair=#{symbol}";

  public static final String URL_PAIR = "/api/v2/pairs";

  public static final String URL_PAIR_LIMIT = "/api/v2/pairLimits?pair=#{symbol}";
  /**
   * verify sign after
   */
  public static final String URL_ORDER_LIST = "/api/v2/orderList";

  public static final String URL_ORDER_INFO = "/api/v2/orderInfo";

  public static final String URL_ORDER_HISTORY = "/api/v2/orderHistory";

  public static final String URL_USER_INFO = "/api/v2/userinfo";

  public static final String URL_TRADE_HISTORY = "/api/v2/tradesHistory";

  public static final String URL_PLACE_ORDER = "/api/v2/placeOrder";

  public static final String URL_CANCEL_ORDER = "/api/v2/cancelOrder";

  public static final String URL_MY_TRADES = "/api/v2/myTrades";

  /**
   * webSocket
   */
  public static final String CHANNEL_TICKER = "idax_sub_{symbol}_ticker";

  public static final String CHANNEL_DEPTH_X = "idax_sub_{symbol}_depth";

  public static final String CHANNEL_DEPTH_XY = "idax_sub_{symbol}_depth_{number}";

  public static final String CHANNEL_KLINE = "idax_sub_{symbol}_kline_{period}";

  public static final String CHANNEL_TRADE = "idax_sub_{symbol}_trades";

  public static final String CHANNEL_ALL_TRADE = "idax_sub_{symbol}_alltrades";

  public static final String CHANNEL_MY_TRADE = "idax_sub_mytrade";

  public static final String CHANNEL_MY_ORDER = "idax_sub_myorder";


  public static final String BE_EQUAL_TO = "=";

  public static final String ALSO = "&";

  public static final String HMACSHA256 = "HmacSHA256";

  public static final String UTF_8 = "UTF-8";

  public static final String CONTENT_TYPE = "Content-Type";

  public static final String APPLICATION_JSON = "application/json";

  public static final String CONNECTION = "Connection";

  public static final String KEEP_ALIVE = "Keep-Alive";

  public static final String ETH_BTC = "ETH_BTC";

  public static final String SIGN = "sign";

  public static final String CLASS = "class";

}
