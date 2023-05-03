package com.brc.simpletron;

public class Accumulator {

    private int eax = 0;

    public void store(int value) {
        eax = value;
    }

    public int get() {
        return eax;
    }

    public void performOperation(int operationCode, int value) {
        switch (operationCode) {
            case Operation.ADD: eax += value; break;
            case Operation.SUB: eax -= value; break;
            case Operation.DIV: eax /= value; break;
            case Operation.IMUL: eax *= value; break;
            case Operation.LOAD: eax = value; break;
        }
    }

    public void reset() {
        eax = 0;
    }

}