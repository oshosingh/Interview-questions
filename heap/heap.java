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