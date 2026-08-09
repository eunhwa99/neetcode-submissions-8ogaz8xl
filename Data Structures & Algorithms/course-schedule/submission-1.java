class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            ind[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (ind[i] == 0) {
                que.offer(i);
            }
        }

        int count = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            count++;

            for (int next : adj.get(cur)) {
                ind[next]--;

                if (ind[next] == 0) {
                    que.offer(next);
                }
            }
        }

        return count == numCourses;
    }
}