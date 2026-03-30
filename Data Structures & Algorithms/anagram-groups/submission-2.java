class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        int[] charInt = new int[26];

        for(String str: strs){
            char[] chars = str.toCharArray();
            for(char character:chars){
                charInt[character-'a']++;
            }
            String key="";
            for(int i=0;i<26;i++){
                key+=charInt[i]+"_";
                charInt[i]=0;
            }
            strMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    
        }
          return new ArrayList<>(strMap.values());
    }
}
