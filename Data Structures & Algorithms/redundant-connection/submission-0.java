
class Solution {
    int[] parent;

        int find(int x) {
                while (parent[x] != x) {
                            parent[x] = parent[parent[x]];
                                        x = parent[x];
                                                }
                                                        return x;
                                                            }

                                                                public int[] findRedundantConnection(int[][] edges) {
                                                                        int n = edges.length;
                                                                                parent = new int[n + 1];
                                                                                        for (int i = 0; i <= n; i++) parent[i] = i;

                                                                                                for (int[] e : edges) {
                                                                                                            int px = find(e[0]), py = find(e[1]);
                                                                                                                        if (px == py) return e;
                                                                                                                                    parent[px] = py;
                                                                                                                                            }
                                                                                                                                                    return new int[]{};
                                                                                                                                                        }
                                                                                                                                                        }
                                                                                                                                                    
