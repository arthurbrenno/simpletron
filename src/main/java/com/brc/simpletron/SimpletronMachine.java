package com.brc.simpletron;

import java.util.Scanner;

/**
 * This class represents a simple machine that implements the {@link Machine} interface.
 */
public class SimpletronMachine implements Machine{

    private static final Scanner sc = new Scanner(System.in);
    private Memory memory = new Memory();
    private Accumulator eax = new Accumulator();
    private int instructionCounter = 0; // memory position of current instruction
    private int instructionRegister; // memory position of next instruction 
    private int operation; //what is going to be done. // READ, LOAD, STORE, ADD
    private int operand; // the memory location. // 00, 05, 06, 22

    /**
     * Turns on the machine by displaying a welcome message,
     * getting instructions from the user, executing the instructions,
     * and dumping the state of the machine.
     */
    public void on() {
        welcome();
        getInstructions();
        execute();
        dump();
    }
    
    /**
     * Prompts the user to enter instructions one by one until
     * the user enters -99999 or the memory is full.
     * The instructions are validated and written to the memory.
     */
    private void getInstructions() {
        int instruction = 0;
        String temp;
        while (instruction != -99999 && memory.currentPos() < memory.capacity()) {
            System.out.printf("%02d ? ", memory.currentPos());
            temp = sc.next();
            try {
                instruction = Integer.parseInt(temp);
            } catch (NumberFormatException e) { continue; }
            if (getLength(instruction) == 4 || instruction == -99999) {
                memory.write(instruction);
            }
        }    
    }

    /**
     * Executes the instructions stored in the memory.
     */
    private void execute() {

        boolean executing = true;


        while (executing) {
            
            instructionRegister = memory.get(instructionCounter);
            operation = instructionRegister / 100;
            operand = instructionRegister % 100;
            
            switch (operation) {
                
                case Operation.READ:
                    while (true) {
                        System.out.print("Enter an integer: ");
                        String n = sc.next();
                        try {
                            memory.set(Integer.parseInt(n), operand);
                        }
                        catch(Exception e) {
                            continue;
                        }
                        break;
                    }
                    instructionCounter++;
                    break;
                
                case Operation.WRITE:
                    System.out.printf("[%d]", memory.get(operand));
                    instructionCounter++;
                    break;

                case Operation.LOAD:
                    eax.store(memory.get(operand));
                    instructionCounter++;
                    break;
                
                case Operation.STORE:
                    memory.set(eax.get(), operand);
                    instructionCounter++;
                    break;
                
                case Operation.ADD:
                case Operation.SUB:
                case Operation.IMUL:
                    eax.performOperation(operation, memory.get(operand));
                    instructionCounter++;
                    break;
                case Operation.DIV:
                    if (memory.get(operand) == 0) {
                        abort();
                    }
                    instructionCounter++;
                    break;

                
                case Operation.BRANCH: 
                    instructionCounter = operand;
                    break;
                
                case Operation.BRANCHNEG: 
                    if (eax.get() < 0) {
                        instructionCounter = operand; break;
                    }
                    instructionCounter++;
                    break;

                case Operation.BRANCHZERO: 
                    if (eax.get() == 0) {
                        instructionCounter = operand; break;
                    }
                    instructionCounter++;
                    break;
                    
                case -999:
                case Operation.HALT: executing = false; break;
                default: instructionCounter++;
            }
        }
    }


     /**
     * Returns the number of digits in the specified integer.
     * @param instruction the integer whose number of digits to return
     * @return the number of digits in the specified integer
     */

    private int getLength(int instruction) {
        int length = 0;
        while (instruction != 0) {
            instruction /= 10;
            length++;
        }
        return length;
    }

     /**
     * aborts the program
     */

    private void abort() {
        System.out.println("*** Attempt to divide by zero *** ");
        System.out.println("*** Simpletron execution abnormally terminated ***");
        System.exit(-1);
    }

     /**
     * turn the machine off
     */
    public void off() {
        System.out.println("\n\n*** Program execution ended *** ");
        System.out.println("*** Made by Arthur Brenno *** ");
        memory.free();
    }
     /**
     * displays welcome message
     */
    private void welcome() {
        clear();
        System.out.println("*** Welcome to Simpletron! ***");
        System.out.println("*** Please enter your program one instruction ***");
        System.out.println("*** (or data word) at a time. I will display ***");
        System.out.println("*** the location number and a question mark (?). ***");
        System.out.println("*** You then type the word for that location. ***");
        System.out.println("*** Type -99999 to stop entering your program. ***\n");
    }

     /**
     * prepare the program for executing
     */
    private void preExec() {
        clear();
        System.out.println("*** Program loading completed ***");
        System.out.println("*** Program execution begins ***");
    }

    /**
     * clears tge console on windows
     */
    private void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     /**
     * This method clears the screen and prints the values of the registers and memory.
     * The registers printed are: accumulator, instructionCounter, instructionRegister,
     * operationCode and operand. The memory is printed in a table format with 10 columns.
     */
    private void dump() {
        clear();
        System.out.println("REGISTERS");
        System.out.printf("accumulator             %+05d%n", eax.get());
        System.out.printf("instructionCounter      %02d%n", instructionCounter);
        System.out.printf("instructionRegister     %+04d%n", instructionRegister);
        System.out.printf("operationCode           %02d%n", operation);
        System.out.printf("operand                 %02d%n", operand);
        System.out.println();
        System.out.println("Memory:");
        for (int i = 0; i < memory.capacity() / 10; i++) {
            System.out.printf("       %4d", i);
        }
        System.out.println();
        for (int i = 0; i < memory.capacity(); i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.printf("%s      %+05d", (i % 10 == 0 || i == 0) ? i : "", memory.get(i));

        }
    }   

}
