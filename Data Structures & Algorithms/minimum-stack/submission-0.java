class MinStack {
        Stack<Integer> stk;
            Stack<Integer> minStk;
                public MinStack() {
                        stk = new Stack<>();
                                minStk = new Stack<>();
                                    }

                                        public void push(int val) {
                                                stk.push(val);
                                                        if(minStk.isEmpty() || minStk.peek()>=val) minStk.push(val);
                                                            }

                                                                public void pop() {
                                                                        if (stk.isEmpty()) return;
                                                                                if(Objects.equals(minStk.peek(), stk.pop()))  minStk.pop();
                                                                                    }

                                                                                        public int top() {
                                                                                                return stk.peek();
                                                                                                    }

                                                                                                        public int getMin() {
                                                                                                                return minStk.peek();
                                                                                                                    }
                                                                                                                    }

