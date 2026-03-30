
 class Solution {
     public int leastInterval(char[] tasks, int n) {
         if (n == 0) return tasks.length;
 
         // 1. 빈도수 계산
         int[] freq = new int[26];
         for (char t : tasks) freq[t - 'A']++;
 
         // 2. Max-Heap (빈도수가 높은 순서대로)
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
         for (int f : freq) {
             if (f > 0) pq.add(f);
         }
 
         int time = 0;
         while (!pq.isEmpty()) {
             List<Integer> temp = new ArrayList<>();
             int cycle = n + 1; // 한 사이클의 길이
             int taskCount = 0; // 이번 사이클에서 실제 실행한 작업 수
 
             // 한 사이클 동안 가능한 많은 작업을 수행
             for (int i = 0; i < cycle; i++) {
                 if (!pq.isEmpty()) {
                     temp.add(pq.poll());
                     taskCount++;
                 }
             }
 
             // 수행한 작업들의 빈도수를 줄이고 다시 리스트에 넣을 준비
             for (int f : temp) {
                 if (--f > 0) {
                     pq.add(f);
                 }
             }
 
             // 큐가 비어있으면 마지막 사이클이므로 실제 작업 수만큼만 더함
             // 큐가 남아있으면 쿨다운을 포함한 전체 사이클 시간을 더함
             time += pq.isEmpty() ? taskCount : cycle;
         }
 
         return time;
     }
 }