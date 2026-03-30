class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        
        int[] count = new int[26];
        int maxFreq = 0;
        int left = 0;
        for(int r=0;r<s.length();r++){
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(count[s.charAt(r)-'A'], maxFreq);
            while(left < r && (r-left+1-maxFreq)>k){
                count[s.charAt(left)-'A']--;
                maxFreq = Math.max(count[s.charAt(left)-'A'], maxFreq);
                left++;
            }
            res = Math.max(res, (r-left+1));
        }


        return res;
    }
}
