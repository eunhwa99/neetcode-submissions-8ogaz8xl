 class Solution {
     public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
         for (int st : stones) {
             pq.offer(st);
         }
 
         while (pq.size() > 1) {
             int first = pq.poll();
             int second = pq.poll();
 
             pq.offer(first - second);
         }
         return pq.isEmpty() ? 0 : pq.poll();
     }
 }
