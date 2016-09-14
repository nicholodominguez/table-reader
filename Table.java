import java.util.*;

public class Table{
    private int row;
    private int column;
    private final int MAX_STRING_LENGTH = 3; 
    private final int ASCII_RANGE_MAX = 126; 
    private final int ASCII_RANGE_MIN = 34;    
    private String[][] table;
        
    public Table(int row, int column){
        this.row = row;
        this.column = column;
        
        this.table = new String[row][column];
        this.fillTable();
    }

    public void printTable(){
        System.out.println();
        for(int i = 0; i < this.row; i++){
            System.out.print("|  ");
            for(int j = 0; j < this.column; j++){
                System.out.print(this.table[i][j]+"  |  ");
            }
            System.out.println();
        }
        
        System.out.println();
    }

    public String returnIndex(int row, int column){
        if(table != null ){
            return this.table[row][column];
        }
        return null;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }
        
    public int getStringLen(){
        return this.MAX_STRING_LENGTH;
    }

    public int getAsciiMax(){
        return this.ASCII_RANGE_MAX;
    }

    public int getAsciiMin(){
        return this.ASCII_RANGE_MIN;
    }
    
    public void replaceCell(int row, int column, String data){
        this.table[row][column] = data;
    }

    private void fillTable(){
        Random r = new Random();
        int a;
        StringBuilder input;
        for(int i = 0; i < this.row; i++){            
            for(int j = 0; j < this.column; j++){  
                input = new StringBuilder();
                for(int k = 0; k < this.MAX_STRING_LENGTH; k++){
                    a = r.nextInt(this.ASCII_RANGE_MAX - this.ASCII_RANGE_MIN) + this.ASCII_RANGE_MIN;
                    input.append(String.valueOf((char) a));
                }
                this.table[i][j] = input.toString();                            
            }
        }
    }

}
