package com.csc;

public class CheeseAnalyzer {
    public static void main(String[] args) {
        CheeseReader cheeseReader = new CheeseReader("cheese_data.csv");
        CheeseList cheeseList = cheeseReader.readCheese();
        for(int i = 0; i < cheeseList.getNumberOfCheeses(); ++i) {
            System.out.println(cheeseList.getCheeseEntry(i).getCheeseId());
        }
    }
}

