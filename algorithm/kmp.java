// Find pattern in text
boolean kmp(String text, String pat){
    int m = text.length();
    int n = pat.length();

    int lps[] = new int[n];
    computeLpsArray(pat, n, lps);

    int i=0; //index for text
    int j=0; //index for pat

    while(i<m){
        if(pat.charAt(j)==text.charAt(i)){
            i++;
            j++;
        }

        if(j==n){
            System.out.println("Found pat at : "+ (i-j));
            j = lps[j-1];
        }

        else if(i<n && pat.charAt(j)!=text.charAt(i)){
            if(j!=0){
                j = lps[j-1];
            } 
            else{
                i++;
            }
        }
    }
}

void computeLpsArray(String pat, int n, int[] lps){
    lps[0] = 0;
    int len = 0;
    int i = 1;

    while(i<n){
        if(pat.charAt(i)==pat.charAt(length)){
            len++;
            lps[i] = len;
            i++;
        }
        else{
            //jump
            if(len!=0){
                len = lps[len-1];
            }
            else{
                lps[i] = len;
                i++;
            }
        }
    }
}