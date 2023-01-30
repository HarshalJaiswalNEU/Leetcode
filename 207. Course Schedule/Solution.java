class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new TreeMap<>();

        if( prerequisites.length <= 0)
        return true;

        for(int i =0; i< prerequisites.length ; i++){
            List<Integer> al = map.getOrDefault(prerequisites[i][1], new LinkedList<>() );
            al.add(prerequisites[i][0]);
            map.put( prerequisites[i][1], al);

        }

        // System.out.println("map "+map);
        boolean[] v = new boolean[numCourses];
        boolean[] noCyc = new boolean[numCourses];

        for(int i =0; i< numCourses ; i++){
             if( isCycle(i, map, v, noCyc )) return false;
        }
        
        return true;
    }


    public boolean isCycle(int i, Map<Integer, List<Integer>> map, boolean[] v, boolean[] noCyc){

        if(v[i]){
            return true;
        }
        if(noCyc[i]){
            return false;
        }
        if(!map.containsKey(i)){
            return false;
        }

        v[i] = true;
        boolean ret = false;
        for(int val: map.get(i)){
            ret = isCycle(val, map, v, noCyc);
            if(ret) return true;
        }

        v[i] = false;

        noCyc[i] = true;
        return ret;
    }



    public void dfs2(Map<Integer, Set<Integer>> map, int key){
        if(!map.containsKey(key) ){
            return ;
        }

        Set<Integer> st = map.get(key);
        System.out.println("st "+st);
        // int[] ii = st.toArray();
        for(int i:st){
            Set<Integer> valSet = map.getOrDefault(i, new HashSet() );

            if(valSet.size() > 0){
                for(int j: valSet){
                    st.add(j);
                }
            }
        }
        map.put(key, st);
        System.out.println("map2 "+map);
    }


    public boolean dfs(Map<Integer, Set<Integer>> map, int key, Set<Integer> set){
        // System.out.println("dfs "+ key +" mp"+map+" st"+set);
        if(set.contains(key)){
            return true;
        }

        set.add(key);
        if( !map.containsKey(key) ){
            // System.out.println("no key");
            return false;
        }
        Set<Integer> st = map.get(key);

        if( st.contains(key) ){
            return true;
        }
        
        boolean b = false;
        for(int i: st){
            b = b || dfs(map, i, set);
        }
        return b;
    }

}