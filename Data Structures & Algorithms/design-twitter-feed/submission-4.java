class Twitter {

    private int timestamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    Map<Integer, Tweet> tweetMap = new HashMap<>();
    Map<Integer, Set<Integer>> followMap = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a,b) -> Integer.compare(b.time, a.time));

        for(int followee : followMap.get(userId)){
            Tweet tweet = tweetMap.get(followee);
            if(tweet != null){
                maxHeap.add(tweet);
            }
        }

        while(!maxHeap.isEmpty() && res.size() < 10){
            Tweet tweet = maxHeap.poll();
            res.add(tweet.id);

            if(tweet.next != null){
                maxHeap.add(tweet.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if(followerId == followeeId) return;

        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}