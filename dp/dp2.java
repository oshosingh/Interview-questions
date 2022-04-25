// Longest palindromic subsequence
int palSub(String s, int n){
    StringBuilder sb = new String(s);
    String t = sb.reverse().toString();

    int[][] dp = new int[n+1][n+1];

    for(int i=0; i<n+1; i++){
        for(int j=0; j<n+1; j++){
            if(i==0 || j==0){
                dp[i][j] = 0;
            }
            else if(s.charAt(i)==t.charAt(j)){
                dp[i][j] = 1+dp[i-1][j-1];
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }

    return dp[n][n];
}

// Longest palindromic substring
int palSubstring(String s, int n){
    int maxLen = 1;
    boolean[][] dp = new boolean[n][n];
    int start = 0;

    // one length palindrome
    for(int i=0; i<n; i++){
        dp[i][i] = true;
    }

    // two length palindrome
    for(int i=0; i<n-1; i++){
        if(s.charAt(i)==s.charAt(i+1)){
            dp[i][i+1] = true;
            start = i;
            maxLen = 2;
        }
    }

    // K length palindrome
    for(int k=3; k<=n; k++){
        for(int i=0; i<n-k+1; i++){
            int j = i+k-1;
            if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                dp[i][j] = true;
                if(k>maxLen){
                    start = i;
                    maxLen = k;
                }
            }
        }
    }

    String ans = s.substring(start, start+maxLen); //palindrome string

    return maxLen;
}