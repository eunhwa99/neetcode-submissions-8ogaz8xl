class Solution {

  public List<String> findWords(char[][] board, String[] words) {
    List<String> ans = new ArrayList<>();

    for (String s : words) {
      boolean search = false;
      for (int i = 0; i < board.length && !search; i++) {
        for (int j = 0; j < board[0].length && !search; j++) {
          if (s.charAt(0) == board[i][j]) {
            if (find(s, 0, i, j, board)) {
              ans.add(s);
              search = true;
            }
          }
        }
      }
    }
    return ans;
  }

  boolean find(String word, int idx, int r, int c, char[][] board) {
    if (idx == word.length()) return true;
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
    if (board[r][c] != word.charAt(idx)) return false;

    char tmp = board[r][c];
    board[r][c] = '#';

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    for (int d = 0; d < 4; d++) {
      if (find(word, idx + 1, r + dr[d], c + dc[d], board)) {
        board[r][c] = tmp;
        return true;
      }
    }

    board[r][c] = tmp;
    return false;
  }
}