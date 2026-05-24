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

class IntervalInfo {
    int time;
    boolean isStart;
    public IntervalInfo(int time, boolean s) {
        this.time=time;
        this.isStart=s;
    }
}
class Solution {

    public int minMeetingRooms(List<Interval> intervals) { 
        if (intervals.isEmpty()) {
            return 0;
        }
        Comparator<Interval> comp = (i1, i2) -> {
            return i1.start-i2.start;
        };

        Comparator<Interval> compend = (i1, i2) -> {
            return i1.end-i2.end;
        };
        Collections.sort(intervals, comp);
        PriorityQueue<Interval> pq = new PriorityQueue<>(compend);
        pq.offer(intervals.get(0));
        int maxMeeting=1;
        for(int index=1; index<intervals.size(); index++) {
            if (pq.isEmpty()) {
                pq.offer(intervals.get(index));
                maxMeeting = Math.max(maxMeeting, pq.size());
            } else {
                while(!pq.isEmpty() && pq.peek().end<=intervals.get(index).start) {
                    pq.poll();
                }
                pq.offer(intervals.get(index));
                 maxMeeting = Math.max(maxMeeting, pq.size());
            }
        }
        return maxMeeting;
    }

    // public int minMeetingRooms(List<Interval> intervals) {
    //     if (intervals.isEmpty()) {
    //         return 0;
    //     }
    //     Comparator<IntervalInfo> comp = (i1, i2) -> {
    //         if (i1.time==i2.time) {
    //             if (i1.isStart) {
    //                 return 1;
    //             } else {
    //                 return -1;
    //             }
    //         }
    //         return i1.time-i2.time;
    //     };
    //     List<IntervalInfo> intervalInfos = getInterval(intervals);
    //     Collections.sort(intervalInfos, comp);
    //     int minMeetingRoom = 1;
    //     int maxMeetingRoom = 1;
    //     boolean prevOverlapping = false;
    //     int index=1;
    //     while(index<intervalInfos.size()) {
    //         if(intervalInfos.get(index).isStart) {
    //             minMeetingRoom++;
    //             maxMeetingRoom = Math.max(maxMeetingRoom, minMeetingRoom);
    //         }
    //         else {
    //             minMeetingRoom--;
                 
    //         }
    //         index++;
    //     }
    //     return maxMeetingRoom;
    // }

    List<IntervalInfo> getInterval(List<Interval> intervals) {
        List<IntervalInfo> intervalInfos = new ArrayList<>();
        for(Interval interval: intervals) {
            IntervalInfo iStart = new IntervalInfo(interval.start, true);
            IntervalInfo iEnd = new IntervalInfo(interval.end, false);
            intervalInfos.add(iStart);
            intervalInfos.add(iEnd);
        }
        return intervalInfos;
    }


}
