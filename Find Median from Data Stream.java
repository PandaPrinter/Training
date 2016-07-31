public class MedianFinder {
    
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        while (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        return (maxHeap.size() == minHeap.size()) ? ((maxHeap.peek() + minHeap.peek()) / 2.0) : maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();