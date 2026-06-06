class MyHashSet {
    int bit[];
    public MyHashSet() {
        bit=new int[32*31251];
    }
    
    public void add(int key) {
        bit[key/32] = bit[key/32]|(1<<(key%32)); 
    }
    
    public void remove(int key) {
        if(contains(key)) {
            bit[key/32] = bit[key/32] & (~(1<<(key%32))); 
        }    
    }
    
    public boolean contains(int key) {
        return (bit[key/32] & (1<<(key%32)))!=0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */