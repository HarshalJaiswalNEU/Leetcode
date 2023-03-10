class Solution {
    
public int findShortestSubArray(int[] nums) {
      Map< Integer, Deque<Integer> > map = new HashMap();
	int res = Integer.MAX_VALUE, max_deg = 0;
	for(int i =0; i< nums.length; i++ ){
	Deque<Integer> dq = map.getOrDefault(nums[i], new ArrayDeque() );
dq.add(i);
map.put(nums[i], dq); 
}
// [1,1,2,2,3,2,1,1,2]
//{ 1=[0,1,6,7], 2=[2,3,5,8], 3=[4] }

// System.out.println(map);
for(int key: map.keySet() ){
	Deque<Integer> dq = map.get(key);
    
	if( max_deg < dq.size() ){
        // System.out.println(dq);
		max_deg = dq.size();
		int t = 1+( dq.getLast() - dq.getFirst() );
		res = t;
	}else if( max_deg == dq.size() ){
        // System.out.println(dq);
		max_deg = dq.size();
		int t = 1+( dq.getLast() - dq.getFirst() );
		res = Math.min(res, t);
	}
}
return res;


   }
}