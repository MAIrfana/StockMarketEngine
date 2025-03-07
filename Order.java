class Order {
    enum OrderType {BUY, SELL};
    OrderType type ;     
    String ticker;
    int quantity ;
    double price ;

    public Order(OrderType type , String ticker , int quantity , double price){
        this.type = type;
        this.ticker = ticker;
        this.quantity = quantity;
        this.price = price;        
    }


    public void Print(){
        System.out.println("---------------");
        System.out.println(" ORDER TYPE : "+ this.type);
        System.out.println(" ORDER TICKER : "+ this.ticker);
        System.out.println(" ORDER QUANTITY : "+ this.quantity);
        System.out.println(" ORDER PRICE : "+ this.price);
        System.out.println("---------------");
    }
}