package com.example.android.et019_testing;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */

public class CalculatorHelper {

    public static int generateSum(String expression){
        if(expression == null)
            return Integer.MIN_VALUE;

        String[] operators = expression.split("\\+");
        if(operators.length != 2){
            return Integer.MIN_VALUE;
        }
        String num1 = operators[0];
        String num2 = operators[1];
        if(num1.matches("[0-9]+") && num2.matches("[0-9]+")){
            int n2 = Integer.valueOf(operators[1]);
            int n1 = Integer.valueOf(operators[0]);
            return n1 + n2;
        }else{
            return Integer.MIN_VALUE;
        }


    }

}
