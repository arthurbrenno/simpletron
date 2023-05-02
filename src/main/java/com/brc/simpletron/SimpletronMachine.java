package com.brc.simpletron;


public class SimpletronMachine implements Machine{

    private Memory memory = new Memory();
    private Accumulator eax = new Accumulator();


    public void on() {
        getInstructions();
    }
    
    private void getInstructions() {
        int instruction = 0;
        do {
            System.out.printf("%02d ? ", memory.currentPos());
            instruction = InstructionHandler.getInput();
            memory.write(instruction);
        } while (instruction != -99999 && memory.currentPos() < memory.capacity());
    }
    
    private void execute() {
        int instruction = -1;
        int operation = -1; //what is going to be done.
        int operand = -1; // the memory location.

        for (int i = 0; i < memory.capacity(); i++) {
            instruction = memory.get(i);
            operation = InstructionHandler.getOpCode(instruction);
            operand = InstructionHandler.getOperand(instruction);
            
        }
    }
    
    public void off() {
        memory.free();
    }

    


}
