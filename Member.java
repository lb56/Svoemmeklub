public class Member{

   private String name;
   private int age;
   private char sex;
   private String activity;
   private String ageCategory;
   private String swimmingCategory;
   private String swimmingDiscipline; //(alt)

   public Member(String name, int age, char sex, String activity, String ageCategory, String swimmingCategory, String swimmingDiscipline){               
      this.name = name;
      this.age = age;
      this.sex = sex;
      this.activity = activity;
      this.ageCategory = ageCategory;
      this.swimmingCategory = swimmingCategory;
      this.swimmingDiscipline = swimmingDiscipline;
   }
   
   public Member() {
   }
 
   public void setAge(int age) {
      this.age = age;
   }
   
   public void setAgeCategory(String ageCategory){
      this.ageCategory = ageCategory;
   }
 
   public void setSwimmingCategory(String swimmingCategory){
      this.swimmingCategory = swimmingCategory;
   }
 
   public void setSwimmingDiscipline(String swimmingDiscipline){
      this.swimmingDiscipline = swimmingDiscipline;
   }
 
   public String getName() {
      return name;
   }
   
   public String getActivity(){
      return activity;
   }
 
   public String getAgeCategory(){
      return swimmingCategory;
   }
   
   public String toString(){
       String minString = "";
       minString += "Activity: " + activity + "\n";
       minString += "Navn: " + name + "\n";
       minString += "Age: " + Integer.toString(age) + "\n";
       minString += "Age category: " + ageCategory + "\n";
       minString += "Sex: " + sex + "\n";
       minString += "Swimming category: " + swimmingCategory + "\n";
       minString += "Swimming discipline: " + swimmingDiscipline;
       return minString;  
   }
}