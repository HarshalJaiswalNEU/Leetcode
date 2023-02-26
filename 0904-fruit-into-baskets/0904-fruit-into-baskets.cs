public class Solution {
    public int TotalFruit(int[] fruits) {
        
        int l = 0, r = 0 , max = 0;
        Dictionary<int ,int> map = new Dictionary<int ,int>();

        while( r < fruits.Length){
            if( !map.ContainsKey(fruits[r]) ){
                map[fruits[r]] = 0;
            }
            map[fruits[r]]++;

            while(map.Count > 2){
                int v = map[fruits[l]]-1;
                if( v == 0){
                    map.Remove(fruits[l]);
                }else{
                    map[fruits[l]]--;
                }
                l++;
            }

            r++;
            max = Math.Max(max, (r-l));

        }

        return max;
    }
}