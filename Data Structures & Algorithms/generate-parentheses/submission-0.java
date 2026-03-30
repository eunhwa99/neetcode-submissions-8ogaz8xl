class Solution {
        List<String> res;

            public List<String> generateParenthesis(int n) {
                    res = new ArrayList<>();
                            backtrack(n, n, new StringBuilder());
                                    return res;
                                        }

                                            void backtrack(int open, int close, StringBuilder tmp) {
                                                    if (open > close || open < 0 || close < 0) return;
                                                            if (open == 0 && close == 0) {
                                                                        res.add(tmp.toString());
                                                                                    return;
                                                                                            }

                                                                                                        tmp.append("(");
                                                                                                                backtrack(open - 1, close, tmp);
                                                                                                                        tmp.deleteCharAt(tmp.length() - 1);
                                                                                                                                tmp.append(")");
                                                                                                                                        backtrack(open, close - 1, tmp);
                                                                                                                                                tmp.deleteCharAt(tmp.length() - 1);
                                                                                                                                                    }
                                                                                                                                                    }
