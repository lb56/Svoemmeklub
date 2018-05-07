import java.util.*;
import java.io.*;

public class Login{

   Scanner scan = new Scanner(System.in);
   String[] staff = new String[3];
   int[] staffPass = new int[3];

   public void startMenuPrompt() throws IOException {
      Scanner console = new Scanner(System.in);
      File f = new File("password.txt");
      Scanner in = new Scanner(f);
      boolean run = true;
      String pass;
      
      while(run){
         System.out.println("******* Welcome to Delphine Swimming Club ******* " + "\n");
         System.out.println("You are about to login, please identify yourself:");
         System.out.println("1 : Chairman");
         System.out.println("2 : Trainer");
         System.out.println("3 : Accountant");
         
         
         boolean running = true;
         while(running) {   
            int input = console.nextInt();
            switch(input) {
               case 1:
                  System.out.println("Hey mister chairman, please login \n ");
                  String a = in.next();
                  boolean b = true;
                  while (b) {
                  String sinput = console.next();        
                     if(sinput.equals(a)) {
                        System.out.println("Welcome Chairman");
                        b = false;
                     } else {
                        System.out.println("Please try again");
                     }
                  }
                  System.out.println("Fortsæt");

            }
            /*if(input == 1){
               System.out.println("Hey mister chairman, please login \n ");
               System.out.println("Username: " + staff[1]);            
            } else if(!console.hasNextInt()){
               System.out.println("Please type an numer between 1 - 3.");
            }
            run = false; */
         }        
      }
     
   }
   
   
  
      /*int input = console.nextInt();   
      switch(input){
         
         case 1:
            System.out.println("Username: ");
            //scan.nextInt();
            break;
         
         case 2:
            System.out.println("Password: ");
            break;         
      }
      return input;   
   } */
   
   public int getInt(String prompt){
      Scanner scanInt = new Scanner(System.in);
      System.out.print(prompt);
      //antiJarl scanInt.hasNextInt()
      while (!scanInt.hasNextInt()){
         //smid det næste væk, når det ikke er en int
         scanInt.next();
         //vejled brugeren
         System.out.print(prompt);
      }
      
      return scanInt.nextInt();
   }
}