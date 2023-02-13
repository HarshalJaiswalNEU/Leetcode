class Twitter {

    Map<Integer, Set<Integer>> mapUsr;
    Map<Integer, Integer> mapFeed;
    List<Integer> al;

    public Twitter() {
        mapUsr = new HashMap();
        mapFeed = new HashMap();
        al = new LinkedList();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        mapFeed.put(tweetId, userId );
        al.add(0, tweetId);
        // System.out.println( mapFeed);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res= new ArrayList();
        int i = 0;
        // System.out.println( "mf "+mapFeed);
        // System.out.println( "mu "+mapUsr);
        // System.out.println( "al "+al);
        while( i < al.size() && res.size() < 10){
            // System.out.println( "mf1 "+mapFeed.get( al.get(i) )+" ->"+ al.get(i));
            if( mapFeed.get( al.get(i) ) == userId ){
                res.add(al.get(i));
            }else{
                if( mapUsr.containsKey(userId) &&mapUsr.get(userId).contains( mapFeed.get( al.get(i) ) ) ){
                res.add(al.get(i));
                }
            }
            i++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = mapUsr.getOrDefault(followerId, new HashSet() );
        set.add(followeeId);
        mapUsr.put(followerId, set );
        // System.out.println( mapUsr);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = mapUsr.getOrDefault(followerId, new HashSet() );
        set.remove(followeeId);
        mapUsr.put(followerId, set );
        // System.out.println( mapUsr);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */