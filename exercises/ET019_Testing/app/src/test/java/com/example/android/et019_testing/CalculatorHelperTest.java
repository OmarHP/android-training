package com.example.android.et019_testing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */
public class CalculatorHelperTest {

    @Test
    public void shouldSumNumbers() throws Exception {;
        assertEquals(50, CalculatorHelper.generateSum("50+0"));
        assertEquals(10, CalculatorHelper.generateSum("10+0"));
        assertEquals(9, CalculatorHelper.generateSum("5+4"));
        assertNotEquals(10, CalculatorHelper.generateSum("5+4"));
    }

    @Test
    public void whenMoreThanOnePlusSigns_shouldReturnError() throws Exception{
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum("12++1"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum("1+12+1"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum("+12+1+"));
    }

    @Test
    public void whenLetterInput_shouldReturnError() throws Exception {
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum("aaa+bbb"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum("2aa+1"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum("CABS"));
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum("1@1"));
    }

    @Test
    public void whenNullInput_shouldReturnError() throws Exception {
        assertEquals(Integer.MIN_VALUE, CalculatorHelper.generateSum(null));
    }
}