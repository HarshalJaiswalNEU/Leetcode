class TimeMap {

    Map<String, LinkedHashMap<Integer, String> > map ;
    Map<String, List<Integer> > mapMap ;

    public TimeMap() {
        map = new HashMap<String, LinkedHashMap<Integer, String>>();
        mapMap = new HashMap<String, List<Integer>>();
    }
    
    public void set(String key, String value, int timestamp) {
        LinkedHashMap<Integer, String> te = map.getOrDefault(key, new LinkedHashMap<Integer, String>());
        te.put(timestamp, value);
        map.put( key, te);
        List<Integer> al = mapMap.getOrDefault(key, new LinkedList());
        al.add(timestamp);
        mapMap.put(key, al);
        // System.out.println(map);
    }

    public int bst(List<Integer> al, int l, int r, int t){
        if( l< r){
            return l;
        }
        int m = (l+r)/2;

        if( m > t){
            return bst(al,l, m-1, t );
        }else{
             return bst(al,m+1, r, t );
        }
    }
    
    public String get(String key, int timestamp) {
        // System.out.println("timestamp "+timestamp+" ,"+key);
        
        if( map.containsKey(key)){
            LinkedHashMap<Integer, String> te = map.get(key);
            if( te.containsKey(timestamp)){
                return te.get(timestamp);
            }

            List<Integer> al = mapMap.get(key);
            // System.out.println(al);
            if( timestamp < al.get(0)){
                return "";
            }
            if(timestamp > al.get(al.size()-1)){
                return te.get(al.get(al.size()-1));
            }
            int target = bst(al, 0, al.size()-1,timestamp );
            
            // System.out.println("target "+target);
            return te.get(al.get(target)); 
        }

        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */