class Solution {
        public int maxProfit(int[] prices) {
                int n = prices.length;
                        if (n == 1) return 0;
                                
                                        int[][] dp = new int[n][2];
                                                dp[0][1] = Integer.MIN_VALUE / 2;
                                                        dp[1][1] = -prices[0];
                                                                
                                                                        for (int i = 2; i < n; i++) {
                                                                                    dp[i][0] = Math.max(dp[i-1][1] + prices[i-1], dp[i-1][0]);
                                                                                                dp[i][1] = Math.max(dp[i-1][1], (i >= 3 ? dp[i-2][0] : 0) - prices[i-1]);
                                                                                                        }
                                                                                                                
                                                                                                                        // 마지막 날 sell 반영
                                                                                                                                int last = dp[n-1][1] + prices[n-1];
                                                                                                                                        return Math.max(dp[n-1][0], last);
                                                                                                                                            }
                                                                                                                                            }

