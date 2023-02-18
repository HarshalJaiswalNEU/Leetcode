class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int i = 0;
        int j = 0;
        int max = 0;

        Map<Character, Integer> map = new HashMap();
        while( j < s.length()){
            map.put( s.charAt(j), map.getOrDefault(s.charAt(j), 0 )+1 );
            while( map.size() > k ){
                int rm = map.get( s.charAt(i) )-1;
                if(rm == 0){
                    map.remove( s.charAt(i) );
                }else{
                     map.put( s.charAt(i), rm );
                }
                i++;
            }
            // System.out.println(map);
            max = Math.max(max, (j - i)+1 );
            j++;
        }

        return max;
    }
}