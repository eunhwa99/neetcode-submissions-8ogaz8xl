class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {

    boolean[] visited = new boolean[numCourses];
    Map<Integer, List<Integer>> list = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      list.computeIfAbsent(prerequisite[0], ArrayList::new).add(prerequisite[1]);
    }

    boolean[] inStack = new boolean[numCourses];
    for (int cur : list.keySet()) {
      if (visited[cur]) {
        continue;
      }
      visited[cur] = true;
      inStack[cur] = true;
      if (!dfs(visited, inStack, cur, list)) {
        return false;
      }
      inStack[cur] = false;
    }

    return true;
  }

  boolean dfs(boolean[] visited, boolean[] inStack, Integer root, Map<Integer, List<Integer>> map) {
    for (Integer cur : map.getOrDefault(root, Collections.emptyList())) {
      if (inStack[cur]) {
        return false;
      }
      if (visited[cur]) {
        continue;
      }
      inStack[cur] = true;
      visited[cur] = true;
      boolean find = dfs(visited, inStack, cur, map);
      inStack[cur] = false;
      if (!find) {
        return false;
      }
    }

    return true;
  }
}