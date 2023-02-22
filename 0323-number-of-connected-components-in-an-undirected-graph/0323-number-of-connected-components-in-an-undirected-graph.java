class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU ds = new DSU(n);
        for(int[] ed: edges){
            ds.union(ed[0], ed[1]);
        }
        
        return ds.nodes();
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size){
        parent = new int[size];
        rank = new int[size];
        for( int i=0; i< size; i++){
            parent[i] = i; 
        }
    }

    public int find(int edge){
        
            if( parent[edge] == edge){
                return edge;
            }else{
                return find(parent[edge]);
            }
            
    }

    public boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if( x == y ) return false;
        else if( rank[x] < rank[y]){
            parent[y] = x;
        }else if( rank[x] > rank[y]){
            parent[x] = y;
        }else{
            parent[y] = x;
            rank[x]++;
        }
        // System.out.println( "rank "+Arrays.toString(rank));
        // System.out.println( "parent "+Arrays.toString(parent));
        return true;
    }

    public int nodes(){
        int sum = 0;
        for( int i=0; i< parent.length; i++){
            if(parent[i] == i){
                sum++;
            } 
        }

        return sum;
    }
}