import java.util.*;
import java.io.*;

public class DamAVLApp extends AVLTree<String>{
      //AVLTree<String> app  = new AVLTree<String>();
      //app.populate();

        public static void main(String[] args){
            DamAVLApp avl = new DamAVLApp();
                //AVLTree<String> app = new AVLTree<String>();
                avl.populate();
                //avl.searchAll();

                //Collecting the input from the args array
                 String userInput = "";
                 for(String x : args){
                     userInput += x;
                 }



                if(userInput.equals("")){
                  //System.out.println((avl.find(userInput)).data);
                  //avl.treeOrder();
                  avl.printAllDams();
                }else{
                  userInput += " ";

                  try{
                      avl.printDam(userInput);
                  }catch(NullPointerException e){
                    System.out.printf("%s is not found.\n",userInput);
                    System.out.printf("Comparisons done: %d\n",avl.getCounter());
                  }
                }


        }

        public void searchAll(){
          int indexVariable = -1;
          String inputFile = "DamLevel.csv";
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
                   dataStorage = dataLine.split(",");

                   if(indexVariable== -1){

                   }else{
                       //String data= String.format("Dam Name: %s\nFSC: %s\nDam Level: %s\n\n\n",dataStorage[2],dataStorage[10],dataStorage[27]);

                       String key = dataStorage[2];
                       find(key);
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
        public void printAllDams(){
          treeOrder();
          System.out.printf("There are %s comparisons done.\n",getCompareVariable());
        }
        public void printDam(String damName){
            System.out.println((find(damName)).data);
            System.out.printf("There are %s comparisons done.\n",getCounter());

        }
        public void populate(){
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
                      //pass/ don't do anything
                   }else{
                       String data= String.format("Dam Name: %s, FSC: %s, Dam Level: %s",dataStorage[2],dataStorage[10],dataStorage[27]);
                       String key = dataStorage[2];
                       insert(key,data);

                   }
                   indexVariable++;
              }
          }catch(FileNotFoundException e){
             System.out.println("An error occured");
          }

        }


}
