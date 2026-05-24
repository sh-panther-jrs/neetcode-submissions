class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> c = (a ,b) -> { return a[0]-b[0];};
        Arrays.sort(intervals, c);
        Stack<int[]> output=new Stack<>();
        output.push(intervals[0]);
        for (int i=1; i<intervals.length; i++) {
            if(isOverlap(output.peek(), intervals[i])) {
                output.push(mergeIntervals(output.pop(), intervals[i]));
            } else {
                output.push(intervals[i]);
            }
        }
        int[][] outputArr = new int[output.size()][2];
        int index=0;
        for(int[] interval: output) {
            outputArr[index] = interval;
            index++;
        }
        return outputArr;
    }

    private int[] mergeIntervals(int[]i1, int i2[]) {
        int endTime = Math.max(i1[1], i2[1]);
        return new int[] {i1[0], endTime};
    }

    private boolean isOverlap(int[] i1, int[] i2) {
        return i1[1]>=i2[0];
    }



}
