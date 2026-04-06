class Solution {

        public boolean validTree(int n, int[][] edges) {
                if (edges.length != n - 1) return false;
                        int[] parent = new int[n];
                                int[] rank = new int[n];

                                        for (int i = 0; i < n; i++) parent[i] = i;
                                                for (int[] node : edges) {
                                                            if (!union(node[0], node[1], parent, rank)) return false;
                                                                    }
                                                                            return true;
                                                                                }

                                                                                    boolean union(int x, int y, int[] parent, int[] rank) {
                                                                                            int parX = find(x, parent);
                                                                                                    int parY = find(y, parent);
                                                                                                            if (parX == parY) return false;
                                                                                                                    if (rank[parX] < rank[parY]) {
                                                                                                                                int tmp = parX;
                                                                                                                                            parX = parY;
                                                                                                                                                        parY = tmp;
                                                                                                                                                                }

                                                                                                                                                                        rank[parX] += 1;
                                                                                                                                                                                parent[parY] = parX;
                                                                                                                                                                                        return true;
                                                                                                                                                                                            }

                                                                                                                                                                                                int find(int x, int[] parent) {
                                                                                                                                                                                                        if (parent[x] == x) return x;
                                                                                                                                                                                                                parent[x] = find(parent[x], parent);
                                                                                                                                                                                                                        return parent[x];
                                                                                                                                                                                                                            }


                                                                                                                                                                                                                            }
