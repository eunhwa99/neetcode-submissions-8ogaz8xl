class Solution {
        int total;

            public boolean validTree(int n, int[][] edges) {
                    if (edges.length>n-1) return false;
                            boolean[] visited = new boolean[n];
                                    boolean[] inStack = new boolean[n];

                                            List<List<Integer>> adj = new ArrayList<>();
                                                    for (int i = 0; i < n; i++) {
                                                                adj.add(new ArrayList<>());
                                                                        }
                                                                                for (int[] e : edges) {
                                                                                            adj.get(e[0]).add(e[1]);
                                                                                                        adj.get(e[1]).add(e[0]);
                                                                                                                }

                                                                                                                        // Fix: visited[0] should probably be true if we start DFS from 0
                                                                                                                                 visited[0] = true;

                                                                                                                                         if (!dfs(visited, inStack, adj, 0, -1)) return false;
                                                                                                                                                 return total == n - 1;
                                                                                                                                                     }

                                                                                                                                                         boolean dfs(boolean[] visited, boolean[] inStack, List<List<Integer>> adj, int cur, int prev) {
                                                                                                                                                                 for (int node : adj.get(cur)) {
                                                                                                                                                                             if (node == prev) continue;
                                                                                                                                                                                         if (inStack[node]) return false;
                                                                                                                                                                                                     if (visited[node]) continue; // Cycle detection might be skipped here
                                                                                                                                                                                                                 visited[node] = true;
                                                                                                                                                                                                                             inStack[node] = true;
                                                                                                                                                                                                                                         total++;
                                                                                                                                                                                                                                                     if (!dfs(visited, inStack, adj, node, cur)) return false;
                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                                     return true;
                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                         }

