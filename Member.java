public class Member{

   private String name;
   private int age;
   private char sex;
   private String activity;
   private String ageCategory;
   private String swimmingCategory;
   private String swimmingDiscipline;

   public Member(String name, int age, char sex, String activity, String ageCategory, String swimmingCategory, String swimmingDiscipline){               
      this.name = name;
      this.age = age;
      this.sex = sex;
      this.activity = activity;
      this.ageCategory = ageCategory;
      this.swimmingCategory = swimmingCategory;
      this.swimmingDiscipline = swimmingDiscipline;
   }
     
   public String toString() {
       String minString = (name + " " + age + " " + ageCategory + " " + sex + " " + swimmingCategory + " " + swimmingDiscipline + " " + activity);
       return minString;  
   }
}