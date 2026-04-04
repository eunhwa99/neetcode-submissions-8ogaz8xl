class Solution {
  List<String> res = new ArrayList<>();
  private String[] digitToChar = {
      "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
  };

  public List<String> letterCombinations(String digits) {
    if(digits.isBlank()) return res;
    backtrack(digits.toCharArray(), 0, new StringBuilder());
    return res;
  }

  void backtrack(char[] digits, int index, StringBuilder tmp) {
    if (index >= digits.length) {
      res.add(tmp.toString());
      return;
    }

    int cur = digits[index] - '0';
    char[] letters = digitToChar[cur].toCharArray();
    for (int i = 0; i < letters.length; i++) {
      tmp.append(letters[i]);
      backtrack(digits, index + 1, tmp);
      tmp.deleteCharAt(tmp.length() - 1);
    }
  }
}