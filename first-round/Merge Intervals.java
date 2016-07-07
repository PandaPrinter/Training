/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution{
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }
        });
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval a = intervals.get(i);
            Interval b = intervals.get(i + 1);
            if (a.end >= b.start) {
                if (a.end < b.end) {
                    intervals.set(i, new Interval(a.start, b.end));
                }
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }
    
}