package com.brc.simpletron;

/**
 * This class represents a memory component with a fixed size of 100 elements.
 */
public class Memory {
    
    private int[] mem = new int[100];
    private int currentPos = 0;

    /**
     * Writes an instruction to the memory at the current position.
     * If the current position is greater than or equal to 100, the instruction is not written.
     * @param instruction the instruction to be written
     */
    public void write(int instruction) {
        if (currentPos >= 100) {return;}
        mem[currentPos++] = instruction;
    }

    /**
     * Returns the element at the specified position in the memory.
     * @param pos the position of the element to return
     * @return the element at the specified position in the memory
     */
    public int get(int pos) {
        return mem[pos];
    }

    /**
     * Sets the element at the specified position in the memory to the specified value.
     * @param element the value to be set
     * @param pos the position of the element to set
     */
    public void set(int element, int pos) {
        mem[pos] = element;
    }

    /**
     * Frees all elements in the memory by setting them to 0 and resets the current position to 0.
     */
    public void free() {
        for (int i = 0; i < mem.length; i++) {
            mem[i] = 0;
        }
        currentPos = 0;
    }

    /**
     * Returns the current position in the memory.
     * @return the current position in the memory
     */
    public int currentPos() {
        return this.currentPos;
    }

    /**
     * Returns the capacity of the memory.
     * @return the capacity of the memory
     */
    public int capacity() {
        return mem.length;
    }
}