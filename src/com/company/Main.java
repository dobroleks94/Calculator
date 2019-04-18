package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String > list = getPINs("369");
        System.out.println(list);
    }

    public static List<String> getPINs(String observed) {
        String[] zero = {"0", "8"};
        String[] one = {"1", "2", "4"};
        String[] two = {"1", "2", "3", "5"};
        String[] three = {"2", "3", "6"};
        String[] four = {"1", "4", "5", "7"};
        String[] five = {"2", "4", "5", "6", "8"};
        String[] six = {"3", "5", "6", "9"};
        String[] seven = {"4", "7", "8"};
        String[] eight = {"0", "5", "7", "8", "9"};
        String[] nine = {"6", "8", "9"};

        int caseCount = 1;

        HashMap<String, String[]> buttonCollection = new HashMap<>(
                Map.of("0", zero,
                        "1", one,
                        "2", two,
                        "3", three,
                        "4", four,
                        "5", five,
                        "6", six,
                        "7", seven,
                        "8", eight,
                        "9", nine
                ));

        for(int i = 0; i<observed.length(); i++){
            switch (observed.split("")[i]){
                case "0": caseCount*=zero.length; break;
                case "1": caseCount*=one.length; break;
                case "2": caseCount*=two.length; break;
                case "3": caseCount*=three.length; break;
                case "4": caseCount*=four.length; break;
                case "5": caseCount*=five.length; break;
                case "6": caseCount*=six.length; break;
                case "7": caseCount*=seven.length; break;
                case "8": caseCount*=eight.length; break;
                case "9": caseCount*=nine.length; break;
            }
        }
        List<StringBuilder> result = new ArrayList<>();
        List<String> newRes = new ArrayList<>();
        List<String[]> getNumArray = new ArrayList<>();
        for(int i = 0; i< caseCount; i++)
            result.add(new StringBuilder());

        for(String number:observed.split(""))
            getNumArray.add(buttonCollection.get(number));

        int koef = 1;
        int index = 0;
        int counter = 0;
        for(int j = 0; j<getNumArray.size(); j++) {
            koef *= getNumArray.get(j).length;
            while(index<caseCount) {
                for (int k = 0; k < getNumArray.get(j).length; k++) {
                    counter = caseCount / koef;
                    while (counter > 0) {
                        result.get(index).append(getNumArray.get(j)[k]);
                        counter--;
                        index++;
                    }
                }
            }
            index = 0;
        }

        for(StringBuilder sb : result){
            newRes.add(sb.toString());
        }
        return newRes;
    } // getPINs





}
