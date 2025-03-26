package com.csc;

import java.util.ArrayList;

public class CheeseList {
    private ArrayList<CheeseEntry> cheeseEntries;
    CheeseList() {
        cheeseEntries = new ArrayList<CheeseEntry>();
    }
    void addCheese(CheeseEntry cheeseEntry) {
        cheeseEntries.add(cheeseEntry);
    }
    CheeseEntry getCheeseEntry(int position) {
        return cheeseEntries.get(position);
    }
    int getNumberOfCheeses() {
        return cheeseEntries.size();
    }
}
