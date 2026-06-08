class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> c = (a, b) -> {
            
            return Double.compare(getDistanceFromOrigin(b),getDistanceFromOrigin(a));
        };
       PriorityQueue<int[]> pq = new PriorityQueue(c);
       for(int[] p:points) {
        pq.offer(p);
        if(pq.size()>k) {
            pq.poll();
        }
       }
        int output[][]= new int[pq.size()][2];
        int count=0;
        while(!pq.isEmpty()) {
            output[count] = pq.poll();
            count++;
        }
        return output;
    }

    private double getDistanceFromOrigin(int[] point) {
        return Math.sqrt((point[0]*point[0]) + (point[1]*point[1]));
    }
}
