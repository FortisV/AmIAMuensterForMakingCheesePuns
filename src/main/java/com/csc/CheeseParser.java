package com.csc;

import java.util.ArrayList;

public class CheeseParser {
    String line;
    CheeseEntry cheeseEntry;
    ArrayList<String> tokens;
    CheeseParser() {}
    private void tokenize() {
        int begSubstr = 0;
        int i = 0;
        while(i < line.length()) {
            if(line.charAt(i) == '"') {
                begSubstr = i+1;
                while(line.charAt(i) != '"') {
                    ++i;
                }
                tokens.add(line.substring(begSubstr, i));
                i += 2;
                begSubstr = i;
            } else if(line.charAt(i) == ',') {
                tokens.add(line.substring(begSubstr, i));
                i++;
                begSubstr = i;
            } else {
                i++;
            }
        }
    }
    private void setCheeseEntry() {
        cheeseEntry.setCheeseId(tokens.get(0));
    }
    CheeseEntry parseCheese(String line) {
        this.line = line;
        cheeseEntry = new CheeseEntry();
        tokens = new ArrayList<String>();
        tokenize();
        setCheeseEntry();
        return cheeseEntry;
    }
}
