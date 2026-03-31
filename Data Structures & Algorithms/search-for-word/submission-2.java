class Trie {
        Map<Character, Trie> children = new HashMap<>();
            String word = null;
            }

            class Solution {
                public boolean exist(char[][] board, String word) {
                        Trie root = new Trie();
                                Trie cur = root;

                                        // build trie
                                                for (char c : word.toCharArray()) {
                                                            cur.children.putIfAbsent(c, new Trie());
                                                                        cur = cur.children.get(c);
                                                                                }
                                                                                        cur.word = word;

                                                                                                for (int i = 0; i < board.length; i++) {
                                                                                                            for (int j = 0; j < board[0].length; j++) {
                                                                                                                            if (dfs(board, i, j, root)) return true;
                                                                                                                                        }
                                                                                                                                                }

                                                                                                                                                        return false;
                                                                                                                                                            }

                                                                                                                                                                private boolean dfs(char[][] board, int r, int c, Trie node) {
                                                                                                                                                                        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
                                                                                                                                                                                    return false;
                                                                                                                                                                                            }

                                                                                                                                                                                                    char ch = board[r][c];
                                                                                                                                                                                                            if (ch == '#') return false;

                                                                                                                                                                                                                    Trie next = node.children.get(ch);
                                                                                                                                                                                                                            if (next == null) return false;

                                                                                                                                                                                                                                    if (next.word != null) return true;

                                                                                                                                                                                                                                            board[r][c] = '#';

                                                                                                                                                                                                                                                    int[] dr = {1, 0, -1, 0};
                                                                                                                                                                                                                                                            int[] dc = {0, 1, 0, -1};

                                                                                                                                                                                                                                                                    for (int d = 0; d < 4; d++) {
                                                                                                                                                                                                                                                                                if (dfs(board, r + dr[d], c + dc[d], next)) {
                                                                                                                                                                                                                                                                                                board[r][c] = ch;
                                                                                                                                                                                                                                                                                                                return true;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                            board[r][c] = ch;
                                                                                                                                                                                                                                                                                                                                                    return false;
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                        }

