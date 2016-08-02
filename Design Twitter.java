public class Twitter {
    
    private class Tweet {
        int timestamp;
        int tweetId;
        
        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    
    int timestamp;
    Map<Integer, HashSet<Integer>> userMap = new HashMap<>();
    Map<Integer, List<Tweet>> tweetMap = new HashMap<>();
    
    /** Initialize your data structure here. */
    public Twitter() {
        timestamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<Tweet>());
        }
        Tweet t = new Tweet(tweetId, timestamp++);
        List<Tweet> list = tweetMap.get(userId);
        list.add(t);
        tweetMap.put(userId, list);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(new Comparator<Tweet>() {
            public int compare (Tweet t1, Tweet t2) {
                return t2.timestamp - t1.timestamp;
            }
        });
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new HashSet<Integer>());
        }
        HashSet<Integer> set = userMap.get(userId);
        set.add(userId);
        for (int id : set) {
            if (tweetMap.containsKey(id)) {
                pq.addAll(tweetMap.get(id));
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<Integer>(pq.size());
        while (!pq.isEmpty() && count < 10) {
            list.add(pq.poll().tweetId);
            count++;
        }
        return list;
    }
    
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new HashSet<Integer>());
        }
        HashSet<Integer> set = userMap.get(followerId);
        set.add(followeeId);
        userMap.put(followerId, set);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId) && userMap.get(followerId).contains(followeeId)) {
            userMap.get(followerId).remove(followeeId);
        }
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