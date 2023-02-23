class Solution {

    List<String> wordList;
    int max = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordLists) {
        
        int p = -1;
        this.wordList = wordLists;
        for(String s: wordList){
            if( endWord.equals(s) ){
                p++;
                break;
            }
        }
        if( p == -1) return 0;
        Queue<String> q1 = new LinkedList();
        Queue<String> q2 = new LinkedList();

        p = -1;
        for(int i = 0;i< wordList.size(); i++){

            if( beginWord.equals(wordList.get(i) ) ){
                p = i;
                break;
            }
        }
        if( p != -1){
            wordList.remove(p);
        }
        q1.add(beginWord);
        int i = 0;
        int fl = 0;
        while( !q1.isEmpty() || !q2.isEmpty()){
            // System.out.println( q1 +", "+ q2);
            if( !q1.isEmpty() ){
                while( !q1.isEmpty()){
                    String curr = q1.poll();
                    if( endWord.equals(curr)){
                        // q1.removeAll();
                        // q2.removeAll();
                        return i+1;
                    }

                    List<String> al = new ArrayList();
                    for( int j = 0; j< wordList.size(); j++){
                        if( isRelatedWord(curr, wordList.get(j) )){
                            q2.add(wordList.get(j));
                            al.add(wordList.get(j));
                        }
                    }
                    for( int j = 0; j< al.size(); j++){
                            wordList.remove(al.get(j) );
                    }
                }
            }else{
                while( !q2.isEmpty()){
                    String curr = q2.poll();
                    if( endWord.equals(curr)){
                        // q1.removeAll();
                        // q2.removeAll();
                        return i+1;
                    }
                    List<String> al = new ArrayList();
                    for( int j = 0; j< wordList.size(); j++){
                        if( isRelatedWord(curr, wordList.get(j) )){
                            q1.add(wordList.get(j));
                            al.add(wordList.get(j));
                        }
                    }
                    for( int j = 0; j< al.size(); j++){
                            wordList.remove(al.get(j) );
                    }
                }

            }
            // System.out.println( q1 +",l "+ q2);
            i++;
        }

        // Node n = new Node(beginWord);
        // dfs(n ,endWord, 0 );
        
        return 0;
    }

    public void dfs( Node n, String endWord, int i){
        
            String curr = n.val;
            // System.out.println(curr+" ,"+ wordList+" i:"+i);
            if( curr.equals(endWord)){
                max = Math.max( max, i+1);
                return ;
            }
            List<String> al = new ArrayList();
            for( int j=0; j<  wordList.size() ;j++){
                if( isRelatedWord( curr , wordList.get(j) )) {
                    // System.out.println(curr+" rtd "+ wordList.get(j));
                    al.add(wordList.get(j));
                    n.addChild( new Node(wordList.get(j)) );
                }
            }
           

            for( int j=0; j<  al.size() ;j++){
                wordList.remove( al.get(j) );
            }

            //  System.out.println(curr+" 1,"+ wordList+" "+al);
            List<Node> anl = n.getChild();
            for( int j=0; j<  anl.size() ;j++){
                dfs(anl.get(j),endWord, i+1 );
            }

    }

    public boolean isRelatedWord( String s1, String s2){
        int sum = 0;
        for(int i=0; i< s1.length(); i++){
            if( s1.charAt(i) != s2.charAt(i) ){
                sum++;
            }
        }

        return sum <= 1;
    }
}

class Node{
    String val;
    private List<Node> child;

    public Node(String val){
        this.val = val;
        child = new LinkedList();
    }

    public void addChild( Node n){
        child.add(n);
    }

    public List<Node> getChild(){
        return child;
    }

}