# Java IDAX API

idax-java-api is a lightweight Java library for interacting with the [IDAX  API](https://github.com/idax-exchange/idax-official-api-docs/blob/master/open-api_en.md#overview), providing complete API coverage, and supporting synchronous  requests, as well as event streaming using WebSocket.

## Features
* Support for synchronous REST requests to all [General](https://www.idax.com/restapipub.html#user-content-general-endpoints), [Market Data](https://www.idax.com/restapipub.html#user-content-market-data-endpoints), [Account](https://www.idax.com/restapipub.html#user-content-account-endpoints) endpoints, and [User](https://www.idax.com/restapipub.html#user-content-user-data-stream-endpoints) stream endpoints.
* Support for User Data, Trade, Kline, and Depth event streaming using [IDAX WebSocket API](https://github.com/idax-exchange/idax-official-api-docs/blob/master/open-ws_en.md#websocket-service).

## Installation
1. Install library into your Maven's local repository by running `mvn install`
2. Add the following Maven dependency to your project's `pom.xml`:
```
        <dependency>
            <groupId>pro.idax.api.client</groupId>
            <artifactId>idax-api-client</artifactId>
            <version>1.0.0</version>
        </dependency>
```

Alternatively, you can clone this repository and run the [examples](https://github.com/joaopsilva/idax-java-api/tree/master/src/test/java/com/idax/api/examples).

## Examples

### Getting Started

There are three main client classes that can be used to interact with the API:

1. [`idaxApiRestClient`](https://github.com/joaopsilva/idax-java-api/blob/master/src/main/java/com/idax/api/client/idaxApiRestClient.java), a synchronous/blocking [idax API](https://github.com/idax-exchange/idax-official-api-docs/blob/master/open-api_en.md#overview) client;
2. [`idaxApiWebSocketClient`](https://github.com/joaopsilva/idax-java-api/blob/master/src/main/java/com/idax/api/client/idaxApiWebSocketClient.java), a data streaming client using [idax WebSocket API](https://github.com/idax-exchange/idax-official-api-docs/blob/master/open-ws_en.md#websocket-service).

These can be instantiated through the corresponding factory method of [`idaxApiClientFactory`](https://github.com/joaopsilva/idax-java-api/blob/master/src/main/java/com/idax/api/client/idaxApiClientFactory.java), by passing the [security parameters](https://www.idax.global/#/#user-content-endpoint-security-type) `API-KEY` and `SECRET`, which can be created at [https://www.idax.global/#/](https://www.idax.global/#/).

#### Initialize the REST client
```java
    /**
     * init IdaxApiClientFactory
     *
     * @return IdaxApiRestClient
     */
    public static IdaxApiRestClient init() {

        IdaxApiClientFactory factory = IdaxApiClientFactory.newInstance(API_KEY, SECRET, API_BASE_URL);

        return factory.newRestClient();
    }

```

If the client only needs to access endpoints which do not require additional security, then these parameters are optional.

Once the client is instantiated, it is possible to start making requests to the API.

### General endpoints

### Market Data endpoints by

#### Order book of a symbol
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        OrderBookEntry orderBook = idaxApiRestClient.getOrderBook(symbol);

        log.info("getOrderBook result:{}", JSON.toJSONString(orderBook));
```
<details>
 <summary>View Response</summary>
</details> 
 ```java
OrderBookEntry:
  asks:
    [0.03650000,
    7.68900000]
  bids:
    [0.03477500,
    0.95000000]
```

#### order place in Idax of {@link PlaceOrderRequest}
```java
        /***Initialize the calling object**/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
        placeOrderRequest.setPair("APL_BTC");
        placeOrderRequest.setTimestamp(System.currentTimeMillis());
        placeOrderRequest.setAmount(new BigDecimal("11211111"));
        String price = new BigDecimal("0.00000007").toPlainString();
        placeOrderRequest.setPrice(new BigDecimal(price));
        placeOrderRequest.setOrderType(OrderTypeEnum.LIMIT.getCode());
        placeOrderRequest.setOrderSide(OrderSideEnum.BUY.getCode());
        placeOrderRequest.setKey(IdaxConfig.API_KEY);

        /**Call remote interface**/
        PlaceOrderEntry placeOrderEntry = idaxApiRestClient.placeOrder(placeOrderRequest);

        log.info("placeOrder result:{}", JSON.toJSONString(placeOrderEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
PlaceOrderEntry:
(code=10000, msg=Successful request processing, orderId=2000000000004975822)
```


#### cancel order in Idax of{@link CancelOrderRequest}
```java
        /***init IdaxApiRestClient*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();
        cancelOrderRequest.setKey(IdaxConfig.API_KEY);
        cancelOrderRequest.setTimestamp(System.currentTimeMillis());
        cancelOrderRequest.setOrderId("9798");

        /**Call remote interface**/
        CancelOrderEntry cancelOrderEntry = idaxApiRestClient.cancelOrder(cancelOrderRequest);

        log.info("cancelOrder result:{}", JSON.toJSONString(cancelOrderEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
CancelOrderEntry:
(code=10000, msg=Successful request processing, accepted=2000000000004975822)
```


#### Get ticker of a symbol.
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        TickerEntry tickerEntry = idaxApiRestClient.getTickerEntry(symbol);

        log.info("getTicker result:{}", JSON.toJSONString(tickerEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
TickerEntry:
{timestamp=1544008209324, code='10000', msg='Successful request processing',
ticker=[Ticker(symbol=null, lastPrice=null, bidPrice=null, askPrice=null,
open=0.99990000, high=11.00000000, low=0.05011800, last=11.00000000, vol=1094.37100000)]}
```

#### Get kline of a param{@link KlineRequest}.
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        KlineRequest kLineRequest = new KlineRequest();
        kLineRequest.setPair(symbol);
        kLineRequest.setPeriod(PeriodEnum.ONE_WEEK.getCode());
        kLineRequest.setSize(10);
        kLineRequest.setSince(System.currentTimeMillis());

        /**Call remote interface**/
        KlineEntry klineEntry = idaxApiRestClient.getKlineEntry(kLineRequest);

        log.info("getKlineEntry result:{}", JSON.toJSONString(klineEntry));
```
<details>
 <summary>View Response</summary>
</details>

```java
KlineEntry:
{timestamp=null, code='10000',
kline=[[1538352000000,"0.04154200","1000000.00000000","0.04153100","0.04153900",
"95591.02800000"],[1543190400000,"0.05011800","11.00000000","0.05011800","11.00000000","31681.76300000"],
[1543795200000,"0.05011800","11.00000000","0.05011800","11.00000000","1097.37100000"]]}

```

#### Get trade of a symbol.
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        TradeEntry tradeEntry = idaxApiRestClient.getTradeEntry(symbol);

        log.info("getTradeEntry result:{}", JSON.toJSONString(tradeEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
TradeEntry:
{code='10000', msg='Successful request processing',
 trades=[ Trade{timestamp=1542969741000, price='11.00000000',
 id='7467ced9-d8b7-4d3c-8b3e-bdbe8939fa69', quantity='1000.00000000', maker='Buy'},
  Trade{timestamp=1543217526000, price='0.05011800', id='1183119a-d130-4591-9dcd-4af388a8a427', quantity='5.00000000', maker='Sell'}, Trade{timestamp=1543217591000, price='0.05011800', id='46dbcd39-95cf-4395-b642-35cc54073f79', quantity='2.00000000', maker='Sell'}, Trade{timestamp=1543225554000, price='11.00000000', id='aec3a971-2922-4758-825b-1d33dcbc5e05', quantity='1132.052', maker='Buy'}, Trade{timestamp=1543308305000, price='0.05011800', id='2bdbc36b-c969-48b6-927c-b810e834c6df', quantity='25019.91600000', maker='Sell'}, Trade{timestamp=1543312142000, price='11.00000000', id='75887abc-b1ae-4121-ac27-d590132e2776', quantity='0.069', maker='Buy'}, Trade{timestamp=1543312180000, price='11.00000000', id='dc2240a7-c98f-4aca-8db0-a9549c64d993', quantity='0.041', maker='Buy'}, Trade{timestamp=1543312272000, price='11.00000000', id='b3106776-7db4-439e-808e-52d493da3af9', quantity='2501.27', maker='Buy'}, Trade{timestamp=1543312371000, price='11.00000000', id='3abe5ce1-3b84-47c8-a669-cd22ecbb0607', quantity='6.06', maker='Buy'}, Trade{timestamp=1543312501000, price='0.05011800', id='feceb422-a4db-4878-a9f6-ca0d1d5ce955', quantity='1.00000000', maker='Sell'}, Trade{timestamp=1543390444000, price='0.05011800', id='a95c169e-ae0d-406f-a5a9-5304897591f5', quantity='5.00000000', maker='Sell'}, Trade{timestamp=1543390462000, price='0.05011800', id='f433b81e-e3a1-4ba5-bc22-f02f5c7f5125', quantity='10.00000000', maker='Sell'}, Trade{timestamp=1543390723000, price='0.05011800', id='f73fa870-20bf-4a0a-9df3-11364f31bc4d', quantity='5.00000000', maker='Sell'}, Trade{timestamp=1543390808000, price='0.05011800', id='ac06fa1d-46d0-468e-be5f-99199998a355', quantity='10.00000000', maker='Sell'}, Trade{timestamp=1543392562000, price='0.05011800', id='f54b735a-49cd-4143-a4de-891eca373202', quantity='0.65600000', maker='Sell'}, Trade{timestamp=1543458097000, price='0.05011800', id='c15b9537-9bfa-4b1a-af61-bb8ac0ee9d53', quantity='10.00000000', maker='Sell'}, Trade{timestamp=1543458119000, price='0.05011800', id='856bd876-f7c2-4325-9916-cbbde435e646', quantity='5.00000000', maker='Sell'}, Trade{timestamp=1543474049000, price='11.00000000', id='a209f01f-a1f7-4d6e-b2bc-e98c2d38f4ed', quantity='0.009', maker='Buy'}, Trade{timestamp=1543475061000, price='11.00000000', id='5b73fde5-f802-47ad-9d25-daf7159f7a67', quantity='0.09', maker='Buy'}, Trade{timestamp=1543475255000, price='11.00000000', id='961b1271-b317-4984-892b-d85c00d65959', quantity='674.791', maker='Buy'}, Trade{timestamp=1543475306000, price='0.05011800', id='086fad87-f306-4d05-b5e2-f6df587e23d6', quantity='0.00300000', maker='Sell'}, Trade{timestamp=1543475907000, price='11.00000000', id='a264570d-3875-4bc0-9931-aea54ff600ad', quantity='0.009', maker='Buy'}, Trade{timestamp=1543475943000, price='11.00000000', id='4611c8d7-0e07-4a5e-a00e-74d0adb72339', quantity='0.009', maker='Buy'}, Trade{timestamp=1543475986000, price='11.00000000', id='6fda6b53-0d74-40fa-bbdc-99eb5c8e4464', quantity='0.009', maker='Buy'}, Trade{timestamp=1543476776000, price='0.05011800', id='8baba86e-47c9-47df-a982-c0672ebba4c3', quantity='0.00200000', maker='Sell'}, Trade{timestamp=1543477082000, price='0.05011800', id='8dd70e58-909a-49f7-9679-ba20a2071e2c', quantity='10.00000000', maker='Sell'}, Trade{timestamp=1543477141000, price='11.00000000', id='26a6d1a8-e2eb-4e10-ba3c-45849273782b', quantity='0.234', maker='Buy'}, Trade{timestamp=1543477212000, price='0.05011800', id='b2a49b37-0fbf-48e5-bac6-d358551b1e2b', quantity='0.00100000', maker='Sell'}, Trade{timestamp=1543477237000, price='11.00000000', id='2f804288-a46c-4ab5-8b12-793ea1ff6f95', quantity='0.294', maker='Buy'}, Trade{timestamp=1543477621000, price='11.00000000', id='82c2f7d2-363e-45ca-92d2-384861578c5f', quantity='0.009', maker='Buy'}, Trade{timestamp=1543478352000, price='0.05011800', id='1b672cf7-d643-41e1-b352-b8447790802f', quantity='5.00000000', maker='Sell'}, Trade{timestamp=1543478426000, price='11.00000000', id='13a5677b-2c33-4d1a-999d-083553ff2945', quantity='5.00000000', maker='Buy'}, Trade{timestamp=1543482833000, price='11.00000000', id='aa19f763-aac0-433f-86dc-a4b358937efa', quantity='0.10000000', maker='Buy'}, Trade{timestamp=1543482852000, price='11.00000000', id='86a04453-d815-4034-a361-503f92a4807f', quantity='0.009', maker='Buy'}, Trade{timestamp=1543484376000, price='11.00000000', id='ad3ca337-f214-45ea-8dd6-4627939571be', quantity='0.009', maker='Buy'}, Trade{timestamp=1543485180000, price='0.05011800', id='19e16d1d-9fb7-4495-aded-0dd41ba2408b', quantity='0.52300000', maker='Sell'}, Trade{timestamp=1543485225000, price='11.00000000', id='542b437b-ec9b-423e-a974-9b6aeb4d562f', quantity='0.009', maker='Buy'}, Trade{timestamp=1543492440000, price='11.00000000', id='d4a924ba-be74-4d87-9ad1-7bf184dd802e', quantity='0.009', maker='Buy'}, Trade{timestamp=1543493672000, price='11.00000000', id='5db2f94e-d8b2-4be7-80d4-daca32176bb3', quantity='0.009', maker='Buy'}, Trade{timestamp=1543557413000, price='11.00000000', id='e5e66ca8-ac45-42c8-83b4-4cca85006f01', quantity='1874.94000000', maker='Buy'}, Trade{timestamp=1543559294000, price='11.00000000', id='ee8a8060-c168-4073-be2b-ca599359bfcb', quantity='397.63100000', maker='Sell'}, Trade{timestamp=1543822196000, price='0.05011800', id='7f4eb624-f087-40c2-a45a-70f8577c389d', quantity='1.00000000', maker='Sell'}, Trade{timestamp=1543830894000, price='11.00000000', id='4118baee-7cb2-480c-8747-770d8877cafa', quantity='1.00000000', maker='Buy'}, Trade{timestamp=1543893706000, price='0.05011800', id='bd9e529d-9cf8-4db9-84cf-27df64c78efe', quantity='1.00000000', maker='Sell'}, Trade{timestamp=1543988585000, price='0.99990000', id='fd3a22ea-80e9-4b95-8ab6-d0c7273f100e', quantity='2.00000000', maker='Sell'}, Trade{timestamp=1543988596000, price='0.99990000', id='a990265d-e48b-4fcc-8dae-bcd551e274c5', quantity='2.00000000', maker='Sell'}, Trade{timestamp=1543991596000, price='11.00000000', id='e95a385f-23be-48a9-9142-178d93ab918a', quantity='0.181', maker='Buy'}, Trade{timestamp=1543991650000, price='11.00000000', id='b5990786-0b29-405c-8a66-8d2e311d0945', quantity='0.181', maker='Buy'}, Trade{timestamp=1543992087000, price='3.00000000', id='b2e7927f-d19d-4505-988b-396695163fc1', quantity='2.00000000', maker='Sell'}, Trade{timestamp=1543992107000, price='3.00000000', id='f400c5ea-c7bc-477f-9f61-a8aba4579ed1', quantity='1.00000000', maker='Sell'}, Trade{timestamp=1543992107000, price='0.99990000', id='b31f64ed-71ea-4f80-a789-c844bcae1b37', quantity='1.00000000', maker='Sell'}, Trade{timestamp=1543992114000, price='0.99990000', id='4349461a-4353-4ce6-9a3a-ed7085769a5d', quantity='33.00000000', maker='Sell'}, Trade{timestamp=1543992121000, price='0.99990000', id='ff6162be-ce85-435c-968a-4b88eec8e921', quantity='62.00000000', maker='Sell'}, Trade{timestamp=1543992121000, price='0.99990000', id='fb22c539-d368-43b2-a509-c699208aca59', quantity='2.00000000', maker='Sell'}, Trade{timestamp=1543992121000, price='0.05011800', id='48f34fdf-b6ed-4c5e-b6bd-d793a69ffbae', quantity='936.00000000', maker='Sell'}, Trade{timestamp=1543992131000, price='0.05011800', id='a35f58eb-34ee-40d6-985d-1b309e5955c4', quantity='33.00000000', maker='Sell'}, Trade{timestamp=1543995899000, price='0.05011800', id='c34eb793-0e14-4bc6-aa80-31dfb937703d', quantity='20.00000000', maker='Sell'}, Trade{timestamp=1544005121000, price='11.00000000', id='bb52075d-2b3e-4009-9134-37a2b725e49e', quantity='0.009', maker='Buy'}]}

```

#### Get pair .
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Call remote interface**/
        PairEntry pairEntry = idaxApiRestClient.getPairEntry();

        log.info("getPairEntry result:{}", JSON.toJSONString(pairEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
PairEntry:
{code='10000', msg='Successful request processing',
pairs=[ETC_USDT, BTM_ETH, ETC_ETH, COS_ETH, BTS_USDT, TRX_BTC, STORJ_BTC,
GUPASS_ETH, AE_BTC, LTC_ETH, ABTC_BTC, SW_ETH, LRC_ETH, OMG_BTC, ETC_BTC, BTC_USDT, XRP_BTC,
 LTC_USDT, ABTC_ETH, BCH_ETH, EOS_ETH, XRP_USDT, SNT_BTC, ETH_USDT, STORJ_ETH, BCH_BTC, SPD_ETH,
 ZAT_ETH, OMG_ETH, ETH_BTC, XRP_ETH, ZAT_USDT]}
```

#### Get pairlimit of a symbol.
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;

        /**Call remote interface**/
        PairLimitEntry pairLimitEntry = idaxApiRestClient.getPairLimitEntry(symbol);

        log.info("getPairLimitEntry result:{}", JSON.toJSONString(pairLimitEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
PairLimitEntry:
{code='10000', msg='Successful request processing',
pairRuleVo=[PairRule{pairName='BTS_ETH', maxAmount='100000000.00000000', minAmount='0.00010000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='SNT_ETH', maxAmount='10000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='LTC_BTC', maxAmount='1000000.00000000', minAmount='0.00010000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='SFU_BTC', maxAmount='1000000000000000.0', minAmount='0.001', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='TRX_ETH', maxAmount='100.00000000', minAmount='0.00000000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='AAA_BTC', maxAmount='10000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=2}, PairRule{pairName='BTM_BTC', maxAmount='10000000.00000000', minAmount='0.00100000', priceDecimalPlace=6, qtyDecimalPlace=3}, PairRule{pairName='AE_ETH', maxAmount='100000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='EOS_BTC', maxAmount='1000000000.00000000', minAmount='0.00000001', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='BTS_BTC', maxAmount='10000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='BCH_USDT', maxAmount='10000000.0', minAmount='0.001', priceDecimalPlace=2, qtyDecimalPlace=3}, PairRule{pairName='LRC_BTC', maxAmount='1000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='SW_BTC', maxAmount='100.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=4}, PairRule{pairName='ZAT_BTC', maxAmount='100.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=5}, PairRule{pairName='SDL_ETH', maxAmount='10000000.00000000', minAmount='100.00000000', priceDecimalPlace=6, qtyDecimalPlace=0}, PairRule{pairName='FTL_ETH', maxAmount='10000000.00000000', minAmount='100.00000000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='SPD_BTC', maxAmount='10.00000000', minAmount='0.00000000', priceDecimalPlace=0, qtyDecimalPlace=0}, PairRule{pairName='ETC_USDT', maxAmount='1000000.00000000', minAmount='0.00010000', priceDecimalPlace=4, qtyDecimalPlace=2}, PairRule{pairName='BTM_ETH', maxAmount='10000000.00000000', minAmount='0.00100000', priceDecimalPlace=6, qtyDecimalPlace=3}, PairRule{pairName='ETC_ETH', maxAmount='10000000.0', minAmount='0.0001', priceDecimalPlace=8, qtyDecimalPlace=2}, PairRule{pairName='COS_ETH', maxAmount='10000000.00000000', minAmount='100.00000000', priceDecimalPlace=6, qtyDecimalPlace=3}, PairRule{pairName='BTS_USDT', maxAmount='10000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='TRX_BTC', maxAmount='100.00000000', minAmount='0.00000000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='STORJ_BTC', maxAmount='1000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='GUPASS_ETH', maxAmount='1000.00000000', minAmount='0.01000000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='AE_BTC', maxAmount='1000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='LTC_ETH', maxAmount='1000000.00000000', minAmount='0.00010000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='ABTC_BTC', maxAmount='1000.00000000', minAmount='0.00000000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='SW_ETH', maxAmount='1000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=4}, PairRule{pairName='LRC_ETH', maxAmount='100000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='OMG_BTC', maxAmount='10000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=8}, PairRule{pairName='ETC_BTC', maxAmount='1000000.0', minAmount='0.0001', priceDecimalPlace=8, qtyDecimalPlace=2}, PairRule{pairName='BTC_USDT', maxAmount='100000.00000000', minAmount='0.00100000', priceDecimalPlace=2, qtyDecimalPlace=6}, PairRule{pairName='XRP_BTC', maxAmount='10000000.00000000', minAmount='0.00010000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='LTC_USDT', maxAmount='0.00000000', minAmount='0.00000000', priceDecimalPlace=0, qtyDecimalPlace=0}, PairRule{pairName='ABTC_ETH', maxAmount='1000.00000000', minAmount='0.00000000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='BCH_ETH', maxAmount='10000000.0', minAmount='0.0001', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='EOS_ETH', maxAmount='100000000.00000000', minAmount='0.00100000', priceDecimalPlace=6, qtyDecimalPlace=3}, PairRule{pairName='XRP_USDT', maxAmount='10000000000000.00000000', minAmount='0.00010000', priceDecimalPlace=5, qtyDecimalPlace=0},
PairRule{pairName='SNT_BTC', maxAmount='10000000.00000000', minAmount='0.0000001', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='ETH_USDT', maxAmount='100000.00000000', minAmount='0.00100000', priceDecimalPlace=2, qtyDecimalPlace=5}, PairRule{pairName='STORJ_ETH', maxAmount='100000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='BCH_BTC', maxAmount='10000000.00000000', minAmount='0.00010000', priceDecimalPlace=6, qtyDecimalPlace=3}, PairRule{pairName='SPD_ETH', maxAmount='100.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=3}, PairRule{pairName='ZAT_ETH', maxAmount='1000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=0}, PairRule{pairName='OMG_ETH', maxAmount='100000000.00000000', minAmount='0.00100000', priceDecimalPlace=8, qtyDecimalPlace=8}, PairRule{pairName='ETH_BTC', maxAmount='1000000000000.00000000', minAmount='0.00100000', priceDecimalPlace=6, qtyDecimalPlace=3}
]}
```

#### get order info  of {@link OrderInfoRequest}
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        OrderInfoRequest orderInfoRequest = new OrderInfoRequest();
        orderInfoRequest.setKey(IdaxConfig.API_KEY);
        orderInfoRequest.setPair(symbol);
        orderInfoRequest.setPageIndex(1);
        orderInfoRequest.setPageSize(20);
        orderInfoRequest.setTimestamp(System.currentTimeMillis());
        orderInfoRequest.setOrderId(9799L);

        /**Call remote interface**/
        OrderInfoEntry orderInfoEntry = idaxApiRestClient.getOrderInfo(orderInfoRequest);

        log.info("getOrderInfo result:{}", JSON.toJSONString(orderInfoEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
OrderInfoEntry:
(code=10000, msg=Successful request processing, total=0, orders=[])
```

#### get order history of {@link OrderHistoryRequest}
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        String symbol = IdaxApiConstants.ETH_BTC;
        OrderHistoryRequest orderHistoryRequest = new OrderHistoryRequest();
        orderHistoryRequest.setCurrentPage(1);
        orderHistoryRequest.setKey(IdaxConfig.API_KEY);
        orderHistoryRequest.setOrderState(-1);
        orderHistoryRequest.setPair(symbol);
        orderHistoryRequest.setTimestamp(System.currentTimeMillis());
        orderHistoryRequest.setPageLength(10);

        /**Call remote interface**/
        OrderHistoryEntry orderHistoryEntry = idaxApiRestClient.getOrderHistory(orderHistoryRequest);

        log.info("getOrderHistory result:{}", JSON.toJSONString(orderHistoryEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
OrderHistoryEntry:
{"code":10000,"msg":"Successful request processing","currentPage":1,"pageLength":10,"orders":[],"total":0}
```

#### get user info of {@link UserInfoRequest}
```java
        /***Initialize the calling object*/
        IdaxApiRestClient idaxApiRestClient = IdaxConfig.init();

        /**Request parameter encapsulation**/
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.setTimestamp(System.currentTimeMillis());
        userInfoRequest.setKey(IdaxConfig.API_KEY);

        /**Call remote interface**/
        UserInfoEntry userInfoEntry = idaxApiRestClient.getUserInfo(userInfoRequest);

        log.info("getUserInfoExample result:{}", JSON.toJSONString(userInfoEntry));
```
<details>
 <summary>View Response</summary>
</details>
```java
UserInfoEntry:
(code=10000, msg=Successful request processing, total={"BTS":"100000.00000000","VEX":"1.53442480","TRXold":"100000.00000000","ABTC":"100000.00000000","CNY":"100000.00000000","NFF":"0.00000000","SNT":"100000.00000000","SEER":"100000.00000000","SDL":"100000.00000000","AE":"100000.00000000","SW":"100000.00000000","COS":"100000.00000000","EOS":"100000.00000000","OMG":"100000.00000000","DCN":"100000.00000000","BTC":"100000.00000000","FUNDZ":"100000.00000000","ETH":"100000.00000000","NEO":"100000.00000000","BTM":"100000.00000000","OCN":"100000.00000000","XAC":"100000.00000000","LRC":"100000.00000000","MTC":"100000.00000000","STORJ":"100000.00000000","FTL":"100000.00000000"}, free={"BTS":"100000.00000000","VEX":"1.53442480","TRXold":"100000.00000000","ABTC":"100000.00000000","CNY":"100000.00000000","NFF":"0.00000000","SNT":"100000.00000000","SEER":"100000.00000000","SDL":"100000.00000000","AE":"100000.00000000","SW":"100000.00000000","COS":"100000.00000000","EOS":"100000.00000000","OMG":"100000.00000000","DCN":"100000.00000000","BTC":"99999.94378999","FUNDZ":"100000.00000000","ETH":"100000.11000000","NEO":"100000.00000000","BTM":"100000.00000000","OCN":"100000.00000000","XAC":"100000.00000000","LRC":"100000.00000000","MTC":"100000.00000000","STORJ":"100237.00000000","FTL":"100000.00000000"}, freezed={"BTS":"0.00000000","VEX":"0.00000000","TRXold":"0.00000000","ABTC":"0.00000000","CNY":"0.00000000","NFF":"0.00000000","SNT":"0.00000000","SEER":"0.00000000","SDL":"0.00000000","AE":"0.00000000","SW":"0.00000000","COS":"0.00000000","EOS":"0.00000000","OMG":"0.00000000","DCN":"0.00000000","BTC":"0.05621001","FUNDZ":"0.00000000","ETH":"-0.11000000","NEO":"0.00000000","BTM":"0.00000000","OCN":"0.00000000","XAC":"0.00000000","LRC":"0.00000000","MTC":"0.00000000","STORJ":"-237.00000000","FTL":"0.00000000"})

```

### WebSocket API

#### Initialize the WebSocket client
```java
    /**
     * wsInit  WebSocketClient
     * @return IdaxApiWebSocketClient
     */
    public static IdaxApiWebSocketClient wsInit(){

        IdaxApiClientFactory webSocketClient = IdaxApiClientFactory.newInstance(API_KEY, SECRET, WS_API_BASE_URL);

        return webSocketClient.newWebSocketClient();
    }
```

User needs to be aware that REST symbols which are `upper case` differ from WebSocket symbols which must be `lower case`.
In scenario of subscription with upper case styled symbol, server will return no error and subscribe to given channel - however, no events will be pushed.

#### Handling web socket errors

Each of the methods on `idaxApiWebSocketClient`, which opens a new web socket, takes a `idaxApiCallback`, which is
called for each event received from the idax servers.

The `idaxApiCallback` interface also has a `onFailure(Throwable)` method, which, optionally, can be implemented to
receive notifications if the web-socket fails, e.g. disconnection.

#### Closing web sockets

Each of the methods on `idaxApiWebSocketClient`, which opens a new web socket, also returns a `Closeable`.
This `Closeable` can be used to close the underlying web socket and free any associated resources, e.g.

```java
        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_depth**/
        Closeable closeable =idaxApiWebSocketClient.onDepthXEvent(symbol, response -> log.info("idaxSubXDepthExample response:{}",JSON.toJSON(response)));

        closeable.close();
```

#### Open a new web socket to receive DepthX on a callback
```java
        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_depth**/
        idaxApiWebSocketClient.onDepthXEvent(symbol,response -> log.info("idaxSubXDepthExample response:{}",JSON.toJSON(response)));

```
<details>
 <summary>View Response</summary>
</details>
```java
{"channel":"idax_sub_eth_btc_depth","data":[{"asks":[["11.00000000","1873.56000000"],["11.00000600","18524.80000000"],["1000000.00000000","2.90000000"],["10000000000000.00000000","0.00200000"]],"bids":[["0.05011800","3553184.18100000"],["0.05011200","419.40000000"],["0.04160000","124.00000000"],["0.04154000","975.87900000"],["0.04153900","465.00000000"],["0.04153700","151.00000000"],["0.04153600","1950.00000000"],["0.04153500","59767.12400000"],["0.04153100","4410.84200000"],["0.04153000","23.50000000"],["0.04151700","971.69000000"],["0.04148200","918.56800000"],["0.04144900","101.40600000"],["0.04142800","18.36500000"],["0.04095500","5.80000000"],["0.04095400","2.00000000"],["0.04095300","5.00000000"],["0.04094000","2.05000000"],["0.04093900","87.03600000"],["0.04093800","203.93200000"],["0.04092600","64.77200000"],["0.04092500","2.00000000"],["0.04092300","16.80300000"],["0.04092200","12.22100000"],["0.04092100","1.81800000"],["0.04092000","5.00800000"],["0.04091900","8.37300000"],["0.04091800","1.51800000"],["0.04091700","0.81800000"],["0.04091600","1.92000000"],["0.04091500","5.51200000"],["0.04091400","15.35800000"],["0.04091100","4.50000000"],["0.04090900","3.00000000"],["0.04090600","1.92000000"],["0.04090500","91.00000000"],["0.04090400","8.55000000"],["0.04090100","3.00500000"],["0.04090000","25.79400000"],["0.04089900","2.92000000"],["0.04089800","0.12800000"],["0.04089600","23.22200000"],["0.04089500","15.48500000"],["0.04089400","2.50000000"],["0.04089200","3.76900000"],["0.04089100","7.00000000"],["0.04089000","0.50000000"],["0.04088900","1.94800000"],["0.04088800","0.62000000"],["0.04088700","0.51000000"],["0.04088600","0.50000000"],["0.04088300","16.66800000"],["0.04088200","8.81900000"],["0.04088100","2.00000000"],["0.04088000","0.50000000"],["0.04087800","0.40000000"],["0.04087600","1.05900000"],["0.04086600","0.84600000"],["0.04086500","1.20000000"],["0.04086200","0.05000000"],["0.04085900","2.50000000"],["0.04085500","2.25300000"],["0.04085400","18.82400000"],["0.04085300","0.50000000"],["0.04085200","0.50000000"],["0.04085000","3.55500000"],["0.04084600","0.50000000"],["0.04084500","2.69300000"],["0.04083600","10.21000000"],["0.04082700","3.50000000"],["0.04082600","1.47100000"],["0.04080000","5.00000000"],["0.04079600","10.00000000"],["0.04077800","1.20000000"],["0.03263500","176.25800000"],["0.03249300","0.80600000"],["0.02797100","1.00000000"],["0.02000000","2.10000000"],["0.01153200","2.00000000"],["0.01151700","2.00000000"],["0.00000400","1000.00000000"],["0.00000100","100000000.00000000"],["0.00000001","200000.00000000"],["0.00000000","10010000000000.00000000"]],"timestamp":1544011244403}]}

...
```

####  Open a new web socket to receive DepthXY on a callback.
```java
        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_depth_Y**/
        idaxApiWebSocketClient.onDepthXYEvent(symbol,DepthYEnum.FIFTY.getCode(), response -> log.info("idaxSubXDepthYExample response:{}",JSON.toJSON(response)));

```
<details>
 <summary>View Response</summary>
</details>
```java
{"channel":"idax_sub_eth_btc_depth_50","data":[{"asks":[["11.00000000","1873.56000000"],["11.00000600","18524.80000000"],["1000000.00000000","2.90000000"],["10000000000000.00000000","0.00200000"]],"bids":[["0.05011800","3553184.18100000"],["0.05011200","419.40000000"],["0.04160000","124.00000000"],["0.04154000","975.87900000"],["0.04153900","465.00000000"],["0.04153700","151.00000000"],["0.04153600","1950.00000000"],["0.04153500","59767.12400000"],["0.04153100","4410.84200000"],["0.04153000","23.50000000"],["0.04151700","971.69000000"],["0.04148200","918.56800000"],["0.04144900","101.40600000"],["0.04142800","18.36500000"],["0.04095500","5.80000000"],["0.04095400","2.00000000"],["0.04095300","5.00000000"],["0.04094000","2.05000000"],["0.04093900","87.03600000"],["0.04093800","203.93200000"],["0.04092600","64.77200000"],["0.04092500","2.00000000"],["0.04092300","16.80300000"],["0.04092200","12.22100000"],["0.04092100","1.81800000"],["0.04092000","5.00800000"],["0.04091900","8.37300000"],["0.04091800","1.51800000"],["0.04091700","0.81800000"],["0.04091600","1.92000000"],["0.04091500","5.51200000"],["0.04091400","15.35800000"],["0.04091100","4.50000000"],["0.04090900","3.00000000"],["0.04090600","1.92000000"],["0.04090500","91.00000000"],
["0.04090400","8.55000000"],["0.04090100","3.00500000"],["0.04090000","25.79400000"],["0.04089900","2.92000000"],["0.04089800","0.12800000"],["0.04089600","23.22200000"],["0.04089500","15.48500000"],["0.04089400","2.50000000"],["0.04089200","3.76900000"],["0.04089100","7.00000000"],["0.04089000","0.50000000"],["0.04088900","1.94800000"],["0.04088800","0.62000000"],
["0.04088700","0.51000000"]],"timestamp":1544060963241}]}
...
```

#### Open a new web socket to receive ticker on a callback.
```java
        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_ticker**/
        idaxApiWebSocketClient.onTickerEvent(symbol, response -> log.info("idaxSubXTickerExample response:{}",JSON.toJSON(response)));

```
<details>
 <summary>View Response</summary>
</details>
```java
{"channel":"idax_sub_eth_btc_ticker","data":[{"high":"11.00000000","last":"11.00000000",
"low":"11.00000000","open":"11.00000000","timestamp":1544054401026,
"vol":"1094.38000000"}]}
```

#### Open a new web socket to receive KLine on a callback.

```java
        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        /**parameter**/
        String symbol = "ETH_BTC";

        /**Subscribe to X_kline_Y**/
        idaxApiWebSocketClient.onKLineEvent(symbol,PeriodEnum.ONE_WEEK, response -> log.info("idaxSubXKlineYExample response:{}",JSON.toJSON(response)));

```
<details>
 <summary>View Response</summary>
</details>
```java
{"channel":"idax_sub_eth_btc_kline_1week","code":"00000","data":[]}
...
```

#### Open a new web socket to receive MyTrade on a callback.

```java
        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        Map<String,Object> param = new HashMap<>(30);
        param.put("apiKey",IdaxConfig.API_KEY);
        param.put("timestamp",System.currentTimeMillis());

        /**Subscribe to myTrade**/
        idaxApiWebSocketClient.onMyTradeEvent(param,response -> log.info(JSON.toJSONString(response)));
```
<details>
 <summary>View Response</summary>
</details>
```java
{"channel":"idax_sub_eth_btc_trades","data":[]}
...
```


#### Open a new web socket to receive MyOrder on a callback.
Client provides a way for user to subscribe to multiple channels using same websocket - to achieve that user needs to coma-separate symbols as it is in following examples.

````java
        /***Initialize the calling object*/
        IdaxApiWebSocketClient idaxApiWebSocketClient = IdaxConfig.wsInit();

        Map<String,Object> param = new HashMap<>(30);
        param.put("apiKey",IdaxConfig.API_KEY);
        param.put("timestamp",System.currentTimeMillis());

        /**Subscribe to myOrder**/
        idaxApiWebSocketClient.onMyOrderEvent(param, response -> log.info(JSON.toJSONString(response)));
````
<details>
 <summary>View Response</summary>
</details>
```java
{"channel":"idax_sub_myorder","code":"00000","data":[]}
...
```

### More examples
An extensive set of examples, covering most aspects of the API, can be found at https://github.com/idax-exchange/idax-official-api-docs/blob/master/open-api_en.md#overview.
