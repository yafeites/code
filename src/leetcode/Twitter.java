package leetcode;

import com.sun.org.glassfish.gmbal.Description;

import java.util.*;

/**
 * @program: code
 * @description:LeetCode_355
 * @author: Mr.Wang
 * @create: 2020-04-13 20:03
 **/

class Twitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);
    }

    class details
    {
        int userId;
        int tweetId;

        public details(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
    private Map<Integer, Set<Integer>>map;
    private List<details>list;
    /** Initialize your data structure here. */
    public Twitter() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }


    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        list.add(new details(userId,tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */

    public List<Integer> getNewsFeed(int userId) {
        Set userLikeSet=map.get(userId);
        List<Integer>res=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--)
        {
            details twitterDetail=list.get(i);
            if((userLikeSet!=null&&userLikeSet.contains(twitterDetail.userId))||userId==twitterDetail.userId)
            {
                res.add(twitterDetail.tweetId);
            }
            if(res.size()==10)
            {
                break;
            }
        }
        return res;
    }


        public void follow(int followerId, int followeeId) {
                Set userLikeSet=map.get(followerId);
                if(userLikeSet==null)
                {
                    map.put(followerId,new HashSet<Integer>());
                    userLikeSet=map.get(followerId);
                }
                userLikeSet.add(followeeId);
        }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set userLikeSet=map.get(followerId);
        if(userLikeSet!=null)
        {
            userLikeSet.remove(followeeId);
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
