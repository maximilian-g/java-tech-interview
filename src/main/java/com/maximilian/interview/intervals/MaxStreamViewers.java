package com.maximilian.interview.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Every viewer connected to the stream in some moment t_in,
 * disconnected in moment t_out, time is measured in seconds from 0 to 10^9,
 * <p>
 * array of pairs (t_in, t_out) is given, array length from 0 to 10^6
 * return max number of viewers that viewed stream at the same time
 */
public class MaxStreamViewers {

    public static int maxViewers(int[][] intervals) {
        Objects.requireNonNull(intervals, "Given intervals can not be null");
        List<ViewAction> actionList = new ArrayList<>(intervals.length * 2);
        for (int[] viewInterval : intervals) {
            actionList.add(new ViewAction(viewInterval[0], EventType.START));
            actionList.add(new ViewAction(viewInterval[1], EventType.END));
        }

        Collections.sort(actionList);

        int maxViewers = 0;
        int maxViewersValue = 0;

        for (ViewAction viewAction : actionList) {
            maxViewersValue += viewAction.event == EventType.START ? 1 : -1;
            maxViewers = Math.max(maxViewers, maxViewersValue);
        }

        return maxViewers;
    }

    private record ViewAction(int eventTime, EventType event) implements Comparable<ViewAction> {

        @Override
        public int compareTo(ViewAction o) {
            int res = Integer.compare(eventTime, o.eventTime);
            // START events which have same eventTime must have higher priority than END events
            if (res == 0 && event == EventType.START) {
                res = -1;
            }
            return res;
        }
    }

    private enum EventType {
        START,
        END
    }

}
