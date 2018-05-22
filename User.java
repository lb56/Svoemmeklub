import java.util.*;
import java.io.*;

public class User{
   
   // Making arraylists
   private ArrayList<String> readPass = new ArrayList<String>();
   /*ArrayList<String> members = new ArrayList<String>();*/
   
   // startMenu method
   public void startMenuPrompt() throws IOException {
      // Making scanner-, file-, printstream- and date objects
      Scanner console = new Scanner(System.in);
      Scanner in = new Scanner(new File("password.txt"));
      /*Scanner inmem = new Scanner(new File("members.txt")); */
      PrintStream out = new PrintStream(new FileOutputStream("members.txt", true));
      Date date = new Date();  
      // Adding passwords to readPass arraylist
      while (in.hasNext()) {
         readPass.add(in.nextLine());
      }
      /* Saving members to members arraylist
      while (inmem.hasNextLine()) {
         members.add(inmem.nextLine());             
      } */
      boolean running = true;
      while(running) {
         // Welcome message
         System.out.println("******* Welcome to Dolphin Swimming Club ******* " + "\n");
         System.out.println("You are about to login, please identify yourself:");
         System.out.println("1: Chairman");
         System.out.println("2: Trainer \n"); 
         System.out.println("0: Close program"); 
         int input = getInt("Please enter a number between 0 - 2.", 0, 2);
         switch(input) {
            // Chairman               
            case 1:
               adminLogin(0, "Chairman");
               // Menu after login
               System.out.println("Please choose an option:");
               System.out.println("1: Register a new swimmer");
               int chairInput = getInt("Please enter the number 1.", 1, 1);
               switch(chairInput) {
                  // Register user
                  case 1:
                     System.out.println("Enter the name of the swimmer:");
                     String name = console.nextLine();
                     System.out.println("Enter the age of the swimmer:");
                     int age = getInt("Please enter a valid age:", 0, 125);
                     // The system registers the age category of the swimmer
                     String ageCategory = "";
                     if (age < 18) {
                        ageCategory = "Junior swimmer";
                     } else {
                        ageCategory = "Senior swimmer";
                     }
                     //
                     System.out.println("Enter the sex of the swimmer (M/F):");
                     char sex = console.next().charAt(0);
                     System.out.println("Enter the activity of the swimmer (Active/Passive):");
                     String activity = console.next();
                     System.out.println("Enter the swimming category (Recreational/Competitive):");
                     String swimmingCategory = console.next();
                     // Checking if the swimmer is competitive
                     String swimmingDiscipline = "";
                     if (swimmingCategory.equals("Competitive")) {
                        System.out.println("Enter the swimming discipline of the swimmer:");
                        swimmingDiscipline = console.next();
                     } else {
                        swimmingDiscipline = "N/A";
                        }
                     // Calling the constructor of Member
                     Member member = new Member(name, age, sex, activity, ageCategory, swimmingCategory, swimmingDiscipline);                  
                     // Writing the member to a file
                     out.println(member);
                     break;                                     
               }
               break;
            // Trainer
            case 2:
               adminLogin(1, "Trainer");
               // Menu after login
               System.out.println("Please choose an option:");
               System.out.println("1: Register swimming time");
               int trainerInput = getInt("Please enter the number 1.", 1, 1);
               switch(trainerInput) {
                  case 1:
                     System.out.println("Enter the name of the swimmer:");
                     String swimName = console.next();                    
                     System.out.println("Enter the time of the swimmer:");
                     String timeInput = console.next();
                     PrintStream outTime = new PrintStream(new FileOutputStream(swimName + "times.txt", true));
                     outTime.println(timeInput + date);
                     break;              
               } 
               break;
            case 0:
               running = false;
               break;     
         }                   
      }  
   }
      
   public int getInt(String prompt, int min, int max){
      Scanner scanInt = new Scanner(System.in);
      // Making sure it's an int
      while (true) {
         while (!scanInt.hasNextInt()){
            // Throwing away the next, if it's not an int
            scanInt.next();
            System.out.println(prompt);
         }
         int a = scanInt.nextInt();
         if (a >= min && a <= max) {
            return a;  
         } else {
            System.out.println(prompt);
         }
      }
   }
   
   public void adminLogin(int n, String name) {
      Scanner console = new Scanner(System.in);
      System.out.println("Please enter your password");
      while (true) {
         String input = console.next();        
         if(input.equals(readPass.get(n))) {
            System.out.println("Welcome, " + name + "\n");
            break;
         } else {
            System.out.println("The password you've entered is incorrect, please try again.");
         }
      }
   }
}