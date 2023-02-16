class Solution {

    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
         dfs(s, new ArrayList(), 0,1);
        return res;
    }

    public void dfs( String s, List<String> al, int st, int ed){
        // System.out.println(al);
        if(st >= s.length()){

            for( String ss: al){
                if( !isPalindrome(ss) ){
                    return;
                }
            }
            
            res.add(new ArrayList(al) );
        }
       
        
        for(int i = st; i< s.length()  ; i++){
            // System.out.println(st +" ,"+ (i+1));
            al.add( s.substring( st, i+1));
            dfs(s, al, i+1, ed+1);
            al.remove(al.size()-1);
        }

    }

    public boolean isPalindrome(String s){
        int l =0, r = s.length()-1; 

        while( l < r){
            if( s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}