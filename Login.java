import java.util.*;
import java.io.*;

public class Login{
   
   //Member member = new Member();
   String[] staff = new String[3];
   int[] staffPass = new int[3];
   ArrayList<String> readPass = new ArrayList<String>();

   public void startMenuPrompt() throws IOException {
      // Making scanner, file and printstream objects
      Scanner console = new Scanner(System.in);
      Scanner in = new Scanner(new File("password.txt"));
      PrintStream out = new PrintStream(new File("members.txt"));      
      
      boolean run = true;
      
      while(in.hasNext()) {
         for (int i = 0; i <= 2; i++) {
            readPass.add(in.nextLine());
         }
      }
      boolean running = true;
      while(running) {
         System.out.println("******* Welcome to Delphine Swimming Club ******* " + "\n");
         System.out.println("You are about to login, please identify yourself:");
         System.out.println("1: Chairman");
         System.out.println("2: Trainer");
         System.out.println("3: Accountant \n");   
         int input = getInt("Please enter a number between 1 - 3.", 1, 3);
         switch(input) {
            // Chairman               
            case 1:
               adminLogin(0, "Chairman");
               // Menu after login
               System.out.println("Please choose an option:");
               System.out.println("1: Register a user");
               System.out.println("2: Change user information");
               System.out.println("0: Go back to login menu \n");
               
               int chairInput = getInt("Please enter a number between 0 - 2.", 0, 2);
               switch(chairInput) {
                  case 1:
                     System.out.println("Enter the name of the swimmer:");
                     String name = console.nextLine();
                     System.out.println("Enter the age of the swimmer:");
                     int age = console.nextInt();
                     System.out.println("Enter the sex of the swimmer (M/F):");
                     char sex = console.next().charAt(0);
                     System.out.println("Enter the activity of the swimmer (Active/Passive):");
                     String activity = console.next();
                     System.out.println("Enter the swimming category (Recreational/Competitive):");
                     String swimmingCategory = console.next();
                     System.out.println("Enter the swimming discipline of the swimmer:");
                     String swimmingDiscipline = console.next();
                     // The system registers the age category of the swimmer
                     String ageCategory = "";
                     if (age < 18) {
                        ageCategory = "Ungdomssv�mmer";
                     } else {
                        ageCategory = "Seniorsv�mmer";
                     }
                     // Calling the constructor of Member
                     Member member = new Member(name, age, sex, activity, ageCategory, swimmingCategory, swimmingDiscipline);
                     // Writing the member to a file
                     out.print(member);
                     break;                     
                  case 0:
                     running = false; 
                     break;                 
               }
               break;
            // Trainer
            case 2:
               adminLogin(1, "Trainer");
               // Menu after login
               System.out.println("Please choose an option:");
               System.out.println("1: Register swimming time");
               System.out.println("2: See top 5 swimmers");
               System.out.println("0: Go back to login menu \n");
               int trainerInput = getInt("Please enter a number between 0 - 2.", 0, 2);
               switch(trainerInput) {
                  case 1:
                     System.out.println("Choose a member from the list: ");
                     ;
                  
                  case 0:
                     running = false;
                     break;
               }
               break;                  
            // Accountant
            case 3:
               adminLogin(2, "Accountant");
               // Menu after login
               System.out.println("Please choose an option:");
               System.out.println("1: See a list of people with arrears");
               System.out.println("0: Go back to login menu \n");
               int AccountanrInput = getInt("Please enter a number between 0 - 2.", 0, 2);
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
      System.out.println("Welcome " + name + ", please enter your password");
      while (true) {
         String sinput = console.next();        
         if(sinput.equals(readPass.get(n))) {
            System.out.println("Welcome, " + name + "\n");
            break;
         } else {
            System.out.println("The password you've entered is incorrect, please try again.");
         }
      }
   }
}