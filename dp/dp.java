// knapsack problem

int knapsack(int w, int[] wt, int[] val, int n){
        int[][] dp = new int[n+1][w+1];
        
        for(int i=0; i<n+1; i++){
            for(int j=0; j<w+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(wt[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
 }

 // Subset sum problem
 -> Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 
 
 int subsetSum(int[] arr, int sum, int n){
        if(sum == 0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }
        if(arr[n-1]>sum){
            dp[n][sum] = subsetSum(arr, sum, n-1);
        }
        else{
            dp[n][sum] = subsetSum(arr, sum-arr[n-1], n-1) | subsetSum(arr,sum,n-1);
        }
        return dp[n][sum];
  }
  
  int subsetSumIterative(int[] arr, int sum, int n){
        boolean subset[][] = new boolean[sum + 1][n + 1];
        
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                                   || subset[i - set[j - 1]][j - 1];
            }
        }
        return dp[sum][n];
    }

//Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?

static long countWays(int coins[], int m, int n)
{
  long[] table = new long[n+1];
  Arrays.fill(table, 0);
  table[0] = 1;

  for(int i=0; i<m; i++){
   for(int j=s[i]; j<=n; j++){
      dp[j]+=dp[j-coins[i]];
   }
  }
  return dp[n];
}

// Minm coins to make cents
static int minCoins(int coins[], int m, int V)
    {
        int table[] = new int[V + 1];

        table[0] = 0;
 
        for (int i = 1; i <= V; i++)
                table[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
            if (coins[j] <= i)
            {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE
                       && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;   
            }
        }
       
        if(table[V]==Integer.MAX_VALUE)
          return -1;
       
        return table[V];
}

//Longest common Subsequence
int lcs(String s, String t, int m, int n){
        int[][] dp = new int[m+1][n+1];    //stores length till (i,j)
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(s.charAt(i) == t.charAt(i)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        String ans = "";
        int l = m; int r=n;
        while(l>0 && r>0){
            if(s.charAt(l)==t.charAt(r)){
                ans += s.charAt(l);
                l--; r--;
            }
            else if(dp[l-1][r] > dp[l][r-1]){
                l--;
            }
            else{
                r--;
            }
        }
        
        StringBuilder sb = new StringBuilder(ans);
        ans = sb.reverse().toString(); //lcs string
        
        return dp[m][n];
}

//Longest common substring

int res = 0;
int row = 0, col = 0;
int lcs(String s, String t, int m, int n){
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(s.charAt(i) == t.charAt(i)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(res<dp[i][j]){
                        res = dp[i][j];
                        row = i;
                        col = j;
                    }
                }
                else{
                    dp[i][j] = 0; //doesn't match set 0
                }
            }
        }
        String ans = ""; //longest common substring
        while(dp[row][col] != 0){
             ans = s.charAt(row-1)+ans;
             row--;
             col--;
        }
        
        return res;
}
