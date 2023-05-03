package com.brc.simpletron;

/**
 * This class represents an accumulator component with a single register {@code eax}.
 */
public class Accumulator {

    private int eax = 0;

    /**
     * Stores the specified value in the {@code eax} register.
     * @param value the value to be stored
     */
    public void store(int value) {
        eax = value;
    }

    /**
     * Returns the value of the {@code eax} register.
     * @return the value of the {@code eax} register
     */
    public int get() {
        return eax;
    }

    /**
     * Performs the specified arithmetic operation on the {@code eax} register using the specified value.
     * @param operationCode the operation code of the arithmetic operation to perform
     * @param value the value to use in the arithmetic operation
     */
    public void performOperation(int operationCode, int value) {
        switch (operationCode) {
            case Operation.ADD: eax += value; break;
            case Operation.SUB: eax -= value; break;
            case Operation.DIV: eax /= value; break;
            case Operation.IMUL: eax *= value; break;
            case Operation.LOAD: eax = value; break;
        }
    }

    /**
     * Resets the {@code eax} register to 0.
     */
    public void reset() {
        eax = 0;
    }
}