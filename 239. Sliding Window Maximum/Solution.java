class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
    int l = 0 , r = 1;
    Deque<Integer> deq = new ArrayDeque<>();

    if(k ==1){
        return nums;
    }
    List<Integer> al = new ArrayList();
    deq.add(nums[0]);
   
    while( r < nums.length ){
        
        while( r < nums.length && r-l < k){
            
            while( !deq.isEmpty() && deq.peekLast() < nums[r] ){
                deq.pollLast();
            }
            deq.addLast(nums[r]);
            // System.out.println( deq );
            r++;
        }

        al.add( deq.peekFirst() );
        // System.out.println( al );
        if( nums[l] == deq.peekFirst() ){
            deq.pollFirst();
        }
        l++;
    }

        // System.out.println( (al) );
        int[] ress = new int[al.size()]; 

        for(int i= 0; i< al.size() ; i++){
             ress[i] = al.get(i);
        }

        return ress;
    }
}