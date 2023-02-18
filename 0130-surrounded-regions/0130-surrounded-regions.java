class Solution {
    public void solve(char[][] board) {
        
        for( int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; ){
                if( board[i][j] == 'O'){
                    dfs(board, i, j);
                }
                if( (i != 0 && i != board.length -1) ){
                     j += board[0].length -1 ;
                }else{
                   j++;
                }
                

            }
        }

        for( int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length;j++ ){
                if( board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if( board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                
                

            }
        }

        //  for( int i = 0; i< board.length; i++){
        //  System.out.println( Arrays.toString(board[i] ) );
        //  }

    }

    public void dfs( char[][] board, int i, int j){
        
        if( i < 0 || j < 0 || i > board.length-1 || j >  board[0].length-1 || board[i][j] != 'O'){
           return ;
        }
        // System.out.println(i+ " ,"+ j+" "+board[i][j]);

        // if( board[i][j] != 'O'){
        //     return false;
        // }

        board[i][j] = '#';
        // System.out.println(i+ " ,"+ j+" "+board[i][j]);

        dfs(board, i+1,j ) ;
        dfs(board, i,j+1 );
        dfs(board, i-1,j );
        dfs(board, i, j-1 );
        
    }
}