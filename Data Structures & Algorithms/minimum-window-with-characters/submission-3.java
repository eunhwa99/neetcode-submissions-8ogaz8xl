 class Solution {
    public String minWindow(String s, String t) {
      if (s.length() < t.length()) return "";

      int[] need = new int[128];
      for (char c : t.toCharArray()) need[c]++;

      int left = 0;
      int required = t.length(); // 아직 맞춰야 하는 총 문자 수
      int minLen = Integer.MAX_VALUE;
      int start = 0;

      for (int right = 0; right < s.length(); right++) {
        char rc = s.charAt(right);

        if (need[rc] > 0) required--;
        need[rc]--;

        while (required == 0) {
          if (right - left + 1 < minLen) {
            minLen = right - left + 1;
            start = left;
          }

          char lc = s.charAt(left);
          need[lc]++;
          if (need[lc] > 0) required++;
          left++;
        }
      }

      return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
  }