class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

     Map<Integer, List< Integer >>  map = new HashMap<>();

     for(int[] preq: prerequisites){
         List<Integer> ll = map.getOrDefault(preq[1], new LinkedList<Integer>());
         ll.add(preq[0]);
         map.put(preq[1], ll);
     }

     System.out.println(map);
     boolean[] v = new boolean[numCourses];
     boolean[] noCycl = new boolean[numCourses];
     Set<Integer> noDep = new LinkedHashSet<>();
     boolean b = false;
     for(int i =0; i<numCourses; i++ ){
         b = dfs(i, map, v, noCycl, noDep);
         if(b) return new int[]{};
     }
     System.out.println( " "+noDep);
    int[] res = new int[numCourses];
    int i = numCourses-1;
    for( int val: noDep){
        res[i] = val;
        i--;
    }
    // System.out.println(Arrays.toString(res));


     return res;

    }

    public boolean dfs(int i,  Map<Integer, List< Integer >>  map, boolean[] v, boolean[] noCycl, Set<Integer> noDep){
        
        if(v[i]){
            
            return true;
        }
        
        if(noCycl[i]) {
            return false;
        };
        
        if(!map.containsKey(i) ) {
            noDep.add(i);
            return false ;
        }
        
        v[i] = true;
        boolean b = false;
        for(int val: map.get(i)){
            b = dfs(val, map, v, noCycl, noDep);
            if(b) return true;
        } 
        

        v[i] = false;
        noCycl[i] = true;
        noDep.add( i);
        return b;
    }
}