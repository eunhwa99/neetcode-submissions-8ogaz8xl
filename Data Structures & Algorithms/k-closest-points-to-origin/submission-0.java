 class Point{
    int dist;
    int order;

    Point(int d, int o){
        this.dist=d;
        this.order=o;
    }
 }
  class Solution {
       public int[][] kClosest(int[][] points, int k) {
                PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.dist, a.dist));
                         for (int i = 0; i < points.length; i++) {
                                      int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
                                                   pq.offer(new Point(dist, i));
                                                    
                                                                 if (pq.size() > k) pq.poll();
                                                                          }
                                                                                   int[][] result = new int[k][2];
                                                                                            for (int i = 0; i < k; i++) {
                                                                                                         result[i] = points[pq.poll().order];
                                                                                                                  }
                                                                                                                           return result;
                                                                                                                                }
                                                                                                                                 }

