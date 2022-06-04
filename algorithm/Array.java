1. Given an integer array, find the largest subarray formed by consecutive integers. The subarray should contain all distinct values.
   { 2, 0, 2, 1, 4, 3, 1, 0 }

   Ans- { 0, 2, 1, 4, 3 }

Void findMaxSubArray(int[] a){
	int len=0;
	int start=0, end=0;
	
	for(int i=0; i<n-1; i++){
		// i here denotes start of subarray
		int minVal = a[i], maxVal=a[i];
		
		for(int j=i+1; j<n; j++){
			minVal = Math.min(minVal, a[j]);
			maxVal = Math.max(maxVal, a[j]);
			
		//check if A[i..j] is formed by consecutive integers
			if(isConsecutive(a,i,j,min,max){
				if(len<maxVal-minVal+1){
					Len = maxVal-minVal+1;
					Start = i; end = j;
				}
			}
		}
	}
}

Boolean isConsecutive(int[] a, int i, int j, int min, int max){
	// if elements are less in number
	if(max-min != j-i) return false;
	
	Set<Integer> set = new HashSet<>();

    // Check if duplicates are in the range
	for(int k=i; k<=j; k++){
		if(set.contains(a[k]) return false;
		set.add(a[k]);
	}
		return true;
}


2. Given an integer array, find the maximum length subarray having a given sum.

nums[] = { 5, 6, -5, 5, 3, 5, 3, -2, 0 }
target = 8

int maxLengthSubarray(int[] a, int n, int target){
	Map<Integer, Integer> map = new HashMap<>();
	map.put(0, -1);

	int sum = 0;
	int len = 0;
	int endingIndex = -1;
	
	for(int i=0; i<n; i++){
		Sum += a[i];
		map.putIfAbsent(sum, i);

		if(map.containsKey(sum-target) && len<i-map.get(sum-target)){
			Len = i-map.get(sum-target);
			endingIndex = i;
		}	

	}
	int startingIndex = endingIndex-len+1;
	return len;
}	

3. Merge Sorted Array in place (a has length m+n)

void merge(int[] a, int m, int[] b, int n) {
    if(n==0) return;
    int i=m-1, j=n-1, end=a.length-1;
        
    while(i>=0 && j>=0){
        a[end--] = (a[i]>=b[j]) ? a[i--] : b[j--];
    }
        
    while(i>=0) a[end--] = a[i--];
    while(j>=0) a[end--] = b[j--];
}

4. Find maximum product of two integers in an array

void maxProduct(int[] a){
    // find first max, second max, first min and second min in one traversal

    int max1 = a[0], max2 = Integer.MIN_VALUE:
    int min1 = a[0], min2 = Integer.MAX_VALUE;

    for(int i=0; i<a.length; i++){
        // if a[i] > max, update max1 and max2
		if(a[i]>max1){
			max2 = max1;
			max1 = a[i];
		}
		else if(a[i]>max2){
			max2 = a[i];
		}

		// if a[i]<min, update min1 and min2
		else if(a[i]<min1){
			min2 = min1;
			min1 = a[i];
		}

		else if(a[i]<min2){
			min2 = a[i];
		}
    }

	// answer is max of max1*max2 and min1*min2
	if(max1*max2 > min1*min2) System.out.println(max1+" "+max2);
	else System.out.println(min1+" "+min2);
}
