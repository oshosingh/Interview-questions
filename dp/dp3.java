// Egg Drop

int[][] dp = new int[n][k];
int eggDrop(int n, int k){
    if(k<=1){
        return 0;
    }
    if(n==1){
        return k;
    }
    if(dp[n][k] != -1){
        return dp[n][k];
    }

    int x = 1;
    int min = Integer.MAX_VALUE;

    for(x=1; x<=k; x++){
        int res = Math.max( eggDrop(n, k-x), eggDrop(n-1, x-1) );
        min = Math.min(min, res);
    }

    dp[n][k] = min+1;  //add 1 because use one egg should be counted as trial
    return dp[n][k];
}

// Maximum increasing subsequence
int maxSum(int a[], int n){
    int[] dp = new int[n];
    int max = 0;

    for(int i=0; i<n; i++){
        dp[i] = a[i];
    }

    for(int i=n-2; i>=0; i--){
        for(int j=i+1; j<n; j++){
            if(a[i]<a[j]){
                dp[i] = Math.max(dp[i], a[i]+dp[j]);
            }
        }
        max = Math.max(max, dp[i]);
    }

    return max;
}

// Kadanes' algorithm. maximum subarray sum
int kadane(int a[], int n){
    int maxSoFar = 0;
    int maxEndingHere = 0;
    int start=0, end = 0, s=0;
    for(int i=0; i<n; i++){
        maxEndingHere += a[i];
        if(maxSoFar < maxEndingHere){
            maxSoFar = maxEndingHere;
            start = s;
            end = i;
        }
        else{
            maxEndingHere = 0;
            s = i+1;
        }
    }
    // [a[start], a[end]] is the subarray 
    return maxSoFar;
}

// Cut rod
int cutRod(int price[], int n){
    int[] dp = new int[n+1];
    dp[0] = 0;

    for(int i=1; i<=n; i++){
        int maxVal = 0;
        for(int j=0; j<i; j++){
            maxVal = Math.max(maxVal, price[j] + dp[i-j-1]);
        }
        dp[i] = maxVal;
    }

    return dp[n];
}

// Min Cost Path
int cost(int[][] grid){
    int m = grid.length; int n = grid[0].length;
    //first col
    for(int i=1; i<m; i++){
        grid[i][0] += grid[i-1][0];
    }

    //first row
    for(int i=1; i<n; i++){
        grid[0][i] += grid[0][i-1];
    }

    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        }
    }

    return grid[m-1][n-1];
}