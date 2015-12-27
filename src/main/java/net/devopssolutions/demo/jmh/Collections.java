package net.devopssolutions.demo.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collections {

    public static final int LIST_SIZE = 1_000_000;
    public static final int LIST_SIZE_DIV_2 = LIST_SIZE / 2;
    public static final int NUMBER_OF_ADDITIONS = 100;

    @State(Scope.Benchmark)
    public static class StateArrayList {

        List<Integer> list;

        @Setup(Level.Iteration)
        public void init() {
            list = new ArrayList<>(LIST_SIZE);
            for (int i = 0; i < LIST_SIZE; i++) {
                list.add(i);
            }
        }

        @TearDown(Level.Iteration)
        public void end() {
            list.clear();
            list = null;
        }
    }

    @State(Scope.Benchmark)
    public static class StateLinkedList {

        List<Integer> list;

        @Setup(Level.Iteration)
        public void init() {
            list = new LinkedList<>();
            for (int i = 0; i < LIST_SIZE; i++) {
                list.add(i);
            }
        }

        @TearDown(Level.Iteration)
        public void end() {
            list.clear();
            list = null;
        }
    }

    @Benchmark
    public void addLinkedList(StateLinkedList state) {
        for (int i = 0; i < NUMBER_OF_ADDITIONS; i++) {
            state.list.add(LIST_SIZE_DIV_2, -999);
        }
    }

    @Benchmark
    public void addArrayList(StateArrayList state) {
        for (int i = 0; i < NUMBER_OF_ADDITIONS; i++) {
            state.list.add(LIST_SIZE_DIV_2, -999);
        }
    }

}
