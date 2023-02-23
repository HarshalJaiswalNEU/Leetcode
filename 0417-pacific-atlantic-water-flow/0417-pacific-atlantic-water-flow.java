class Solution {
    

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int max = 0 , imx =-1 , jmx = -1;
        List<List<Integer>> res = new ArrayList<List< Integer>>();

        for( int i=0 ; i < heights.length; i++){
            for( int j = 0; j < heights[0].length; j++ ){
                // System.out.println(i+", "+j);
                // System.out.println("dfsP:-> "+dfsP(heights, i, j, heights[i][j]));
                // System.out.println("dfsA:-> "+dfsA(heights, i, j, heights[i][j]));
                if(dfsP(heights, i, j, heights[i][j]) && dfsA(heights, i, j, heights[i][j] ) ){
                    res.add( new ArrayList(Arrays.asList( i, j )) );
                    // System.out.println("true");
                }
                //  System.out.println();
                 
            }
        }

        return res;
        
    }

    public boolean dfsP(int[][] heights, int i, int j, int val){
      if( i < 0 || j < 0 || i > heights.length-1 || j > heights[0].length-1 || val < heights[i][j]){

          
          return false;
      }

      if(i <= 0 || j <= 0  ){
              return true;
          }

      int t = heights[i][j];
      heights[i][j] = Integer.MAX_VALUE;

      boolean b = dfsP(heights, i-1, j, t) || dfsP(heights, i, j-1, t) ||
                    dfsP(heights, i+1, j, t) || dfsP(heights, i, j+1, t);

        heights[i][j] = t;

        return b;
    }

    public boolean dfsA(int[][] heights, int i, int j, int val){
        // System.out.println("dfsA: "+i+", "+j+" "+ heights.length +", "+ heights[0].length);
       if( i < 0 || j < 0 || i > heights.length-1 || j > heights[0].length-1 || val < heights[i][j] ){


          
          return false;
      }
      if(i >= heights.length-1 || j >= heights[0].length-1   ){
              return true;
          }
      
      

      int t = heights[i][j];
      heights[i][j] = Integer.MAX_VALUE;

      boolean b = dfsA(heights, i-1, j, t) || dfsA(heights, i, j-1, t) ||
                    dfsA(heights, i+1, j, t) || dfsA(heights, i, j+1, t);

        heights[i][j] = t;

        return b;

    }

}