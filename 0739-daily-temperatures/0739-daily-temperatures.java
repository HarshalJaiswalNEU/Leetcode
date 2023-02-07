class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack() ;
        int[] res = new int[temperatures.length ];
        res[temperatures.length-1] = 0;
        // stack.push( temperatures[temperatures.length-1] );
        int k = 0;

        for(int i =temperatures.length -2; i>= 0; i--){
           int j = i+1;
           if( temperatures[i] == temperatures[i+1]){
            //    System.out.println( temperatures[i] +" j"+i);
               if(  res[i+1] == 0){
                   res[i] = 0;
               }else{
                   res[i] = res[i+1]+1;
               }
               continue;
           }

           while( j < temperatures.length && temperatures[i] >= temperatures[j]){
               j++;
           }
        //    System.out.println( temperatures[i] +" j"+j);
           if( j == temperatures.length || temperatures[i] >= temperatures[j]){
               res[i] = 0;
           }else{
               res[i] = j-i;
           }
        }

        return res;

    }
}