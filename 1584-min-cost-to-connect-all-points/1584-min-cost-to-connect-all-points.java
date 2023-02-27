class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int[][] di = new int[points.length][points.length];
        int sum = 0;
        Map<int[], Integer> map= new HashMap();
        Queue<int[]> heap = new PriorityQueue<int[]>((a,b)-> {
            return map.get(a) - map.get(b);
        });
        
        DSU dsu = new DSU(points.length);
  

        for( int i = 0; i < points.length; i++){
               
                for( int j = 0; j<points.length; j++){
                    if(  i != j){
                        // if( min > dist(points[i][0], points[i][1],points[j][0],points[j][1] ) ){
                        //     minJ = j;
                        //     minI = i;
                        //     min = dist(points[i][0], points[i][1],points[j][0],points[j][1] );
                        // }
                        map.put( new int[]{ i, j}, dist(points[i][0], points[i][1],points[j][0],points[j][1] ));
                    }
                }
            
        }
        heap.addAll(map.keySet());



        while( !dsu.allConnected()){
            int minI = -1;
            int minJ = -1;
            int min = Integer.MAX_VALUE;

            int[] m = heap.poll();
            // System.out.println(Arrays.toString(m));

            if( dsu.union(m[0], m[1]) ){
                sum += dist(points[m[0]][0], points[m[0]][1],points[m[1]][0],points[m[1]][1] );
            }
            
            
            
     
        }

        return sum;
    }

    public int dist(int x1, int y1, int x2, int y2){

        return Math.abs( x2-x1) + Math.abs( y2-y1) ;
    }
}

public class DSU{

    int position[];
    int rank[];

    public DSU(int sz){
        position = new int[sz];
        rank = new int[sz];
        for(int i =0; i< sz; i++){
            position[i] = i;
        }
    }


    public int find(int x){
        if( position[x] == x){
            return x;
        }else{
            return find(position[x]);
        }
    }

    public boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if( x == y){
            return false;
        }else if( rank[x] > rank[y]){
            rank[x]++;
            position[y] = x;
        }else if(( rank[x] < rank[y])){
            rank[y]++;
            position[x] = y;
        }else{
            rank[y]++;
            position[x] = y;
        }

        return true;
    }

    public boolean allConnected(){
        int sum = 0;

        for(int i =0; i< position.length; i++){
            if( position[i] == i){
                sum++;
                if( sum > 1){
                    return false;
                }
            }
        }

        return true;
    }
}