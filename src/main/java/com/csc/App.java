package com.csc;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        CheeseReader cheeseReader = new CheeseReader("cheese_data.csv");
        CheeseList cheeseList = cheeseReader.readCheese();
        CheeseAnalyzer cheeseAnalyzer = new CheeseAnalyzer(cheeseList);
        CheeseWriter cheeseWriter = new CheeseWriter();
        CheeseWriterCSV cheeseWriterCSV = new CheeseWriterCSV();

        cheeseWriter.openFile("output.txt");
        cheeseWriter.println("Number of pasteurized cheeses: " + cheeseAnalyzer.getNumberOfCheesesPasteurized());
        cheeseWriter.println("Number of raw milk cheeses: " + cheeseAnalyzer.getNumberOfCheesesRaw());
        cheeseWriter.println("Number of organic cheeses with moisture > 41.0%: " + cheeseAnalyzer.getNumberOfOrganicCheeseGreaterThanMoisture(41.0));
        cheeseWriter.println("Most common type of milk cheese is made from: " + cheeseAnalyzer.getMostCommonMilkType());
        cheeseWriter.println("Number of lactic cheeses: " + cheeseAnalyzer.getNumberOfLacticCheese());
        cheeseWriter.println("Average moisture of cheeses: " + cheeseAnalyzer.getAverageMoistureOfCheese() + "%");
        cheeseWriter.close();

        cheeseWriter.openFile("missing_ids.txt");
        ArrayList<Integer> missingIDS = cheeseAnalyzer.getMissingIDS();
        for(int i = 0; i < missingIDS.size(); ++i) {
            cheeseWriter.println(missingIDS.get(i).toString());
        }
        cheeseWriter.close();

        cheeseWriterCSV.openFile("cheese_without_headers.csv");
        for(int i = 1; i < cheeseList.getNumberOfCheeses(); ++i) {
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getCheeseId());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getManufacturerProvCode());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getManufacturingTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getMoisturePercent());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getFlavourEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getCharacteristicsEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getOrganic());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getCategoryTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getMilkTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getMilkTreatmentTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getRindTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getCheeseName());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getFatLevel());
            cheeseWriterCSV.newLine();
        }
        cheeseWriterCSV.close();

        cheeseWriterCSV.openFile("cheese_without_ids.csv");
        for(int i = 0; i < cheeseList.getNumberOfCheeses(); ++i) {
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getManufacturerProvCode());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getManufacturingTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getMoisturePercent());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getFlavourEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getCharacteristicsEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getOrganic());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getCategoryTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getMilkTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getMilkTreatmentTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getRindTypeEn());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getCheeseName());
            cheeseWriterCSV.addValue(cheeseList.getCheeseEntry(i).getFatLevel());
            cheeseWriterCSV.newLine();
        }
        cheeseWriterCSV.close();


    }
}
