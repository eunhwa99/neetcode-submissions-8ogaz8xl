class Solution {

public String encode(List<String> strs) {
              StringBuilder stringBuilder = new StringBuilder();
                       for (String str : strs) {
                                    stringBuilder.append(str.length()).append("#").append(str);
                                             }
                                                      return stringBuilder.toString();
                                                           }
 public List<String> decode(String str) {
          List<String> result = new ArrayList<>();
               int idx = 0;
                    while (idx < str.length()) {
                             int start = idx;
                                      while (str.charAt(idx) != '#') {
                                                   idx++;
                                                            }
                                                             
                                                                      int size = Integer.parseInt(str.substring(start,idx));
                                                                               idx++;
                                                                                        result.add(str.substring(idx, idx + size));
                                                                                                 idx += size;
                                                                                                      }
                                                                                                           return result;
                                                                                                            }

 
}
