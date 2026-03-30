class Twitter {
        int order = 0;
            int[] tweets;
                Map<Integer, Set<Integer>> followMap;
                    Map<Integer, List<Integer>> tweetMap;

                        public Twitter() {
                                tweets = new int[1002];
                                        followMap = new HashMap<>();
                                                tweetMap = new HashMap<>();
                                                    }

                                                        public void postTweet(int userId, int tweetId) {
                                                                tweetMap.computeIfAbsent(userId, ArrayList::new).add(tweetId);
                                                                        tweets[tweetId] = order++;
                                                                            }

                                                                                public List<Integer> getNewsFeed(int userId) {
                                                                                        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

                                                                                                List<Integer> tweetList = tweetMap.getOrDefault(userId, Collections.emptyList());
                                                                                                        for (int t : tweetList) {
                                                                                                                    pq.add(new int[]{tweets[t], t});
                                                                                                                            }

                                                                                                                                    Set<Integer> followList = followMap.getOrDefault(userId, Collections.emptySet());
                                                                                                                                            for (int f : followList) {
                                                                                                                                                if(f==userId) continue;
                                                                                                                                                        tweetList = tweetMap.getOrDefault(f, Collections.emptyList());
                                                                                                                                                                    for (int t : tweetList) {
                                                                                                                                                                                    pq.add(new int[]{tweets[t], t});
                                                                                                                                                                                                }
                                                                                                                                                                                                        }

                                                                                                                                                                                                                List<Integer> result = new ArrayList<>();
                                                                                                                                                                                                                        for (int i = 0; i < 10; i++) {
                                                                                                                                                                                                                                    if (!pq.isEmpty())
                                                                                                                                                                                                                                                    result.add(pq.poll()[1]);
                                                                                                                                                                                                                                                                else break;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                return result;
                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                        public void follow(int followerId, int followeeId) {
                                                                                                                                                                                                                                                                                                followMap.computeIfAbsent(followerId, HashSet::new).add(followeeId);
                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                        public void unfollow(int followerId, int followeeId) {
                                                                                                                                                                                                                                                                                                                if (followMap.containsKey(followerId)) {
                                                                                                                                                                                                                                                                                                                            followMap.get(followerId).remove(followeeId);
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        }

