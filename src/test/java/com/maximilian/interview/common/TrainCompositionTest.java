package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

class TrainCompositionTest {

    @Test
    void addLeft() {
        TrainComposition composition = new TrainComposition();

        int wagonId = 15;
        composition.addLeft(wagonId);

        Assertions.assertTrue(composition.currentComposition().contains(wagonId));
    }

    @Test
    void addRight() {
        TrainComposition composition = new TrainComposition();

        composition.addRight(15);
        composition.addRight(30);

        List<Integer> wagons = composition.currentComposition();
        Assertions.assertSame(wagons.get(wagons.size() - 1), 30);
    }

    @Test
    void removeLeft() {
        TrainComposition composition = new TrainComposition();

        composition.addLeft(15);
        composition.addLeft(30);
        composition.addLeft(45);

        Assertions.assertSame(composition.removeLeft(), 45);
        Assertions.assertSame(composition.removeLeft(), 30);
        Assertions.assertSame(composition.removeLeft(), 15);
        Assertions.assertThrows(NoSuchElementException.class, composition::removeLeft);
    }

    @Test
    void removeRight() {
        TrainComposition composition = new TrainComposition();

        composition.addLeft(15);
        composition.addLeft(30);
        composition.addLeft(45);

        Assertions.assertSame(composition.removeRight(), 15);
        Assertions.assertSame(composition.removeRight(), 30);
        Assertions.assertSame(composition.removeRight(), 45);
        Assertions.assertThrows(NoSuchElementException.class, composition::removeRight);
    }

    @Test
    void currentComposition() {
        TrainComposition composition = new TrainComposition();

        Assertions.assertTrue(composition.currentComposition().isEmpty());

        composition.addLeft(15);
        composition.addLeft(30);
        composition.addLeft(45);

        List<Integer> integers = List.of(45, 30, 15);
        Assertions.assertIterableEquals(integers, composition.currentComposition());
    }

}