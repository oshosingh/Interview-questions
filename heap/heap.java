// Find Subsequence of Length K With the Largest Sum
int[] maxSubsequence(int[] nums, int k) {

    // Max Heap, max value at top
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(b.get(0),a.get(0))
    );
        
    for(int i=0; i<nums.length; i++){
        pq.add(Arrays.asList(nums[i], i));
    }
        
    // Min heap with max K elements from previous queue, sorted by index to maintain subsequence element order
    PriorityQueue<List<Integer>> q = new PriorityQueue<>((a,b) -> Integer.compare(a.get(1), b.get(1)));
    while(q.size()<k){
        q.add(pq.poll());
    }
        
    int[] ans = new int[k]; int i=0;
    while(!q.isEmpty()){
        ans[i++] = q.poll().get(0);
    }
    return ans;
}

// Largest Number After Digit Swaps by Parity
/**
    You are given a positive integer num. You may swap any two digits of num that have
    the same parity (i.e. both odd digits or both even digits).
    Return the largest possible value of num after any number of swaps.
 */

 int largestInteger(int num) {

    // Max heap to store num's single digit integer
    PriorityQueue<Integer> even = new PriorityQueue<>();
    PriorityQueue<Integer> odd = new PriorityQueue<>();
        
    int temp = num;
    String ans = "";
        
    while(num!=0){
        int x = num%10;
        if(x%2==1){
                odd.add(x);
        }
        else{
                even.add(x);
        }
        num/=10;
    }
    
    // Loop over single digits and take values from heap based on parity
    while(temp!=0){
        int x = temp%10;
        if(x%2==1){
            ans = String.valueOf(odd.poll())+ans;
        }
        else{
            ans = String.valueOf(even.poll())+ans;
        }
        temp /= 10;
    }
        
    return Integer.parseInt(ans);
}