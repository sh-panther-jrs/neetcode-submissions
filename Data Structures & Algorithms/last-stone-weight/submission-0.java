class Solution {

    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a, b) -> {
            return b-a;
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(c)    ;
        for (int stone: stones) {
            pq.offer(stone);
        }
        while(!pq.isEmpty()) {
            if (pq.size()==1) {
                return pq.poll();
            }
            int x = pq.poll();
            int y = pq.poll();
            if (x==y) {
                continue;
            }
            pq.offer(Math.abs(x-y));
        }
        return 0;
    }
}
