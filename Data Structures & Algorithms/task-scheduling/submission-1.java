 class Solution {
     public int leastInterval(char[] tasks, int n) {
         // 1. 빈도수 계산
         int[] freq = new int[26];
         for (char task : tasks) {
             freq[task - 'A']++;
         }
 
         // 2. 최대 빈도수 찾기
         int maxFreq = 0;
         for (int f : freq) {
             maxFreq = Math.max(maxFreq, f);
         }
 
         // 3. 최대 빈도수를 가지는 작업의 개수 찾기
         int countMaxFreq = 0;
         for (int f : freq) {
             if (f == maxFreq) {
                 countMaxFreq++;
             }
         }
 
         // 4. 최소 시간 계산 공식
         // (최대 빈도수 - 1) * (쿨다운 + 1) + 최대 빈도수 작업의 개수
         int partCount = maxFreq - 1;
         int partLength = n + 1;
         int minTotalTime = partCount * partLength + countMaxFreq;
 
         // 5. 작업의 총 개수보다 작을 수 없으므로 둘 중 큰 값 반환
         return Math.max(tasks.length, minTotalTime);
     }
 }
