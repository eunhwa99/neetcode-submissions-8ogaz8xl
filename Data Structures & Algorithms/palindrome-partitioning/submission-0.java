 class Solution {
         List<List<String>> res = new ArrayList<>();
          
               public List<List<String>> partition(String s) {
                        backtrack(0, s, new ArrayList<>());
                                 return res;
                                      }
                                       
                                            void backtrack(int idx, String s, List<String> tmp) {
                                                     if (idx >= s.length()) {
                                                                  res.add(new ArrayList<>(tmp));
                                                                               return;
                                                                                        }
                                                                                         
                                                                                                  for (int i = idx; i < s.length(); i++) {
                                                                                                               String subStr = s.substring(idx, i + 1);
                                                                                                                            if (isPalindrome(subStr)) {
                                                                                                                                             tmp.add(subStr);
                                                                                                                                                              backtrack(i + 1, s, tmp);
                                                                                                                                                                               tmp.removeLast();
                                                                                                                                                                                            }
                                                                                                                                                                                                     }
                                                                                                                                                                                                      
                                                                                                                                                                                                           }
                                                                                                                                                                                                            
                                                                                                                                                                                                                 boolean isPalindrome(String s) {
                                                                                                                                                                                                                          if (s.isBlank()) return true;
                                                                                                                                                                                                                                   int l = 0;
                                                                                                                                                                                                                                            int r = s.length() - 1;
                                                                                                                                                                                                                                                     while (l < r) {
                                                                                                                                                                                                                                                                  if (s.charAt(l++) != s.charAt(r--)) return false;
                                                                                                                                                                                                                                                                           }
                                                                                                                                                                                                                                                                                    return true;
                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                          }

 
