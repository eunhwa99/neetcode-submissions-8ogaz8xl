class Solution {

  public int evalRPN(String[] tokens) {
    Stack<Integer> stk = new Stack<>();

    for (String token : tokens) {
      if (Objects.equals(token, "+") || Objects.equals(token, "-") || Objects.equals(token, "*")
          || Objects.equals(token, "/")) {
        int n1 = stk.pop();
        int n2 = stk.pop();
        if (token.equals("+")) {
          stk.push(n1 + n2);
        } else if (token.equals("*")) {
          stk.push(n1 * n2);
        } else if (token.equals("/")) {
          stk.push(n2 / n1);
        } else {
          stk.push(n2 - n1);
        }
      } else {
        stk.push(Integer.parseInt(token));
      }
    }
    return stk.pop();
  }
}
