package com.maximilian.interview.queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Design a system that manages the reservation state of n seats that are numbered from 1 to n.
 * <a href="https://leetcode.com/problems/seat-reservation-manager/description/">
 * Link to a task</a>
 * <p>
 * Implement the SeatManager class:
 * <p>
 * SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n.
 * All seats are initially available.
 * <p>
 * int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns it's number.
 * <p>
 * void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 * 1 <= seatNumber <= n
 * For each call to reserve, it is guaranteed that there will be at least one unreserved seat.
 * For each call to unreserve, it is guaranteed that seatNumber will be reserved.
 * At most 10^5 calls in total will be made to reserve and unreserve.
 */
public class SeatReservationManager {

    private final Queue<Integer> freeSeatsQueue = new PriorityQueue<>();
    private final Set<Integer> reservedSeats = new HashSet<>();

    // question to leetcode author, why do we need "int n"
    // when it may not even be used to complete task with given constraints?
    public SeatReservationManager(int n) {
        freeSeatsQueue.add(1);
    }

    public int reserve() {
        int reserved = freeSeatsQueue.poll();
        if (freeSeatsQueue.isEmpty()) {
            int tempReserved = reserved + 1;
            while (reservedSeats.contains(tempReserved)) {
                tempReserved++;
            }
            freeSeatsQueue.add(tempReserved);
        }
        reservedSeats.add(reserved);
        return reserved;
    }

    public void unreserve(int seatNumber) {
        freeSeatsQueue.add(seatNumber);
        reservedSeats.remove(seatNumber);
    }

}
