import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException {
       Scanner newscan = new Scanner(new File("members.txt"));
       Login login = new Login();
       login.startMenuPrompt();   
   }
}