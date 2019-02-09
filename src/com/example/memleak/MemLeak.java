package com.example.memleak;

import org.mockito.Mockito;

import java.util.stream.IntStream;

class MemLeak {
    private static final int LARGE_ARRAY = 1 << 10;

    private final int mNum;

    MemLeak(int num) {
        mNum = num;
    }

    void run() {
        IntStream.range(0, mNum).forEach(this::runOnce);
    }

    private void runOnce(int i) {
        final BigClass big = Mockito.mock(BigClass.class);
        big.mArray = new int[LARGE_ARRAY];
        final SmallClass small = Mockito.mock(SmallClass.class);

        // Comment out any one line below would stop mem leak.
        big.accept(small);
        small.accept(big);
    }
}
