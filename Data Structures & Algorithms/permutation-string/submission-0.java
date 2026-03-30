class Solution {
    public boolean checkInclusion(String s1, String s2) {
      
        int s1Len = s1.length();
        if(s2.length() < s1Len) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(char c: s1.toCharArray()){
            s1Count[c-'a']++;
        }

        int l = 0, r = 0;
        boolean res= false;
        while(r < s2.length()){
            s2Count[s2.charAt(r)-'a']++;
            if((r-l+1) == s1Len){
                res = true;
                for(int i=0;i<26;i++){
                    if(s1Count[i]!=s2Count[i]){
                        s2Count[s2.charAt(l++)-'a']--;
                        
                        res = false;
                        break;
                    }
                }
                if(res) return res;
            }
            r++;
        }
        return false;
    }
}
