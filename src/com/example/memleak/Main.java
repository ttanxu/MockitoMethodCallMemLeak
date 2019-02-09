package com.example.memleak;

public class Main {

    public static void main(String[] args) {
        System.out.println("Heap size " + Runtime.getRuntime().totalMemory());

        final MemLeak leak = new MemLeak(100);
        leak.run();
    }
}
