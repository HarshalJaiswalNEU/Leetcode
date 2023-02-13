class KthLargest {

    int k ;
    Queue<Integer> heap = new PriorityQueue();
    List<Integer> al = new ArrayList();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for( int n: nums){
            // heap.add(n);
            int pos = bst(al, n, 0, al.size()-1);
            // al.add(-1);
            al.add(pos, n );
        }

        // System.out.println(al);
        
        

    }

    public int bst(List<Integer> nums, int i, int l, int r ){
        int m = (l+r)/2;

        if( l> r){
            return l;
        }
        if( nums.get(m) == i)  return m;

        if( nums.get(m) > i){
            return bst(nums, i, l, m-1);
        } else{
            return bst(nums, i, m+1, r);
        } 
    }

    
    
    public int add(int val) {
        int pos = bst(al, val, 0, al.size()-1);
        //  al.add(-1);
         al.add(pos, val );
        //   System.out.println(al);
         return al.get(al.size() -k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */