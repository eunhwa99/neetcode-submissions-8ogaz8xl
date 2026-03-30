class MedianFinder {

  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;

  public MedianFinder() {
    maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {

    minHeap.offer(num);

    int minSize = minHeap.size();
    int maxSize = maxHeap.size();
    if (minSize - maxSize > 1) {
      maxHeap.offer(minHeap.poll());
    }
    if(!maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
      int tmp = maxHeap.poll();
      maxHeap.offer(minHeap.poll());
      minHeap.offer(tmp);
    }

  }

  public double findMedian() {
    int minSize = minHeap.size();
    int maxSize = maxHeap.size();
    if (minSize == maxSize) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return minHeap.peek();
    }
  }
}
