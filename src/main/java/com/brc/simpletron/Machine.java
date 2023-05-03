package com.brc.simpletron;

/**
 * This interface defines the methods that a machine must implement.
 */
public interface Machine {
    
    /**
     * Turns the machine on.
     */
    public void on();
    
    /**
     * Turns the machine off.
     */
    public void off();
}