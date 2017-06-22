package com.shawnwz.sudoku;

public class Main {

    public static void main(String[] args) {
        SudokuValidation sudoku = new SudokuValidation();
        String txtFile = "";
        if (args.length <= 0) {
            txtFile = sudoku.GetDefaultFile();
            if(txtFile==null || txtFile.trim().isEmpty()){
                System.out.println("Please input sudoku filename.");
            }
        }
        MatrixInfo mInfo = sudoku.GetDataFromFile(txtFile);
        if(mInfo.SuccessFlag){
            boolean validateResult = sudoku.validateMt(mInfo.MatrixData);
            if(validateResult) System.out.println("This is a validate sudoku.");
            else System.out.println("It's not a validate sudoku");
        }else{
            System.out.println(mInfo.ProcessInfo);
        }

    }
}
