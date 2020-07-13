package com.example.Tester_Ignite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class TestBv2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        ArrayList<String> newExpression = new ArrayList<>();


        int counter = 1;
        while (expression != null && !expression.equals("")) {
            String[] symbol = expression.split(" ");

            newExpression.addAll(Arrays.asList(symbol));

            int j = 0;
            for (int i = 0; i < newExpression.size(); i++) {
                if (newExpression.get(i)!= null
                        && newExpression.get(i).equals("+") || newExpression.get(i).equals("-") || newExpression.get(i).equals("*")) {
                    if (j <= newExpression.size()-3
                            && newExpression.get(i+1).matches("-?\\d+")
                            && newExpression.get(i+2).matches("-?\\d+")) {
                        newExpression.set(i,calculationMethod(symbol[i], symbol[i+1], symbol[i+2]));
                        newExpression.remove(i+1);
                        newExpression.remove(i+1);
                    }
                }
                j++;
            }

            //Print new expression
        System.out.print("Case "+counter+": ");
        for (String s : newExpression) {
            System.out.print(s + " ");
        }
            System.out.println();
        counter++;
        expression = br.readLine();
        newExpression.clear();
        }
    }

    public static String calculationMethod(String mathSymbol, String numberOne, String numberTwo) {
        int one = Integer.parseInt(numberOne);
        int two = Integer.parseInt(numberTwo);
        int result = 0;
        switch (mathSymbol) {
            case "+":
                result = (one + two);
                break;
            case "-":
                result = (one - two);
                break;
            case "*":
                result = (one * two);
                break;
        }
        return Integer.toString(result);
    }
}
