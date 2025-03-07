import java.util.*;
public class StockSimulator {
    public static final int TICKER_COUNT = 1024;
    public static final Random RANDOM = new Random();
    public static String [] TICKER;
    static {
        TICKER = new String[TICKER_COUNT];
        for(int i =0;i<TICKER_COUNT;i++){
            TICKER[i] = "STOCK"+(i+1);
        }
    }
    public static void simulate(){
        while(true){
            Order.OrderType type = RANDOM.nextBoolean()? Order.OrderType.BUY: Order.OrderType.SELL;
            String ticker = TICKER[RANDOM.nextInt(1024)];
            int quantity = RANDOM.nextInt(100)+1;
            double price = 10 + (490 * RANDOM.nextDouble());

            System.out.println(ticker+" "+type+" "+" "+quantity+" "+price);
            try {
                Thread.sleep((long) (10 + RANDOM.nextDouble() * 500));
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
