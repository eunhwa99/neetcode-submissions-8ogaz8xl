class Solution {
    public String foreignDictionary(String[] words) {// 1. 모든 문자 등록
    Map<Character, Set<Character>> adj = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();
    for (String w : words)
        for (char c : w.toCharArray()) {
            adj.putIfAbsent(c, new HashSet<>());
            indegree.putIfAbsent(c, 0);
        }

    // 2. 간선 추출
    for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i], w2 = words[i+1];
        int len = Math.min(w1.length(), w2.length());
        // 엣지케이스: ["abc","ab"] 같은 invalid input
        if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
        for (int j = 0; j < len; j++) {
            if (w1.charAt(j) != w2.charAt(j)) {
                char from = w1.charAt(j), to = w2.charAt(j);
                if (!adj.get(from).contains(to)) {
                    adj.get(from).add(to);
                    indegree.put(to, indegree.get(to) + 1);
                }
                break; // 첫 번째 다른 글자만
            }
        }
    }

    // 3. BFS
    Queue<Character> q = new LinkedList<>();
    for (char c : indegree.keySet())
        if (indegree.get(c) == 0) q.offer(c);

    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
        char c = q.poll();
        sb.append(c);
        for (char nei : adj.get(c)) {
            indegree.put(nei, indegree.get(nei) - 1);
            if (indegree.get(nei) == 0) q.offer(nei);
        }
    }

    // 4. 사이클 체크
    return sb.length() == indegree.size() ? sb.toString() : "";
}

}
