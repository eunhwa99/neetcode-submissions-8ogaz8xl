class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        int l = 0, maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);
            maxf = Math.max(maxf, count.get(c));

            while ((r - l + 1) - maxf > k) {
                char left = s.charAt(l);
                count.put(left, count.get(left) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}