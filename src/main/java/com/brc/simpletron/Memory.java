package com.brc.simpletron;

public class Memory {
    
    private int[] mem = new int[100];
    private int currentPos = 0;


    public void write(int instruction) {
        if (currentPos >= 100) {return;}
        mem[currentPos++] = instruction;
    }

    public int get(int pos) {
        return mem[pos];
    }

    public void set(int element, int pos) {
        mem[pos] = element;
    }

    public void free() {
        for (int i = 0; i < mem.length; i++) {
            mem[i] = 0;
        }
        currentPos = 0;
    }

    public int currentPos() {
        return this.currentPos;
    }

    public int capacity() {
        return mem.length;
    }


}
