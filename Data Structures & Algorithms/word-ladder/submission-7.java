class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) return 0;

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);

        int count = 1;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int q = 0; q < size; q++) {
                String cur = que.poll();

                if (cur.equals(endWord)) {
                    return count;
                }

                char[] chars = cur.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[i] = c;

                        String next = new String(chars);

                        if (words.contains(next)) {
                            que.offer(next);

                            // visited 역할까지 같이 함
                            words.remove(next);
                        }
                    }

                    chars[i] = original;
                }
            }

            count++;
        }

        return 0;
    }
}