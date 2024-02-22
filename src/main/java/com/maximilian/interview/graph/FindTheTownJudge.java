package com.maximilian.interview.graph;

/**
 * In a town, there are n people labeled from 1 to n.
 * There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * 1 - The town judge trusts nobody.
 * 2 - Everybody (except for the town judge) trusts the town judge.
 * 3 - There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing
 * that the person labeled ai trusts the person labeled bi.
 * If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 * <p>
 * Return the label of the town judge if the town judge exists
 * and can be identified, or return -1 otherwise.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 */
public class FindTheTownJudge {

    public static int findJudge(int n, int[][] trust) {
        int[] countTrusts = new int[n + 1];
        for (int[] trustValue : trust) {
            countTrusts[trustValue[0]] = -1;
            if (countTrusts[trustValue[1]] == -1) {
                continue;
            }
            countTrusts[trustValue[1]]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (countTrusts[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

}
