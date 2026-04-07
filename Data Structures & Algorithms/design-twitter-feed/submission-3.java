class Twitter {

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, List<Tweet>> userTweets;
    Map<Integer, List<Integer>> userFollowees;
    int time;

    public Twitter() {
        this.userTweets = new HashMap<>();
        this.userFollowees = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets
            .computeIfAbsent(userId, v -> new ArrayList<>())
            .add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<Tweet> allTweets = new ArrayList<>();

        if(userTweets.containsKey(userId)){
            allTweets.addAll(userTweets.get(userId));
        }

        List<Integer> followees = userFollowees.getOrDefault(userId, new ArrayList<>());

        for(int f : followees){
            allTweets.addAll(userTweets.getOrDefault(f, new ArrayList<>()));
        }

        // sort by latest tweet
        allTweets.sort((a,b) -> b.time - a.time);

        List<Integer> feed = new ArrayList<>();

        for(int i = 0; i < Math.min(10, allTweets.size()); i++){
            feed.add(allTweets.get(i).id);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;

        List<Integer> followees =
            userFollowees.getOrDefault(followerId, new ArrayList<>());

        if(!followees.contains(followeeId)){
            followees.add(followeeId);
        }

        userFollowees.put(followerId, followees);
    }
    
    public void unfollow(int followerId, int followeeId) {

        List<Integer> followees = userFollowees.get(followerId);

        if(followees != null){
            followees.remove(Integer.valueOf(followeeId));
        }
    }
}