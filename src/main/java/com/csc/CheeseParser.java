package com.csc;

import java.util.ArrayList;

public class CheeseParser {
    private String line;
    private int pos;
    private CheeseEntry cheeseEntry;
    private ArrayList<String> tokens;
    CheeseParser() {}
    private String getNextToken() {
        int begSubstr = pos;
        boolean hasQuotes = line.charAt(pos) == '"';
        boolean inQuotes = false;
        boolean repeat = true;
        while(repeat) {
            if(line.length() <= pos) {
                repeat = false;
            } else if(line.charAt(pos) == '"') {
                inQuotes = !inQuotes;
            } else if(line.charAt(pos) == ',' && !inQuotes) {
                repeat = false;
            }
            pos++;
        }
        if(hasQuotes) {
            return line.substring(begSubstr + 1, pos - 2);
        } else {
            return line.substring(begSubstr, pos - 1);
        }
    }
    private void tokenize() {
        while(pos < line.length()) {
            tokens.add(getNextToken());
        }
    }
    private void setCheeseEntry() {
        cheeseEntry.setCheeseId(tokens.get(0));
        cheeseEntry.setManufacturerProvCode(tokens.get(1));
        cheeseEntry.setManufacturingTypeEn(tokens.get(2));
        cheeseEntry.setMoisturePercent(tokens.get(3));
        cheeseEntry.setFlavourEn(tokens.get(4));
        cheeseEntry.setCharacteristicsEn(tokens.get(5));
        cheeseEntry.setOrganic(tokens.get(6));
        cheeseEntry.setCategoryTypeEn(tokens.get(7));
        cheeseEntry.setMilkTypeEn(tokens.get(8));
        cheeseEntry.setMilkTreatmentTypeEn(tokens.get(9));
        cheeseEntry.setRindTypeEn(tokens.get(10));
        cheeseEntry.setCheeseName(tokens.get(11));
        cheeseEntry.setFatLevel(tokens.get(12));
    }
    CheeseEntry parseCheese(String line) {
        this.line = line;
        pos = 0;
        cheeseEntry = new CheeseEntry();
        tokens = new ArrayList<String>();
        tokenize();
        setCheeseEntry();
        return cheeseEntry;
    }
}
