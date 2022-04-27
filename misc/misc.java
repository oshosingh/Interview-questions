// Find First and Last Position of Element in Sorted Array
int[] searchRange(int[] a, int target) {
        if(a.length == 0){
            return new int[]{-1, -1};
        }
        
        int ans[] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        return solve(a, 0, a.length-1, target, ans);
}
    
int[] solve(int[] a, int l, int r, int target, int[] ans){
        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]<target){
                l = mid+1;
            }
            else if(a[mid]>target){
                r = mid-1;
            }
            else{
                int[] left = solve(a,l,mid-1,target,ans);
                int[] right = solve(a,mid+1,r,target,ans);
                
                ans[0] = left[0]==-1 ? Math.min(mid, ans[0]) : Math.min(ans[0], left[0]);
                ans[1] = right[1]==-1 ? Math.max(mid, ans[1]) : Math.max(ans[1], right[1]);
                return ans;
            }
        }
        
        return new int[]{-1,-1};
}


// Path sum 2
/***
    Given the root of a binary tree and an integer targetSum, 
    return all root-to-leaf paths where the sum of the node values
     in the path equals targetSum. Each path should be returned as a list
      of the node values, not node references.

    A root-to-leaf path is a path starting from the root and ending at any leaf node.
    A leaf is a node with no children
 */

List<List<Integer>> paths = new ArrayList<>();
    
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return paths;
        
        dfs(root, targetSum, new ArrayList<>());
        
        return paths;
}
    
void dfs(TreeNode node, int targetSum, ArrayList<Integer> path) {
        
        // 1- Check specific case
        if(node == null)
            return;
        
        // 2- Prosses a cell
            path.add(node.val);
            targetSum -= node.val;
        
        // target sum == 0 and check if node is leaf
        if(targetSum == 0 && node.left == null && node.right == null)
            paths.add(path);
        
        
        // 3- Call dfs as many times as nedded
        dfs(node.left, targetSum, new ArrayList<>(path));
        dfs(node.right, targetSum, new ArrayList<>(path));
}

// Shortest Unsorted Continuous Subarray
/**Given an integer array nums, you need to find one continuous subarray that
 if you only sort this subarray in ascending order, then the whole array will
  be sorted in ascending order.
 Return the shortest such subarray and output its length. 
*/
int findUnsortedSubarray(int[] nums) {
        int start = nums.length; int end = 0;
        int[] snums = nums.clone();
        Arrays.sort(snums);
        
        for(int i=0; i<nums.length; i++){
            if(snums[i] != nums[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        
        return end-start>0? end-start+1 : 0;
}

// Longest Substring Without Repeating Characters
/**
    Given a string s, find the length of the longest substring without repeating characters.
*/

int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int n = s.length();
        
        if(s.equals("")){
            return 0;
        }
        
        if(s.equals(" ")){
            return 1;
        }
        
        if(s.length()==1){
            return 1;
        }
        
        Set<Character> set = new HashSet<>();
        boolean flag = true;
        
        while(end<n){
            flag = true;
            if(set.contains(s.charAt(end))){
                ans = Math.max(ans, end-start);
                
                while(s.charAt(start) != s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;
                    flag = false;
                }
                
                start++;
            }
            else{
                set.add(s.charAt(end));
            }
            end++;
        }
        
        if(flag){
            ans = Math.max(ans, end-start);
        }
        
        return ans == Integer.MIN_VALUE ? 0 : ans;
}