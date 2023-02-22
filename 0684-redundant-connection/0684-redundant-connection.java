class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int l = 1001;
        DSU ds = new DSU(l);

        for(int[] de : edges ){
            if( !ds.union( de[0], de[1])) return de;
        }

        return edges[0];

        // Set<Integer> set = new HashSet();
        // List<Set<Integer>> al = new ArrayList();
        // int[] res =new int[2];
        // // set.add(edges[0][0]);
        // // set.add(edges[0][1]);
        // int flag =0;

        // for(int[] de : edges ){
        //     flag = 0;
        //     int s1 = -1,s2 = -1;
        //     Set<Integer> setl = new HashSet();
        //     // System.out.println( al+" ,"+flag+" ,"+ Arrays.toString(de) );
            
        //     for( int i =0; i< al.size() ; i++){
        //         setl = al.get(i);
        //         // System.out.println( "set"+setl );
        //         // System.out.println( al+" ,"+flag+" ,"+ Arrays.toString(de) );
        //         if(setl.contains(de[0]) && setl.contains(de[1])){
        //             res[0] = de[0];
        //             res[1] = de[1];
        //             return res;
        //         }else if( setl.contains(de[0]) || setl.contains(de[1])){
                   
        //             if( flag > 0){
        //                 flag++;
        //                 res[0] = de[0];
        //                 res[1] = de[1];
        //                 s2 = i;
        //                 break;
        //             }
        //             flag++;
        //             s1 = i;
        //             setl.add(de[0]);
        //             setl.add(de[1]);
        //             //  System.out.println( flag+"set contains "+setl );

        //         }
               

        //     }
        //     if ( flag == 0){

        //         setl = new HashSet();
        //         setl.add(de[0]);
        //         setl.add(de[1]);
        //         al.add(setl);
               
        //     }else if(flag == 2){
        //         setl = new HashSet();
        //         setl.addAll(al.get(s1));
        //         setl.addAll(al.get(s2));
        //         al.remove(s2);
        //         al.remove(s1);
        //         al.add(setl);
        //     }
            
            
        //     //  System.out.println( al+" ,"+flag+" ,"+ Arrays.toString(de) );

            
            
            
        // }

        // return res;
    }
}

class DSU{
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
}