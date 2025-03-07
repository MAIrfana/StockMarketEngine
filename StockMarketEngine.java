class StockMarketEngine {
    public static void main(String args[]) {
        StockExchange exchange = new StockExchange();

        Thread simulationThread = new Thread(() -> StockSimulator.simulate(exchange));
        simulationThread.start();

        while (true){
            exchange.processOrder();
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}