package com.csc;

import java.util.ArrayList;

public class CheeseAnalyzer {
    private CheeseList cheeseList;
    int getNumberOfCheesesPasteurized() {
        int cheesesPasteurized = 0;
        for(int i = 1; i < cheeseList.getNumberOfCheeses(); ++i) {
            if(cheeseList.getCheeseEntry(i).getMilkTreatmentTypeEn().equals("Pasteurized")) {
                cheesesPasteurized++;
            }
        }
        return cheesesPasteurized;
    }
    int getNumberOfCheesesRaw() {
        int cheesesRaw = 0;
        for(int i = 1; i < cheeseList.getNumberOfCheeses(); ++i) {
            if(cheeseList.getCheeseEntry(i).getMilkTreatmentTypeEn().equals("Raw Milk")) {
                cheesesRaw++;
            }
        }
        return cheesesRaw;
    }
    int getNumberOfOrganicCheeseGreaterThanMoisture(double moistureBound) {
        int numberOfCheese = 0;
        for(int i = 1; i < cheeseList.getNumberOfCheeses(); ++i) {
            CheeseEntry currCheese = cheeseList.getCheeseEntry(i);
            boolean organic = currCheese.getOrganic().equals("1");
            double moisture = 0;
            if(!currCheese.getMoisturePercent().isBlank()) {
                moisture = Double.parseDouble(currCheese.getMoisturePercent());
                if(organic && moisture > moistureBound) {
                    numberOfCheese++;
                }
            }
        }
        return numberOfCheese;
    }
    int getNumberOfLacticCheese() {
        int cheesesLactic = 0;
        for(int i = 1; i < cheeseList.getNumberOfCheeses(); ++i) {
            if(cheeseList.getCheeseEntry(i).getFlavourEn().toLowerCase().contains("lactic")) {
                cheesesLactic++;
            }
        }
        return cheesesLactic;
    }
    double getAverageMoistureOfCheese() {
        double sum = 0;
        double count = 0;
        for(int i = 1; i < cheeseList.getNumberOfCheeses(); i++) {
            if(!cheeseList.getCheeseEntry(i).getMoisturePercent().isEmpty()) {
                sum += Double.parseDouble(cheeseList.getCheeseEntry(i).getMoisturePercent());
                count++;
            }
        }
        return sum / count;
    }
    ArrayList<Integer> getMissingIDS() {
        ArrayList<Integer> missingIDS = new ArrayList<>();
        int lastID = 0;
        int currID = 0;
        for(int i = 1; i < cheeseList.getNumberOfCheeses(); i++) {
            currID = Integer.parseInt(cheeseList.getCheeseEntry(i).getCheeseId());
            for(int j = lastID + 1; j < currID; ++j) {
                missingIDS.add(j);
            }
            lastID = currID;
        }
        return missingIDS;
    }
    String getMostCommonMilkType() {
        int cowCount = 0;
        int eweCount = 0;
        int goatCount = 0;
        int buffaloCount = 0;

        for(int i = 1; i < cheeseList.getNumberOfCheeses(); ++i) {
            if(cheeseList.getCheeseEntry(i).getMilkTypeEn().contains("Cow")) {
                cowCount++;
            }
            if(cheeseList.getCheeseEntry(i).getMilkTypeEn().contains("Ewe")) {
                eweCount++;
            }
            if(cheeseList.getCheeseEntry(i).getMilkTypeEn().contains("Goat")) {
                goatCount++;
            }
            if(cheeseList.getCheeseEntry(i).getMilkTypeEn().contains("Buffalo")) {
                buffaloCount++;
            }
        }
        int highest = Math.max(Math.max(Math.max(cowCount, eweCount), goatCount), buffaloCount);
        if(highest == cowCount) {
            return "Cow";
        } else if(highest == eweCount) {
            return "Ewe";
        } else if(highest == goatCount) {
            return "Goat";
        } else {
            return "Buffalo";
        }
    }
    CheeseAnalyzer(CheeseList cheeseList) {
        this.cheeseList = cheeseList;
    }
}

