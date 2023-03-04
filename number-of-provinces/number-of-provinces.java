class Solution {
    public int findCircleNum(int[][] isConnected) {
        DSU ds = new DSU(isConnected.length);
        
        for(int i =0; i<isConnected.length; i++){
            for( int j = i+1; j< isConnected.length; j++){
                if( isConnected[i][j] == 1){
                    ds.union( i, j);
                }
            }
        }
        return ds.nodes();
    }
}

class DSU{
    int parent[];
    int ranks[];

    public DSU(int size){
        parent = new int[size];
        ranks = new int[size];

        for( int i =0; i< size;  i++){
            parent[i] = i;
        }
    }


    public int find(int edge){
        if( parent[edge] == edge){
            return edge;
        }else{
            return find( parent[edge]);
        }
    }

    public boolean union( int x, int y){

        x = find(x);
        y = find(y);
        if( x == y){
            return false;
        }else if(ranks[x] > ranks[y]){
            parent[x] = y;
        }else if( ranks[x] < ranks[y]){
            parent[y] = x;
        }else{
            parent[y] = x;
            ranks[x]++;
        }

        return true;
    }

    public int nodes(){
        int sum = 0;
        for( int i =0; i< parent.length ;  i++){
            if(parent[i] == i){
                sum++;
            }
        }

        return sum;
    }
}