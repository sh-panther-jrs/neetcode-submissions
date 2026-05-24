/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Comparator<Interval> comp = (i1, i2) -> {
            return i1.start-i2.start;
        };
        Collections.sort(intervals, comp);
        int index=1;
        while(index<intervals.size()) {
            if(isOverlapping(intervals.get(index-1), intervals.get(index))) {
                return false;
            }
            index++;
        }
        return true;
    }
    private boolean isOverlapping(Interval i1, Interval i2) {
        return i1.end>i2.start;
    }
}
