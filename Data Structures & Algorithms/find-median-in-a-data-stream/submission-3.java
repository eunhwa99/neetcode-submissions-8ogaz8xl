class MedianFinder {
    PriorityQueue<Integer> maxHeap; // 왼쪽 (작은 값들 중 최대)
    PriorityQueue<Integer> minHeap; // 오른쪽 (큰 값들 중 최소)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. 일단 maxHeap에 넣습니다.
        maxHeap.offer(num);

        // 2. 균형을 위해 maxHeap에서 가장 큰 값을 minHeap으로 옮깁니다.
        minHeap.offer(maxHeap.poll());

        // 3. 만약 minHeap의 크기가 더 커졌다면, 다시 maxHeap으로 하나 옮겨서
        // 항상 maxHeap의 크기가 minHeap과 같거나 1개 더 많도록 유지합니다.
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            // maxHeap.peek()과 minHeap.peek()이 null이 아닌지 확인 필요 (데이터가 있을 때 호출 가정)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}