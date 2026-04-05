class Solution {
  public void solve(char[][] board) {
    int[][] group = new int[board.length][board[0].length];
    Map<Integer, Boolean> map = new HashMap<>();
    int groupNum = 0;
    Queue<int[]> que = new LinkedList<>();
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]=='O' && group[i][j]==0){
          group[i][j]=++groupNum;
          que.offer(new int[]{i,j});
          bfs(group, que, groupNum, map, board);
        }
      }
    }
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]=='O' && map.get(group[i][j])) board[i][j]='X';
      }
    }
  }

  void bfs(int[][] group, Queue<int[]> que, int groupNum, Map<Integer, Boolean> map, char[][] board){

    int[] dr = new int[]{1,0,-1,0};
    int[] dc = new int[]{0,1,0,-1};
    map.put(groupNum, true);
    while(!que.isEmpty()){
      int[] top = que.poll();
      int cr = top[0];
      int cc = top[1];
      if(cr == 0 || cc == 0 || cr == group.length-1 || cc == group[0].length-1) map.put(groupNum, false);

      for(int d=0;d<4;d++){
        int nr = cr + dr[d];
        int nc = cc + dc[d];

        if(nr<0||nr>=group.length||nc<0||nc>=group[0].length||group[nr][nc]!=0 || board[nr][nc]=='X') continue;
        que.offer(new int[]{nr,nc});
        group[nr][nc] = groupNum;

      }
    }
  }
}

