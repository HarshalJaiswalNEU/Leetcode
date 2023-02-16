class Solution {
    Set<List<Integer>> res = new HashSet<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ress = new ArrayList<List<Integer>>();
        List<Integer> r = new ArrayList();
        for(int n: candidates){
            r.add(n);
        }
        if(sum(r)<target){
            return ress;
        }

        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList() );

        // System.out.println(res);
        
        res.forEach((v)->{
            if(sum(v) == target){
                ress.add(v);
            }
            
        });
        return ress;
    }

    public void dfs(int[] candidates, int t, int st, List<Integer> al){
        // System.out.println(al +" "+ sum(al)+" st"+st);
        res.add(new ArrayList(al) );
        if(st > candidates.length ){
            // System.out.println("hello ");
            return;
        }
        if( sum(al) > t){
            return ;
        }
        if( sum(al) == t){
            
            return;
        }
        
        
        for( int i= st; i< candidates.length; i++){
            al.add( candidates[i]);
            if(sum(al) <= t && !res.contains(al) ){
                dfs( candidates, t, i+1, al );
            }
            
            al.remove(al.size()-1);
        }
        
    }

    public int sum(List<Integer> al){
        int sum = 0;
        for(int i: al){
            sum += i;
        }

        return sum;
    }
}