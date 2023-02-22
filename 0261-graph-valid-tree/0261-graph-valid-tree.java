class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU ds = new DSU(n);

        for(int[] ed : edges){
            if( !ds.union( ed[0], ed[1])) {
                // System.out.println( ed[0] +", "+ ed[1]);
                return false;
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

    public boolean nodes(){
        int sum = 0;
        for( int i =0; i< parent.length ;  i++){
            if(parent[i] == i){
                sum++;
            }
        }

        return sum == 1;
    }
}