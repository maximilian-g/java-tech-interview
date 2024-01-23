package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TwitterTest {

    @Test
    void twitterTest() {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        List<Integer> expected = List.of(5);
        List<Integer> actual = twitter.getNewsFeed(1);
        Assertions.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }

        // User 1 follows user 2.
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        actual = twitter.getNewsFeed(1);
        expected = List.of(6, 5);
        Assertions.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);
        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        actual = twitter.getNewsFeed(1);
        expected = List.of(5);
        Assertions.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i));
        }
    }

}