import java.util.*;

public class MembersList{

   ArrayList<Member> members = new ArrayList<Member>();
   
   public void printMember(){
      members.add(new Member("Anna", 18, "F", "Competition", "Senior", "Fish", "None"));
      members.add(new Member("Pia", 15, "F", "Competition", "Junior", "Fish", "None"));
      for(Member s: members){
         System.out.println(s);
      }
      
      }
      
         

}