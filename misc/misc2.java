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

// Pow(x, n)
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
double myPow(double base, int p) {
        long power = p;

        if (power < 0) {
            base = 1 / base;
            power = -power;
        }

        double res = 1d;
        while (power > 0) {
            if ((power % 2) != 0) {
                power -= 1;
                res *= base;
            } else {
                power /= 2;
                base *= base;
            }
        }
        return res;
 }

 // Contiguous array
 // Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 int findMaxLength(int[] nums) {
        int ans = 0;
        int sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i] == 1 ? 1: -1;
            if(sum == 0){
                ans = Math.max(ans, i+1);
            }
            else{
                if(map.containsKey(sum)){
                    ans = Math.max(ans, i-map.get(sum));
                }
                else{
                    map.put(sum, i);
                }
            }
        }        
        return ans;
}


// Longest Palindrome
/**
    You are given an unordered array of unique integers incrementing from. 
    You can swap any two elements a limited number of times. 
    Determine the largest lexicographical value array that can be created by
     executing no more than the limited number of swaps.

     5 1         n = 5, k = 1
     4 2 3 5 1   arr = [4, 2, 3, 5, 1]

     output - > 5 2 3 4 1
 */
List<Integer> largestPermutation(int k, List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();

        // Store val and index in map
        for(int i=0; i<arr.size(); i++){
            map.put(arr.get(i), i);
        }
        
        List<Integer> temp = new ArrayList<>(arr);
        Collections.sort(temp, (a,b) -> b-a);
        
        int i = 0; 
        while(i<arr.size() && k>0){
            if(temp.get(i)>arr.get(i)){

                // place max at the beginning
                int x = arr.get(i);
                arr.set(i, temp.get(i));
                arr.set(map.get(temp.get(i)), x);
                
                //update indexes map
                map.put(x, map.get(temp.get(i)));
                map.put(temp.get(i), i);
                
                k--;
            }
            i++;
        }
        return arr;
}



