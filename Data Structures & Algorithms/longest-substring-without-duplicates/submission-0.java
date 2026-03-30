class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> strSet = new HashSet<>();
        int left = 0, right = 0;
    

        int res = 0;
        while(right<s.length()){
            char cur = s.charAt(right);
    
            while(left<right && strSet.contains(cur)){
                strSet.remove(s.charAt(left++));
            }
            strSet.add(cur);
            res = Math.max(res, (right-left) + 1);
            right++;
        }

        return res;
    }
}
