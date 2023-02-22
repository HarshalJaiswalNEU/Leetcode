class Solution {
    public void wallsAndGates(int[][] rooms) {

        Queue<int[]> q1 = new LinkedList();
        Queue<int[]> q2 = new LinkedList();
        int n = rooms.length;
        int m = rooms[0].length;

        for( int i = 0; i< n; i++){
            for( int j=0 ; j< m; j++){
                if( rooms[i][j] == 0){
                    q1.add(new int[]{ i, j } );
                }
            }
        }
        int j = 0;
        int[] x = {0,1, 0, -1};
        int[] y = {1,0, -1, 0};

        while( !q1.isEmpty() || !q2.isEmpty() ){
            // 
            // System.out.println(Arrays.toString( q));
            j++;

            if( !q1.isEmpty() ){
                while(!q1.isEmpty()){
                    int[] q = q1.poll();
                    
                    for(int i=0 ;i< 4; i++ ){
                        int xx = q[0] + x[i];
                        int yy = q[1] + y[i];
                        if( xx >=0 && xx < n && yy >= 0 && yy < m && rooms[xx][yy] > rooms[q[0]][q[1]]){
                            rooms[xx][yy] = j;
                            q2.add(new int[]{ xx, yy });
                        }
                    }
                }
            }else{
                while(!q2.isEmpty()){
                    int[] q = q2.poll();
                    
                    for(int i=0 ;i< 4; i++ ){
                        int xx = q[0] + x[i];
                        int yy = q[1] + y[i];
                        if( xx >=0 && xx < n && yy >= 0 && yy < m && rooms[xx][yy] > rooms[q[0]][q[1]]){
                            rooms[xx][yy] = j;
                            q1.add(new int[]{ xx, yy });
                        }
                    }
                }

            }
        }
        


    
        
    }
}