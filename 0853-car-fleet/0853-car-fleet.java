class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Map<Integer, Integer> map = new HashMap();
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
            return map.get(a)- map.get(b);
        });
        for(int i =0; i< position.length; i++){
            position[i]= (target - position[i]);
            map.put(i, position[i]);
        }
        pq.addAll(map.keySet());

        float[] time = new float[position.length];
        // System.out.println( Arrays.toString( position) );

        for(int i =0; i< position.length; i++){
            time[i]= (float)position[i]/speed[i];
        }
        // System.out.println( Arrays.toString( speed) );
        // System.out.println( Arrays.toString( time) );

        
        Deque<Float> dq = new ArrayDeque();
        dq.add(time[pq.poll()] );
        while( !pq.isEmpty()){
            
            if( dq.getLast() < time[pq.peek()]){
                dq.addLast( time[pq.peek()] );
            }

            pq.poll();

            
            // System.out.println(  time[pq.peek()]+" v " +dq.getLast());
            
            //  System.out.println( dq );
        }

       

        return dq.size();
    }
}