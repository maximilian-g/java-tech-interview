package com.maximilian.interview.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There is an authentication system that works with authentication tokens.
 * For each session, the user will receive a new authentication token that
 * will expire timeToLive seconds after the currentTime. If the token is
 * renewed, the expiry time will be extended to expire timeToLive seconds
 * after the (potentially different) currentTime.
 * <p>
 * Implement the AuthenticationManager class:
 * <p>
 * AuthenticationManager(int timeToLive) constructs the AuthenticationManager
 * and sets the timeToLive.
 * generate(string tokenId, int currentTime) generates a new token with the
 * given tokenId at the given currentTime in seconds.
 * renew(string tokenId, int currentTime) renews the unexpired token with the
 * given tokenId at the given currentTime in seconds. If there are no unexpired
 * tokens with the given tokenId, the request is ignored, and nothing happens.
 * countUnexpiredTokens(int currentTime) returns the number of unexpired tokens
 * at the given currentTime.
 * Note that if a token expires at time t, and another action happens on time t
 * (renew or countUnexpiredTokens), the expiration takes place before the other actions.
 * <p>
 * Constraints:
 * <p>
 * 1 <= timeToLive <= 10^8
 * 1 <= currentTime <= 10^8
 * 1 <= tokenId.length <= 5
 * tokenId consists only of lowercase letters.
 * All calls to generate will contain unique values of tokenId.
 * The values of currentTime across all the function calls will be strictly increasing.
 * At most 2000 calls will be made to all functions combined.
 */
public class AuthenticationManager {

    private final int ttl;
    private final Map<String, Integer> expirationTimeByTokenId = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        expirationTimeByTokenId.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        Integer createdAt = expirationTimeByTokenId.get(tokenId);
        if (createdAt != null && currentTime < createdAt) {
            expirationTimeByTokenId.put(tokenId, currentTime + ttl);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        Set<String> tokenIds = new HashSet<>(expirationTimeByTokenId.keySet());
        for (String tokenId : tokenIds) {
            if (currentTime >= expirationTimeByTokenId.get(tokenId)) {
                expirationTimeByTokenId.remove(tokenId);
            }
        }
        return expirationTimeByTokenId.size();
    }

}
