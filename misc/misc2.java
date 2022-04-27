// Maximum Product subarray
/**
    Given an integer array nums, 
    find a contiguous non-empty subarray within the array that has the largest product, and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.

    A subarray is a contiguous subsequence of the array.
 */

 /**
    Algorithm
    Include nums[i] in solution till (i-1), start from nums[i]
     -> max = Math.max(nums[i], Math.max(x,y));  first part is start from i, second is include in i-1
  */
int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        //find max. min at every index and res will store max till i
        for(int i=1; i<nums.length; i++){
            int x = max*nums[i];
            int y = min*nums[i];
            
            max = Math.max(nums[i], Math.max(x, y));
            min = Math.min(nums[i], Math.min(x, y));
            
            res = Math.max(res, max);
        }
        
        return res;
}