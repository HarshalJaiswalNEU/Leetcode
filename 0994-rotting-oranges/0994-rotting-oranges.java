class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q1 = new LinkedList();
        Queue<int[]> q2 = new LinkedList();
        int sum = 0;
        int[] x = {0, 1, 0 , -1};
        int[] y = {1, 0, -1 , 0};

        for( int i=0; i< grid.length; i++){
            for( int j =0; j< grid[0].length; j++){
                if( grid[i][j] == 2){
                    q1.add( new int[]{ i, j} );
                }
            }
        }
       
        while( !q1.isEmpty() | !q2.isEmpty()){
            int f = 0;
            if( !q2.isEmpty()){
            while( !q2.isEmpty()){
               int[] pt = q2.poll();
               for( int i=0; i< 4; i++){
                   int xx = pt[0] + x[i];
                   int yy = pt[1] + y[i];

                   if( xx >= 0 && yy >= 0 && xx < grid.length && yy < grid[0].length && grid[xx][yy] == 1){
                       grid[xx][yy] = 2;
                       q1.add( new int[]{xx, yy});
                       f++;
                   }
                   
               }
               
           }
            }else{

           while( !q1.isEmpty()){
               int[] pt = q1.poll();
               for( int i=0; i< 4; i++){
                   int xx = pt[0] + x[i];
                   int yy = pt[1] + y[i];

                   if( xx >= 0 && yy >= 0 && xx < grid.length && yy < grid[0].length && grid[xx][yy] == 1){
                       grid[xx][yy] = 2;
                       q2.add( new int[]{xx, yy});
                       f++;
                   }
                   
               }
           }
            }

        //    for( int i=0; i< grid.length; i++){
        //        System.out.println( Arrays.toString(grid[i]) );
        //    }
        //    System.out.println();
           if( f > 0){
               sum++;
           }
           

        }

        for( int i=0; i< grid.length; i++){
            for( int j =0; j< grid[0].length; j++){
                if( grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return sum;
        
    }
}