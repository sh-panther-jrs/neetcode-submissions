class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int indexToStartMerge = indexGreaterEquals(intervals, newInterval[0]);
        Stack<int[]> output = new Stack<>();
        int index =0;
        while (index<indexToStartMerge) {
            output.push(intervals[index]);
            index++;
        }
        if(output.isEmpty() || !isOverlapping(output.peek(), newInterval)) {
            output.push(newInterval);
        } else {
            output.push(getMergedInterval(output.pop(), newInterval));
        }
        while(index<intervals.length) {
            if (!isOverlapping(output.peek(), intervals[index])) {
                output.push(intervals[index]);
            } else {
                output.push(getMergedInterval(output.pop(), intervals[index]));
            }
            index++;
        }
        return getArrayFromStack(output);

    }

    private boolean isOverlapping(int i1[], int i2[]) {
        int small[] = i1;
        int large[] = i2;
        if (i1[0]>i2[0]) {
            small = i2;
            large = i1;
        }
        return small[1]>=large[0];

    }
    private int[][] getArrayFromStack(Stack<int[]> stack) {
        int output[][]= new int[stack.size()][2];
        int i=0;
        for (int[] st:stack) {
            output[i] = st;
            i++;
        }
        return output;
    }

    private int[] getMergedInterval(int i1[], int i2[]) {
        int[] output = new int[2];
        output[0] = Math.min(i1[0], i2[0]);
        output[1] = Math.max(i1[1], i2[1]);
        return output;
    }

    private int indexGreaterEquals(int[][]intervals, int start) {
        int startInd=0;
        int end = intervals.length-1;
        int leftValue=-1;
        while(startInd<=end) {
            int mid = startInd + (end-startInd)/2;
            if (intervals[mid][0]==start) {
                leftValue=mid;
                end= mid-1;
            } else if(intervals[mid][0]>start) {
                end = mid-1;
            } else {
                startInd=mid+1;
            }
        }
        return leftValue>0? leftValue: startInd;
    }
}
