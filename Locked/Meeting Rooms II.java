/**
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
**/

public int minMeetingRooms(Interval[] intervals) {
	if (intervals == null || intervals.length == 0) return 0;
	Arrays.sort(intervals, new Comparator<Interval>() {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	});
	PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
		public int compare(Interval i1, Interval i2) {
			return i1.end - i2.end;
		}
	});
	pq.offer(intervals[0]);
	for (int i = 1; i < intervals.length; i++) {
		Interval cur = pq.poll();
		if (cur.end > intervals[i].start) {
			pq.offer(intervals[i]);
		}
		else {
			cur.end = intervals[i].end;
		}
		pq.offer(cur);
	}
	return pq.size();
}
