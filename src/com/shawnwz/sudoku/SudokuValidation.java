package com.shawnwz.sudoku;

/**
 * Created by shawnzhang on 2017-06-20.
 */

import java.io.*;
import java.util.*;

public class SudokuValidation {

    private String defaultFile;

    public SudokuValidation(){
        defaultFile = "input_sudoku.txt";
    }

    public String GetDefaultFile(){
        return defaultFile;
    }

    public MatrixInfo GetDataFromFile(String inputFile) {
        MatrixInfo retMtInfo = new MatrixInfo();
        String tmpLine;
        int[] tmpRow;
        int idxRow = 0;

        try {
            File sFile = new File(inputFile);
            Scanner scanner = new Scanner(sFile);

            while (scanner.hasNextLine()) {
                tmpLine = scanner.nextLine().replaceAll("\\s+", "");
                if (tmpLine.length() >= 9) {
                    tmpRow = tmpLine.chars().toArray();
                    if (tmpRow.length >= 9) {
                        for (int i = 0; i < 9; i++) {
                            retMtInfo.MatrixData[idxRow][i] = tmpRow[i] - 48;
                        }
                        idxRow++;
                        if (idxRow >= 9) {
                            retMtInfo.SuccessFlag = true;
                            break;
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            retMtInfo.ProcessInfo += ex.getMessage() + System.lineSeparator();
        }
        return retMtInfo;
    }

    public boolean validateMt(int[][] pMatrix) {
        boolean retVal = false;
        int[] block;
        int[] row;
        int[] column;

        for (int i = 0; i < 9; i++) {
            block = new int[9];
            row = new int[9];
            column = pMatrix[i].clone();

            for (int j = 0; j < 9; j++) {
                row[j] = pMatrix[j][i];
                block[j] = pMatrix[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (compValidate(column) && compValidate(row) && compValidate(block)){
                retVal = true;
            }
        }
        return retVal;
    }

    private boolean compValidate(int[] component) {
        int i = 0;
        Arrays.sort(component);
        for (int number : component) {
            if (number != ++i)
                return false;
        }
        return true;
    }

}
