package com.csc;

public class CheeseWriterCSV {
    private CheeseWriter cheeseWriter;
    private boolean firstInLine;
    CheeseWriterCSV() {}
    String getFileName() {
        return cheeseWriter.getFileName();
    }
    boolean openFile(String fileName) {
        firstInLine = true;
        cheeseWriter = new CheeseWriter();
        return cheeseWriter.openFile(fileName);
    }
    boolean addValue(String value) {
        if(!firstInLine) {
            cheeseWriter.print(",");
        } else {
            firstInLine = false;
        }
        boolean success;
        if(value.contains(",") || value.contains("\"")) {
            cheeseWriter.print("\"");
            success = cheeseWriter.print(value);
            cheeseWriter.print("\"");
        } else {
            success = cheeseWriter.print(value);
        }
        return success;
    }
    boolean newLine() {
        firstInLine = true;
        return cheeseWriter.print("\n");
    }
    boolean close() {
        return cheeseWriter.close();
    }
}
