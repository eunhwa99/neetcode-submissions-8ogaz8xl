class TimeMap {
    Map<String, List<Node>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }

    class Node{
        String v;
        int t;

        Node(String v, int t){
            this.v=v;
            this.t=t;
        }
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k->new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";
        List<Node> list = mp.get(key);
        if(list.get(0).t > timestamp) return "";
        int left=0;
        int right = list.size();
       
        while(left<right){
            int mid = left + (right-left)/2;
            if(list.get(mid).t <= timestamp){
                left = mid + 1;
            }
            else right = mid;
        }
        if(left > 0) return list.get(left-1).v;
        return "";
    }
}
