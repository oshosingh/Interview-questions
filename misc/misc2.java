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


// Integer to Roman (Time complexity to find greatest val<=num is O(logn)) 
//                   because treeset is a tree structure
String intToRoman(int num) {
        if(num == 0){
            return "";
        }
        
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I"); map.put(5, "V"); map.put(10, "X");
        map.put(50, "L"); map.put(100, "C"); map.put(500, "D");
        map.put(1000, "M");
        
        //exceptions
        map.put(4, "IV"); map.put(9, "IX"); map.put(40, "XL"); map.put(90, "XC");
        map.put(400, "CD"); map.put(900, "CM");
        
        TreeSet<Integer> set = new TreeSet<>();
        for(Integer key : map.keySet()){
            set.add(key);
        }
        
        int val = set.floor(num);
        
        String ans = "";
        ans = map.get(val) + intToRoman(num-val);
        return ans;
    }
}