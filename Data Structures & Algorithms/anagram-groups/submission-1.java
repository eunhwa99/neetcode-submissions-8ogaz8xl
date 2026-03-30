class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            strMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);

    
        }
          return new ArrayList<>(strMap.values());
    }
}
