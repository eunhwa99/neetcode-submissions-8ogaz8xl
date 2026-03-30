class Pair {

  int index;
  int temp;

  public Pair(int index, int temp) {
    this.index = index;
    this.temp = temp;
  }
}

class Solution {

  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Pair> stk = new Stack<>();
    int[] res = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while (!stk.isEmpty() && (stk.peek().temp < temperatures[i])) {
        Pair top = stk.pop();
        res[top.index] = i - top.index;
      }

      stk.push(new Pair(i, temperatures[i]));
    }
    return res;
  }
}
