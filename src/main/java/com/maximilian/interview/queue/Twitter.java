package com.maximilian.interview.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
 * <p>
 * Implement the Twitter class:
 * <p>
 * Twitter() Initializes your twitter object.
 * <p>
 * void postTweet(int userId, int tweetId)
 * Composes a new tweet with ID tweetId by the user userId.
 * Each call to this function will be made with a unique tweetId.
 * <p>
 * List<Integer> getNewsFeed(int userId)
 * Retrieves the 10 most recent tweet IDs in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user themself.
 * Tweets must be ordered from most recent to least recent.
 * <p>
 * void follow(int followerId, int followeeId)
 * The user with ID followerId started following the user with ID followeeId.
 * <p>
 * void unfollow(int followerId, int followeeId)
 * The user with ID followerId started unfollowing the user with ID followeeId.
 * <p>
 * Constraints:
 * <p>
 * 1 <= userId, followerId, followeeId <= 500
 * 0 <= tweetId <= 10^4
 * All the tweets have unique IDs.
 * At most 3 * 10^4 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
 */
public class Twitter {

    private final AtomicLong sequenceLong = new AtomicLong();
    private final Map<Integer, List<Tweet>> tweetsByUser = new HashMap<>();
    // who user follows by its id
    private final Map<Integer, Set<Integer>> followeesByUser = new HashMap<>();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!tweetsByUser.containsKey(userId)) {
            tweetsByUser.put(userId, new LinkedList<>());
        }
        tweetsByUser.get(userId).add(new Tweet(tweetId, sequenceLong.getAndIncrement()));
    }

    public void follow(int followerId, int followeeId) {
        if (!followeesByUser.containsKey(followerId)) {
            followeesByUser.put(followerId, new HashSet<>());
        }
        followeesByUser.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!followeesByUser.containsKey(followerId)) {
            return;
        }
        followeesByUser.get(followerId).remove(followeeId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followees = new ArrayList<>(followeesByUser.getOrDefault(userId, new HashSet<>()));
        followees.add(userId);

        List<Integer> result = new ArrayList<>();
        Queue<Tweet> tweets = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer followee : followees) {
            if (!tweetsByUser.containsKey(followee)) {
                continue;
            }
            tweets.addAll(tweetsByUser.get(followee));
        }

        for (int i = 0; i < 10 && !tweets.isEmpty(); i++) {
            result.add(tweets.poll().tweetId);
        }

        return result;
    }

    private record Tweet(int tweetId, long sequenceId) implements Comparable<Tweet> {

        @Override
        public int compareTo(Tweet o) {
            return Long.compare(sequenceId, o.sequenceId);
        }

    }

}
