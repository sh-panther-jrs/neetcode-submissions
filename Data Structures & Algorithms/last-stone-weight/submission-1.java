class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c =(a, b) -> {
            return b-a;
        };
       PriorityQueue<Integer> pq = new PriorityQueue(c);
       for(int stone: stones) {
        pq.offer(stone);
       }
       while(pq.size()>1) {
        int stone1 = pq.poll();
        int stone2 = pq.poll();
        if(stone1-stone2!=0) {
            pq.offer(Math.abs(stone1-stone2));
        }
       }
       if(pq.isEmpty()) {
        return 0;
       }
       return pq.poll();
    }
}
