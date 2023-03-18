class Solution {
    int max = 0;
    HashMap<Pair<Integer, Integer>, Integer > map = new HashMap();
    public int eraseOverlapIntervals(int[][] intervals) {
        

        Arrays.sort(intervals, (a,b)->{
             if(a[0] == b[0]){
                 return a[1] - b[1];
                 }else{
                return a[0]-b[0];
                }
                 });
        int[] dp = new int[intervals.length];

        List< Pair<Integer, Integer> > al = new ArrayList();
        for( int[] in: intervals){
            al.add( new Pair(in[0], in[1]) );
        }
        dp[0] = 1;
        for( int i = 1; i< intervals.length; i++){
            int max = 0;
            for( int j = i-1; j >= 0 ;j-- ){
                if( !isConflict(intervals[j], intervals[i] ) ){
                    max = Math.max(dp[j], max);
                    break;
                }
            }
            dp[i] = max+1;
        }

        // System.out.println( Arrays.toString(dp) );

        // dfs(al, 0);
        int m = 0;
        for(int i: dp){
            m = Math.max(m, i);
        }

        return intervals.length- m;
    
    }

    public void dfs( List< Pair<Integer, Integer> > al, int i){
        System.out.println(map);
        // if( map.containsKey(al.get(i)) ){
        //     return;
        // }

        // System.out.println( i+" "+al);
        if( i >= al.size()-1  || al.size() < max ){
            // map.put(al.get(i), Math.max( max, al.size()) );
            max = Math.max( max, al.size());
            return ;
        }

        Pair<Integer, Integer> pr1 = al.get(i);
        Pair<Integer, Integer> pr2 = al.get(i+1);

        if( isConflict(pr1, pr2) ){

            List< Pair<Integer, Integer> > al1 = new ArrayList(al);
            al1.remove(pr1);
            List< Pair<Integer, Integer> > al2 = new ArrayList(al);
            al2.remove(pr2);
            
            dfs( al1, i );
            dfs( al2, i );
            
        }else{
            dfs(al, i+1);
        }


        // map.put(pr1, Math.max( max, al.size()) );
    }

    public boolean isConflict(int[] pr1, int[] pr2){
        if( pr1[1] <= pr2[0]){
            return false;
        }
        
        return true;
    }

    public boolean isConflict(Pair<Integer, Integer> pr1, Pair<Integer, Integer> pr2){
        if( pr1.getValue() <= pr2.getKey()){
            return false;
        }
        
        return true;
    }
}