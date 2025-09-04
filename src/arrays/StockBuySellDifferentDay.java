package arrays;
public class StockBuySellDifferentDay {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(sellBuyStock(prices));
    }

    private static int sellBuyStock(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        int buy_price = prices[0];
        for(int i=1;i<prices.length;i++) {
            if(prices[i]<buy_price) {
                buy_price = prices[i];
            } else {
                int sell_price = prices[i];
                profit = sell_price - buy_price;
            }
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
    
}
