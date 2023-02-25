class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet();
        
        for( String s: emails){
            String[] dm = s.split("@");
            dm[0] = dm[0].replace(".", "");
            
            if( dm[0].contains("+") ){
                
                String[] dm1 = dm[0].split("\\+");
                dm[0] = dm1[0];
                                  
            }                
            set.add( dm[0]+"@"+dm[1]);
            // System.out.println(set);
            
        }
                                  
        return set.size();         
        
        
    }
}