package com.brc.simpletron;

/**
 * This class defines a set of constants representing operation codes for a machine.
 */
public abstract class Operation {

    /** Operation code for the READ operation. */
    protected static final int READ = 10;
    
    /** Operation code for the WRITE operation. */
    protected static final int WRITE = 11;
    
    /** Operation code for the LOAD operation. */
    protected static final int LOAD = 20;
    
    /** Operation code for the STORE operation. */
    protected static final int STORE = 21;
    
    /** Operation code for the ADD operation. */
    protected static final int ADD = 30;
    
    /** Operation code for the SUB operation. */
    protected static final int SUB = 31;
    
    /** Operation code for the DIV operation. */
    protected static final int DIV = 32;
    
    /** Operation code for the IMUL operation. */
    protected static final int IMUL = 33;
    
    /** Operation code for the BRANCH operation. */
    protected static final int BRANCH = 40;
    
    /** Operation code for the BRANCHNEG operation. */
    protected static final int BRANCHNEG = 41;
    
    /** Operation code for the BRANCHZERO operation. */
    protected static final int BRANCHZERO = 42;
    
    /** Operation code for the HALT operation. */
    protected static final int HALT = 43;
}