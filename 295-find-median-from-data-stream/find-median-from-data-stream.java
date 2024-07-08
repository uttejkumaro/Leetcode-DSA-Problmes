class MedianFinder {

    // Max-heap to store the lower half of the numbers
    private PriorityQueue<Integer> lowerHalf;
    // Min-heap to store the upper half of the numbers
    private PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add the number to the appropriate heap
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.add(num);
        } else {
            upperHalf.add(num);
        }

        // Balance the heaps if necessary
        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.add(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.add(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            // If the heaps are of the same size, the median is the average of the roots of both heaps
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        } else {
            // If the heaps are of different sizes, the median is the root of the larger heap
            return lowerHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
