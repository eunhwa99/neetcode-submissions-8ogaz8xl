class Solution {
      public boolean isValidSudoku(char[][] board) {
          return backtrackRow(board, 0)
              && backtrackCol(board, 0)
              && backtrackBox(board, 0);
      }

      private boolean backtrackRow(char[][] board, int row) {
          if (row >= 9) return true;

          boolean[] visited = new boolean[9];
          for (int col = 0; col < 9; col++) {
              char ch = board[row][col];
              if (ch == '.') continue;

              int num = ch - '1';
              if (visited[num]) return false;
              visited[num] = true;
          }

          return backtrackRow(board, row + 1);
      }

      private boolean backtrackCol(char[][] board, int col) {
          if (col >= 9) return true;

          boolean[] visited = new boolean[9];
          for (int row = 0; row < 9; row++) {
              char ch = board[row][col];
              if (ch == '.') continue;

              int num = ch - '1';
              if (visited[num]) return false;
              visited[num] = true;
          }

          return backtrackCol(board, col + 1);
      }

      private boolean backtrackBox(char[][] board, int box) {
          if (box >= 9) return true;

          boolean[] visited = new boolean[9];
          int startRow = (box / 3) * 3;
          int startCol = (box % 3) * 3;

          for (int r = startRow; r < startRow + 3; r++) {
              for (int c = startCol; c < startCol + 3; c++) {
                  char ch = board[r][c];
                  if (ch == '.') continue;

                  int num = ch - '1';
                  if (visited[num]) return false;
                  visited[num] = true;
              }
          }

          return backtrackBox(board, box + 1);
      }
  }
