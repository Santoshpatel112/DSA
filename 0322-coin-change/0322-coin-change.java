class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(i==0){
                    dp[i][j]=(int)1e9;
                }
                if(j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(coins[i-1] <=j){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]] ,dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int ans= dp[n][amount];
        return ans >=1e9 ?-1 :ans;
    }
}