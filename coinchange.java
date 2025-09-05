class Solution {
    // public static int mincount;
    public int coinChange(int[] coins, int amount) {
        // mincount=Integer.MAX_VALUE;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-2);
        return countCoin(coins, amount,dp);
        // return mincount == Integer.MAX_VALUE ? -1 : mincount;

    }

    public int countCoin(int[] coins, int amount,int[] dp)
    {
        if(amount<0) 
        return -1;
        else if(amount==0)
        return 0;
        // else if(amount<0 || count>=mincount)
        // return;
        
        if(dp[amount]!=-2)
        return dp[amount];

        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++)
        {
            int sum =countCoin(coins,amount - coins[i],dp);
            if(sum>=0 && sum<min)
            {
                min=1+sum;
            }
        }
        dp[amount] = (min== Integer.MAX_VALUE) ? -1 : min;
        return dp[amount];
    }
}