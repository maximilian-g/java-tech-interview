package com.maximilian.interview.list;


import java.util.LinkedList;
import java.util.List;

/**
 * You have a browser of one tab where you start on the homepage
 * and you can visit another url, get back in the history number
 * of steps or move forward in the history number of steps.
 * <p>
 * Implement the BrowserHistory class:
 * <p>
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history.
 * If you can only return x steps in the history and steps > x,
 * you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history.
 * If you can only forward x steps in the history and steps > x,
 * you will forward only x steps. Return the current url after forwarding in history at most steps.
 * <p>
 * Constraints:
 * <p>
 * 1 <= homepage.length <= 20
 * 1 <= url.length <= 20
 * 1 <= steps <= 100
 * homepage and url consist of  '.' or lower case English letters.
 * At most 5000 calls will be made to visit, back, and forward.
 */
public class BrowserHistory {

    private final List<String> history = new LinkedList<>();
    private int currentIndex = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        while (history.size() - 1 != currentIndex) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        int localIndex = currentIndex - steps;
        localIndex = Math.max(0, localIndex);
        currentIndex = localIndex;
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        int localIndex = currentIndex + steps;
        localIndex = Math.min(history.size() - 1, localIndex);
        currentIndex = localIndex;
        return history.get(currentIndex);
    }

}
