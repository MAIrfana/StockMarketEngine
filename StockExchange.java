import java.util.*;
import java.util.concurrent.*;


class StockExchange {
    private final int TICKER_COUNT = 1024;
    private final List<Queue<Order>> buyOrders;
    private final List<Queue<Order>> sellOrders;
    private final BlockingQueue<Order> orderQueue;

    StockExchange() {
        buyOrders = new ArrayList<>(TICKER_COUNT);
        sellOrders = new ArrayList<>(TICKER_COUNT);
        orderQueue = new LinkedBlockingDeque<>();

        for (int i = 0; i < TICKER_COUNT; i++) {
            buyOrders.add(new PriorityQueue<>((a, b) -> Double.compare(b.price, a.price)));
            sellOrders.add(new PriorityQueue<>(Comparator.comparingDouble(a -> a.price)));
        }
    }

    // Adding each orders to order queue
    public void addOrders(Order.OrderType type, String ticker, int quantity, double price) {
        Order order = new Order(type, ticker, quantity, price);
        orderQueue.offer(order);
    }

    public static void Log(int matchedQuantity , Order buy , Order sell){
        System.out.printf("%5d shares of %-10s bought at selling price %6.2f $ \n" ,matchedQuantity, "["+buy.ticker+"]" , sell.price);
    }
    public void processOrder() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            if (order == null) continue;
            int tickerID = Math.abs(order.ticker.hashCode() % TICKER_COUNT);
            if(order.type == Order.OrderType.BUY ){
                buyOrders.get(tickerID).offer(order);
            }else{
                sellOrders.get(tickerID).offer(order);
            }
            matchOrders(tickerID);
        }
    }

    public void matchOrders(int tickerID) {
        Queue<Order> buys = buyOrders.get(tickerID);
        Queue<Order> sells = sellOrders.get(tickerID);
        while(!buys.isEmpty() && !sells.isEmpty()){
            Order buy = buys.peek();
            Order sell = sells.peek();

            if(!buy.ticker.equals(sell.ticker)) break;

            if( buy.price >= sell.price){
                int matchedQuantity = Math.min(buy.quantity , sell.quantity);

                buy.quantity -=matchedQuantity;
                sell.quantity -= matchedQuantity;

                Log(matchedQuantity , buy  , sell);
                if(buy.quantity==0) buys.poll();
                if(sell.quantity==0) sells.poll();
            }else {
                break;
            }

        }

    }
}