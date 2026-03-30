class Solution {

  static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
  }

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = new TrieNode();

    // Trie 삽입
    for (String w : words) {
      TrieNode cur = root;
      for (char c : w.toCharArray()) {
        int idx = c - 'a';
        if (cur.children[idx] == null) {
          cur.children[idx] = new TrieNode();
        }
        cur = cur.children[idx];
      }
      cur.word = w;
    }

    List<String> ans = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, ans);
      }
    }
    return ans;
  }

  void dfs(char[][] board, int r, int c, TrieNode node, List<String> ans) {
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
    char ch = board[r][c];
    if (ch == '#') return;

    TrieNode next = node.children[ch - 'a'];
    if (next == null) return;

    if (next.word != null) {
      ans.add(next.word);
      next.word = null; // 중복 방지
    }

    board[r][c] = '#';
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    for (int d = 0; d < 4; d++) {
      dfs(board, r + dr[d], c + dc[d], next, ans);
    }
    board[r][c] = ch;
  }
}