class TreeNode{
    public Map< Character, TreeNode> child = new HashMap();
    public boolean isEnd = false;

    public TreeNode(){}
}

class WordDictionary {
    TreeNode root;
    public WordDictionary() {
        root = new TreeNode();
    }
    
    public void addWord(String word) {
        TreeNode n = root;
        for( char ch: word.toCharArray()){
            if( !n.child.containsKey(ch) ){
                n.child.put( ch, new TreeNode());
            }
            n = n.child.get(ch);
        }
        n.isEnd = true;
    }

    public boolean search(String word, TreeNode n){
        int i =0;
        for( char ch: word.toCharArray()){
            if( !n.child.containsKey(ch) ){
                if( ch == '.' ){
                    

                    for( char chr: n.child.keySet() ){
                        // System.out.println(word.substring(i+1)+" w "+word);
                        if( search(word.substring(i+1) , n.child.get(chr) )){
                            return true;
                        }
                    }
                }
                    return false;
            
            }else{
                n = n.child.get(ch);
            }
            i++;
            
        }

        return n.isEnd;
    }
    
    public boolean search(String word) {
        // if( word.length() != )
        return search(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */