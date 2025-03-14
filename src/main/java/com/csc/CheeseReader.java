package com.csc;

import java.io.BufferedReader;
import java.io.FileReader;

public class CheeseReader {
    private String fileName;
    private CheeseList cheeseList;
    private CheeseParser cheeseParser;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    CheeseReader(String fileName) {
        this.fileName = fileName;
        cheeseList = new CheeseList();
        cheeseParser = new CheeseParser();
    }
    void clearLine() {
        try {
            bufferedReader.readLine();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    CheeseList readCheese() {
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
//            clearLine();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                cheeseList.addCheese(cheeseParser.parseCheese(line));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return cheeseList;
    }
}
