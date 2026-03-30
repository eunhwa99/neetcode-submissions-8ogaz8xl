
class Solution {

  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    Map<Character, Integer> tStrMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      tStrMap.put(c, tStrMap.getOrDefault(c, 0) + 1);
    }

    int l = 0, r = 0;
    int minLen = 1000;
    String res = "";
    Map<Character, Integer> sStrMap = new HashMap<>();
    int formed = 0, need = tStrMap.size();
    while (r < s.length()) {
      char rightChar = s.charAt(r);
      sStrMap.put(rightChar, sStrMap.getOrDefault(rightChar, 0) + 1);
      if (tStrMap.containsKey(rightChar) && Objects.equals(sStrMap.get(rightChar),
          tStrMap.get(rightChar))) {
        formed++;
      }

      while (need == formed) {
        if (minLen > (r - l + 1)) {
          res = s.substring(l, r + 1);
          minLen = r - l + 1;
        }
        char leftChar = s.charAt(l);
        sStrMap.put(leftChar, sStrMap.get(leftChar) - 1);
        l++;
        if (tStrMap.containsKey(leftChar) && sStrMap.get(leftChar) < tStrMap.get(leftChar)) {
          formed--;
        }
      }

      r++;
    }
    return res;
  }
}
