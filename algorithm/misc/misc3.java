class LRUCache {
    LinkedHashMap<Integer, Integer> map; //doubly linked list
    int capacity;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        int value = map.get(key);
        
        // remove key
        map.remove(key);
        
        //add again making it new or recently used, insert in last (latest)
        map.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        map.put(key, value);
        if(map.size()>capacity){
            Integer c = map.keySet().iterator().next();
            map.remove(c);
        }
    }
}

// Rotate Array
void rotate(int[] a, int k) {
        k = k%a.length;
        reverse(a, 0, a.length-1);
        reverse(a, 0, k-1);
        reverse(a, k, a.length-1);
}
    
void reverse(int[] a, int s, int e){
    while(s<e){
        int temp = a[s];
        a[s] = a[e];
        a[e] = temp;
        s++;
        e--;
    }
}

// Tower of Hanoi
void towerOfHanoi(int n, char from_rod,
                    char to_rod, char aux_rod)
{
    if (n == 0)
    {
        return;
    }
    towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
    System.out.println("Move disk "+ n + " from rod " +
                       from_rod +" to rod " + to_rod );
    towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
}

// Sieve of eratosthenes (Count primes)
// Count prime below n
int countPrimes(int n) {
        
    if(n<=1) return 0;

    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);

    int ans = 0;
    int y = 2;

    while(y<n){
        if(primes[y]){
            mark(primes, y);
            ans++;
        }
        y++;
    }

    return ans;
}
    
void mark(boolean[] primes, int y){
    for(int i=y*2; i<primes.length; i+=y){
        primes[i] = false;
    }
}

// Search in rotated subarray
public boolean search(int[] nums, int target) {
        int pivot = pivot(nums, 0, nums.length-1);
        if(nums[nums.length-1]>target){
            return search(nums, pivot, nums.length-1, target);
        }
        return search(nums, 0, pivot-1, target);
}

/**
The input contain many duplicates
Binary search will not be able to find pivot
Worst case complexity when duplicates will be O(n)
if no duplicates by binary search can be done in O(nlogn)
 */ 
    
boolean search(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target) high=mid-1;
            else low = mid+1;
        }
        return false;
}
    
int pivot(int[] nums, int low, int high){
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
}