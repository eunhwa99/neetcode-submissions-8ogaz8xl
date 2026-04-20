 class Solution {
         public int[] countBits(int n) {
                  int[] res = new int[n + 1];
                           int next = 0;
                                    for (int i = 1; i <= n; i++) {
                                                 if (i == (1 << next)) {
                                                                  res[i] = 1;
                                                                                   next++;
                                                                                                } else {
                                                                                                                 res[i] = res[i / 2] + (i % 2 == 0 ? 0 : 1);
                                                                                                                              }
                                                                                                                                       }
                                                                                                                                                return res;
                                                                                                                                                     }
                                                                                                                                                      }

 
