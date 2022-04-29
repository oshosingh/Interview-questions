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
        
        //add again making it new or recently used
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