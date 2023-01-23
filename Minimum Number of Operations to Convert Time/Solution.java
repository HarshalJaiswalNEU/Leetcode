package Minimum Number of Operations to Convert Time;

class Solution {
    public int convertTime(String current, String correct) {

      int diff =  convert(correct) - convert(current);
      int[] slot = new int[]{ 5,15,60};
      int[] dp = new int[diff+1];
      Arrays.fill(dp,diff+1 );
      dp[0] = 0;
      for(int i=1; i< diff+1; i++){
        for(int slt: slot){
          if(i - slt >= 0){
            System.out.println(i+", "+(i - slt)+" dp "+dp[ i - slt]);
            dp[i] = Math.min(dp[i], 1 + dp[ i - slt]);
          }
          System.out.println(dp[i]);
        }
      }

      return dp[diff]==diff+1? -1: dp[diff];
    }

    public int convert(String time){

      String[] str = time.split(":");
      int hr = Integer.parseInt(str[0]);
      int min = Integer.parseInt(str[1]);
      
      return (hr*60)+min;

    }
}