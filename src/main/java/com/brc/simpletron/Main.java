package com.brc.simpletron;
/**
 * This class contains the main method and creates an instance of the SimpletronMachine class.
 * The main method turns the SimpletronMachine on and off.
 */
public class Main {

    /**
     * An instance of the SimpletronMachine class.
     */
    private static SimpletronMachine simpletron = new SimpletronMachine();

    /**
     * The main method turns the SimpletronMachine on and off.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        simpletron.on();
        simpletron.off();
    }

}