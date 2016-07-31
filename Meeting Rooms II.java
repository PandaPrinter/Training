Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.

For example, Given [[0, 30],[5, 10],[15, 20]],
return 2.


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        
        // min heap:
        if (intervals == null || intervals.length == 0) return 0;
        int len = intervals.length;
        PriorityQueue<Interval> minHeap = PriorityQueue<Interval>(len, new Comparator<Interval>() {
            public int comapre(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        int roomCount = 1;
        for (int i = 0; i < len; i++) {
            minHeap.offer(intervals[i]);
        }
        int end = minHeap.poll().end;
        
        for (int i = 1; i < len; i++) {
            Interval now = minHeap.poll();
            if (now.start < end) roomCount++;
            end = Math.max(now.end, end);
        }
        
        return roomCount;
        
        // array
        if (intervals == null || intervals.length == 0) return 0;
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for (int i = 0; i < len; i++) {
            if (starts[i] < ends[endsItr]) rooms++;
            else endsItr++;
        }
        return rooms;
    }
}