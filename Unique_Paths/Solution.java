package Unique_Paths;

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] mat = new int[m][n];
        // dfs(mat, 0 , 0);
        for(int i = 0; i< mat.length; i++){
            mat[i][0] = 1;
            // mat[0][i] = 1;
        }
        for(int j=0; j< mat[0].length; j++){
            mat[0][j] = 1;
        }
        
         for(int i = 1; i< mat.length; i++){
            for(int j= 1; j< mat[0].length; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
            
        }
        
        
        for(int i = 0; i< mat.length; i++){
            for(int j=0; j< mat[0].length; j++){
                System.out.print(mat[i][j]+", ");
            }
            System.out.println();
        }
        
        return mat[m-1][n-1];
        
    }
    
    public void dfs(int[][] mat, int i, int j){
        
        if( i > mat.length-1 || j > mat[0].length-1 )
            return ;
        
        if( i > mat.length-1 ){
            dfs(mat, i, j+1);
        }
             
        if( j > mat[0].length-1 ){
            dfs(mat, i+1, j);
        }
        mat[i][j] = mat[i][j] + 1;
        
        dfs(mat, i+1, j );
        dfs(mat, i, j+1 );
        
    }
}
