import java.util.*;
import java.io.*;

public class DamBSTApp extends BinarySearchTree<String>{

     public static void main(String[] args){
         //Collecting the input from the args array
          String userInput = "";
          for(String x : args){
              userInput += x;
          }
          //userInput +=" ";
          // Create an object of type BDamBSTApp
           DamBSTApp DamData = new DamBSTApp();
           DamData.insertAll();
           //DamData.searchAll();


        //If the userInputis an empty string, the whole BST is printed out
        //otherwise the searched name and comparisonsdone are printed out.
        if(userInput.equals("")){
          DamData.printAllDams();
        }else{
          userInput += " ";

          try{

              DamData.printDam(userInput);
              //System.out.printf("Number of comparisons: %s\n",DamData.getCounter(),;
          }catch(NullPointerException e){
            System.out.printf("%sis not found.\n",userInput);
            System.out.printf("Number of comparisons: %s\n",DamData.getCounter());
          }
        }

     }

     public void searchAll(){
       int indexVariable = 0;
       String inputFile = "Simamkele.csv";
       File file =  new File(inputFile);
       int total = 0;
       //create new file

       //open file and populate the BinarySearchTree
       //catch any possible errors and report them
       try{
           Scanner dataFile = new Scanner(file);
           String[] dataStorage;
           while(dataFile.hasNextLine()){
                String dataLine = dataFile.nextLine();
                //dataStorage = dataLine.split(",");

                if(indexVariable== -1){

                }else{
                    //String data= String.format("Dam Name: %s\nFSC: %s\nDam Level: %s\n\n\n",dataStorage[2],dataStorage[10],dataStorage[27]);

                    //String key = dataStorage[0];
                    find(dataLine);
                    //total+=getCounter();
                    System.out.println(getCounter());
                    //insert(key,data);
                    //System.out.println(getCountAll());

                }
                indexVariable++;
           }
       }catch(FileNotFoundException e){
          System.out.println("An error occured");
       }


     }

     public void insertAll(){
           int indexVariable = -1;
           String inputFile = "DamLevel.csv";
           File file =  new File(inputFile);
           //create new file

           //open file and populate the BinarySearchTree
           //catch any possible errors and report them
           try{
               Scanner dataFile = new Scanner(file);
               String[] dataStorage;
               while(dataFile.hasNextLine()){
                    String dataLine = dataFile.nextLine();
                    dataStorage = dataLine.split(",");

                    if(indexVariable== -1){

                    }else{
                        String data= String.format("Dam Name: %s\nFSC: %s\nDam Level: %s\n\n\n",dataStorage[2],dataStorage[10],dataStorage[27]);
                        String key = dataStorage[2];
                        insert(key,data);
                        //System.out.println(getCountAll());

                    }
                    indexVariable++;
               }
           }catch(FileNotFoundException e){
              System.out.println("An error occured");
           }
     }
     public void printDam(String userInput){
       visit(find(userInput));
       System.out.printf("Number of comparisons: %s\n",getCounter());
     }
     public void printAllDams(){
       preOrder();
       System.out.printf("Total Number of comparisons: %d\n",getCountAll());
     }


}
