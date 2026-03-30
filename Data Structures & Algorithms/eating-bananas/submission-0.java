class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = 0;
        for(int pile: piles){
            maxValue = Math.max(maxValue, pile);
        }
       
        int l = 1;
        int r = maxValue;
        int res = Integer.MAX_VALUE;
        while(l<=r){
            int m = l + (r-l)/2;

            int time = 0;
            for(int pile: piles){
                time += (pile/m) + (pile%m==0?0:1);
            }
            if(time <= h){
                res = Math.min(m, res);
                r = m - 1;
            }
            else{
                l = m + 1;
            }

        }
        return res;
    }
}
