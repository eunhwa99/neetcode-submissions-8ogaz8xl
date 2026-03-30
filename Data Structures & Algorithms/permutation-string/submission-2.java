class Solution {
      public boolean checkInclusion(String s1, String s2) {
          int m = s1.length(), n = s2.length();
          if (n < m) return false;

          int[] s1Count = new int[26];
          int[] winCount = new int[26];

          for (int i = 0; i < m; i++) {
              s1Count[s1.charAt(i) - 'a']++;
              winCount[s2.charAt(i) - 'a']++;
          }

          int matches = 0;
          for (int i = 0; i < 26; i++) {
              if (s1Count[i] == winCount[i]) matches++;
          }
          if (matches == 26) return true;

          for (int r = m; r < n; r++) {
              int in = s2.charAt(r) - 'a';
              int out = s2.charAt(r - m) - 'a';

              winCount[in]++;
              if (winCount[in] == s1Count[in]) matches++;
              else if (winCount[in] - 1 == s1Count[in]) matches--;

              winCount[out]--;
              if (winCount[out] == s1Count[out]) matches++;
              else if (winCount[out] + 1 == s1Count[out]) matches--;

              if (matches == 26) return true;
          }
          return false;
      }
}
  
