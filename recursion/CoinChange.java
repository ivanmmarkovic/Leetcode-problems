
import java.util.HashMap;

/*

322. Coin Change
Medium

https://leetcode.com/problems/coin-change/

Runtime: 175 ms, faster than 5.01% of Java online submissions for Coin Change.
Memory Usage: 40.9 MB, less than 39.39% of Java online submissions for Coin Change.

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

*/

class CoinChange {
    HashMap<Integer, Integer> prev = new HashMap<Integer, Integer>();
    
    public int coinChange(int[] coins, int amount) {
        Integer result = coinChangeHelper(coins, amount);
        return result.equals(Integer.MAX_VALUE) ? -1 : result.intValue();
    }
    
    public Integer coinChangeHelper(int[] coins, int amount) {
        if(amount < 0)
            return Integer.MAX_VALUE;
        else if(amount == 0)
            return 0;
        else {
            if(prev.containsKey(amount))
                return prev.get(amount);
            
            int count = Integer.MAX_VALUE;
            for(int c: coins){
                Integer t = coinChangeHelper(coins, (amount - c));
                if(!t.equals(Integer.MAX_VALUE))
                    t = t + 1;
                count = Math.min(count, t);
            }
            prev.put(amount, count);
            return prev.get(amount);
        }
    }
}