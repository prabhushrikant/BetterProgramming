package com.shrikant.problems.bitManipulation;

public class BinaryRepresentation {

    public String getBinaryUsingInbuilt(int n) {
        // byte bytes = (byte) n;
        // Format to 16 bits and take last 8 bits for byte representation
        // if you want 8 bits only, change 16 to 8 in the format string
        //return String.format("%16s", Integer.toBinaryString(bytes & 0xFF)).replaceAll(" ", "0");
        return String.format("%8s", Integer.toBinaryString(n & 0xFF)).replaceAll(" ", "0");
    }
}
