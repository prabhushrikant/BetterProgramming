package com.shrikant.problems.bitManipulation;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BinaryRepresentationTest {

    BinaryRepresentation testObj;

    @BeforeEach
    public void init() {
        testObj = new BinaryRepresentation();
    }

    @ParameterizedTest
    @CsvSource({
        "5,00000101",
        "0,00000000",
        "255,11111111",
        "128,10000000",
        "127,01111111"
    })
    public void getBinaryUsingInbuilt(int n, String expectedBinary) {
        assertEquals(expectedBinary, testObj.getBinaryUsingInbuilt(n));
    }
}
