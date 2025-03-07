# StockMarketEngine
Simple java application to simulate real time stock market

### Requirements : 
- [x] "addOrder" method parameters ( OrderType(buy or sell ) , Ticker Symbol , Quantity , Price )
- [x] Should support 1024 Tickers
- [x] wrapper method to generate random parameters.
- [x] "matchOrder" method , finds the matching buyer and seller from orders for the same Ticker symbol
- [x] BUY.Price ["TICKER"] >= Min ( SELL.price["TICKER"] );
- [x] Running multiple Stock Brokers.
- [x] Implementing Lock-Free Data Structures.
- [x] "matchOrder" function  Time Complexity = "O(n)";

