package com.shawnwz.sudoku;

/**
 * Created by shawn.zhang on 6/21/2017.
 */
public class MatrixInfo {

    public boolean SuccessFlag;
    public String ProcessInfo;
    public int[][] MatrixData;

    public MatrixInfo(){
        SuccessFlag = false;
        ProcessInfo = "";
        MatrixData = new int[9][9];
    }
}
