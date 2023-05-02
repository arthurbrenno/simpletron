package com.brc.simpletron;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InstructionHandler {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInput() {
        int instruction = -1;
        do {
            try {
                instruction = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                continue;
            }
        } while (getLength(instruction) != 4 && instruction != -99999);
        
        return instruction;
    }

    public static int getLength(int instruction) {
        int length = 0;
        while (instruction != 0) {
            instruction /= 10;
            length++;
        }
        return length;
    }

    public static int getOpCode(int instruction) {
        return instruction/100;
    }

    public static int getOperand(int instruction) {
        return instruction % 100;
    }

}
