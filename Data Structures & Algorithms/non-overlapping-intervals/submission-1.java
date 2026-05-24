class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> comp= (i1, i2) -> {
            return i1[0]-i2[0];
        };
        Arrays.sort(intervals, comp);
        Stack<int[]> st = new Stack<>();
        int count=0;
        int index=1;
        st.push(intervals[0]);
        while(index<intervals.length) {
            if (isOverlapping(st.peek(), intervals[index])) {
                count++;
                int[] prevInterval = st.peek();
                if (intervals[index][1]<prevInterval[1]) {
                    st.pop();
                    st.push(intervals[index]);
                }
            } else {
                st.push(intervals[index]);
            }
            index++;
        }
        return count;
    }
    private boolean isOverlapping(int[] i1, int[] i2) {
        int small[] = i1;
        int large[] = i2;
        if (small[0]>large[0]) {
            small=i2;
            large=i1;
        }
        return i1[1]>i2[0];
    }
}
