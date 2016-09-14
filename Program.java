import java.util.*;

class Program{
    public static void main(String[] args){        
        TableGenerator tg = new TableGenerator();
	    int choice = 4;

	    do{                
            switch(choice){
                case 1:
                    tg.searchTable();
                    break;
                case 2:
                    tg.editTable();
                    break;
                case 3:
                    break;
                case 4:
                    tg.initTable();
                    break;
                default:
                    System.out.println("Invalid choice");
            }            
            choice = tg.printMenu();	
        }while(choice != 5);
    } 
}
