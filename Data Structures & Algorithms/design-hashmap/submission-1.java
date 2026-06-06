class Node {
    int bit;
    int value;
    public Node() {
        bit=0;
        value=0;
    }
}
class Slot {
    Node[] bitSlot;
    public Slot() {
        bitSlot = new Node[32];
        for(int i=0; i<32;i++) {
            bitSlot[i] = new Node();
        }
    }
    public void unsetBit(int posWithinSlot) {
        bitSlot[posWithinSlot] = new Node();
    }
    public void setBit(int posWithinSlot, int value) {
        bitSlot[posWithinSlot].bit=1;
        bitSlot[posWithinSlot].value=value;
    }
    public int getValueWithinSlot(int posWithinSlot) {
        if(bitSlot[posWithinSlot].bit!=0) {
            return bitSlot[posWithinSlot].value;
        }
        return -1;
    }

}
class MyHashMap {
    Slot[] n;
    public MyHashMap() {
        n=new Slot[32252];
        for(int i=0;i<n.length;i++) {
            n[i] = new Slot();
        }
    }
    
    public void put(int key, int value) {
        Slot s = getSlot(key/32);
        s.setBit(key%32, value);
    }
    
    public int get(int key) {
        Slot s = getSlot(key/32);
        return s.getValueWithinSlot(key%32);
    }
    
    public void remove(int key) {
         Slot s = getSlot(key/32);
         s.unsetBit(key%32);
    }

    private Slot getSlot(int pos) {
        return n[pos];
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */