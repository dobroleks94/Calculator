package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(evaluate("2 + 2 * 2"));
    }

    public static String operations (Stack<String> stck, double fst, double scnd, int i, char operationType){
        String strNum = "";
        fst = Double.parseDouble(stck.get(i-1));
        scnd = Double.parseDouble(stck.get(i+1));
        stck.removeElementAt(i+1);
        stck.removeElementAt(i-1);
        switch (operationType){
            case '/':
                strNum = String.valueOf(fst/scnd);
                break;
            case '*':
                strNum = String.valueOf(fst*scnd);
                break;
            case '-':
                strNum = String.valueOf(fst-scnd);
                break;
            case '+':
                strNum = String.valueOf(fst+scnd);
                break;
        }
        stck.add(i, strNum);
        stck.removeElementAt(i-1);

        return strNum;
    }

    public static Double evaluate(String expression) {
        if(!expression.contains(" "))
            return Double.parseDouble(expression);
        String[] numbers = expression.split(" ");
        Stack<String> stck = new Stack<>();
        for(String i : numbers)
            stck.add(i);
        String strNum = "";
        double fst = 0.0;
        double scnd = 0.0;
        for(int i = 0; i< stck.size(); i++){
            switch (stck.get(i)){
                case "/":
                    strNum = operations(stck, fst, scnd, i, '/');
                    i = 0;
                    break;
                case "*":
                    strNum = operations(stck, fst, scnd, i, '*');
                    i = 0;
                    break;
                default:
                    continue;
            }
        }
        for(int i = 0; i< stck.size(); i++){
            switch (stck.get(i)){
                case "+":
                    strNum = operations(stck, fst, scnd, i, '+');
                    expression = String.valueOf(stck);
                    i = 0;
                    break;
                case "-":
                    strNum = operations(stck, fst, scnd, i, '-');
                    i = 0;
                    break;
                default:
                    continue;
            }
        }
        return Double.parseDouble(strNum);
    }





}
