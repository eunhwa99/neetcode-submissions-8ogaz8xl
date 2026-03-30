class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Pair> stk = new Stack<>();
    int res = 0;
    for(int i=0;i<heights.length;i++){
      int index = i;
      while(!stk.empty() && stk.peek().height >= heights[i]){
        Pair top = stk.pop();
        res = Math.max(res, (i-top.index) * top.height);
        index = top.index;
      }
      stk.push(new Pair(index, heights[i]));

    }

    int pre = heights.length - 1;
    while(!stk.empty()){
      Pair top = stk.pop();
      res = Math.max(res, (heights.length - top.index) * top.height);
    }
    return res;
  }
}

class Pair{
  int index;
  int height;
  public Pair(int index, int height){
    this.index = index;
    this.height = height;
  }
}
