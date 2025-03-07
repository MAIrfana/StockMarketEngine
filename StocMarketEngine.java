class StockMarketEngine {
    public static void main(String args[]){
        Order order = new Order(Order.OrderType.BUY , "TICK1" , 10 , 450.00);
        order.Print();
    }
}