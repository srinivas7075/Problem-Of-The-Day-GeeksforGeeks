class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int n = prices.length;
        int[] leftProfit = new int[n]; 
        int[] rightProfit = new int[n]; 
        
    
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit(prices1)); 
        
        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        System.out.println(maxProfit(prices2)); 
    }
}
