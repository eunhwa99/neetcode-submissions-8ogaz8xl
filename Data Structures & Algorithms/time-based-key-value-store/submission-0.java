class TimeMap {
        Map<String, List<Node>> time;

            public TimeMap() {
                    time = new HashMap<>();
                        }

                            static class Node {
                                    int timestamp;
                                            String value;

                                                    Node(int t, String v) {
                                                                this.timestamp = t;
                                                                            this.value = v;
                                                                                    }
                                                                                        }

                                                                                            public void set(String key, String value, int timestamp) {
                                                                                                    time.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
                                                                                                        }

                                                                                                            public String get(String key, int timestamp) {
                                                                                                                    if (!time.containsKey(key)) return "";
                                                                                                                            List<Node> nodeList = time.get(key);
                                                                                                                                    if(nodeList.get(0).timestamp > timestamp) return "";

                                                                                                                                            int left = 0;
                                                                                                                                                    int right = nodeList.size() - 1;
                                                                                                                                                            String res = "";
                                                                                                                                                                    while (left <= right) {
                                                                                                                                                                                int mid = left + (right - left) / 2;
                                                                                                                                                                                            if(nodeList.get(mid).timestamp > timestamp){
                                                                                                                                                                                                            right = mid - 1;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    else{
                                                                                                                                                                                                                                                    left = mid + 1;
                                                                                                                                                                                                                                                                    res = nodeList.get(mid).value;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                return res;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    }

