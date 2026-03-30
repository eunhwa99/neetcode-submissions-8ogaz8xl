class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }
        
        for(char c: charSet){
            int left = 0;
            int tmp = k;
        for(int i=0;i<s.length();i++){
         if(s.charAt(i)!=c) tmp--;
         while(tmp < 0){
              if (s.charAt(left) != c) tmp++;
             left++;
         }
    
        res = Math.max(res, (i-left)+1);
        }
        
        }
        return res;
    }
}
