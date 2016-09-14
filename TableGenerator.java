import java.util.*;

class TableGenerator{
    private Table table;
    private Scanner scInt = new Scanner(System.in);
    private Scanner scStr = new Scanner(System.in);


    public void initTable(){
        int row;
        int column;

        System.out.println("Define table dimensions");
        row = this.getInputInt("Enter table row: ", true);        
        column = this.getInputInt("Enter table column: ", true);
        this.table = new Table(row, column);
    }
    
    public int printMenu(){
        int input = 0;

        this.table.printTable();
        System.out.println("------------");
        System.out.println("[1] Search");
        System.out.println("[2] Edit");
        System.out.println("[3] Print");
        System.out.println("[4] Reset");
        System.out.println("[5] Exit");
        System.out.println("------------");
        do{
            input = this.getInputInt("Option: ", true);
            if(input < 1 || input > 5) System.out.println("Input too high or too low.");
        }while(input < 1 || input > 5);

        return input;
    }

    public void searchTable(){
        String search;
        int searchLen, counter = 0;
        String content;
        boolean hasMatch = false, noMatch = true;

        search = this.getInputStr("Search keyword: ");
        searchLen = search.length();
        
        for(int i = 0; i < table.getRow(); i++){
            for(int j = 0; j < table.getColumn(); j++){
                content = table.returnIndex(i,j);
                for(int k = 0; k <= table.getStringLen() - searchLen; k++){
                    int l = k + searchLen;
                    //if(search.compareTo(content.substring(k, l)) == 0){ //case sensitive
                    if(search.compareToIgnoreCase(content.substring(k, l)) == 0){
                        hasMatch = true;
                        noMatch = false;                        
                        counter += 1;                    
                    }
                }
                if(hasMatch) System.out.println("(" + i + "," + j + ") - " + counter);
                hasMatch = false;
                counter = 0;
            }
        }
        
        if(noMatch) System.out.println("No data matched for your keyword");
    }

    public void editTable(){
        int row, column, size = table.getStringLen();
        String replacement;

        System.out.println("Enter cell dimension to be edited");
        
        row = this.getInputInt("Enter table row: ", false);        
        column = this.getInputInt("Enter table column: ", false);
        replacement = this.getInputStr("Replace cell data with: ", size);

        table.replaceCell(row, column, replacement);                
    }

    public int getInputInt(String msg, boolean nonZero){
        boolean isAlpha = true;
        int floor = nonZero?1:0;
        String limit = nonZero?"one":"zero";
        int row = 0;

        while(isAlpha){
            System.out.print(msg);
            if(scInt.hasNextInt()){
                row = scInt.nextInt();
                if(row < floor){
                    System.out.println("Integer too low, it should be greater than "+limit);    
                }
                else isAlpha = false;
            }
            else{
                scInt.next();
                System.out.println("Input not an integer");
            }
        }

        return row;    
    }

    public String getInputStr(String msg){
        int maxLen = table.getStringLen();
        boolean isValid = false;
        String input = "";

        while(!isValid){
            System.out.print(msg);
            if(scStr.hasNextLine()){
                input = scStr.nextLine();
                if(input.length() > maxLen){
                    System.out.println("Input too long. Max char of " + maxLen);               
                }
                else{
                    Character c = containsInvalidChar(input);
                    if(c != null){
                        System.out.println("Invalid character " + c);                            
                    }
                    else isValid = true;
                }
            }           
        }

        return input;     
    }

    public String getInputStr(String msg, int size){
        int maxLen = table.getStringLen();
        boolean isValid = false;
        String input = "";

        while(!isValid){
            System.out.print(msg);
            if(scStr.hasNextLine()){
                input = scStr.nextLine();
                if(input.length() > size){
                    System.out.println("Input too long. No. of char should be " + size);               
                }
                else if(input.length() < size){
                    System.out.println("Input too short. No. of char should be " + size);                 
                }
                else{
                    Character c = containsInvalidChar(input);
                    if(c != null){
                        System.out.println("Invalid character " + c);                            
                    }
                    else isValid = true;
                }
            }           
        }

        return input;     
    }

    public Character containsInvalidChar(String input){
        int max = table.getAsciiMax();
        int min = table.getAsciiMin();
        int inputLen = input.length();

        for(int i = 0; i < inputLen; i++){
            int ascii = (int)input.charAt(i);             
            if(ascii < min || ascii > max){
                return input.charAt(i);
            }
        }

        return null;
    }
}


