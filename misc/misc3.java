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