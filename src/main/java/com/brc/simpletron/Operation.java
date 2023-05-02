package com.brc.simpletron;

import javax.annotation.processing.SupportedAnnotationTypes;


public final class Operation {

    protected static final int READ = 10;
    protected static final int WRITE = 11;
    protected static final int LOAD = 20;
    protected static final int STORE = 21;
    protected static final int ADD = 30;
    protected static final int SUB = 31;
    protected static final int DIV = 32;
    protected static final int IMUL = 33;
    protected static final int BRANCH = 40;
    protected static final int BRANCHNEG = 41;
    protected static final int BRANCHZERO = 42;
    protected static final int HALT = 43;
    
    public static int currentOp = READ;
}