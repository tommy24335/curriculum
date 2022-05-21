package check;

import constanta.Constants;

public class Check {
    
    private static String firstName="遼太";
    private static String lastName="冨永";
    private static void printName(String last, String first) {
       String fullNmame = last + first;
       System.out.println("printNameメソッド → "+ fullNmame);
       }
public static void main(String[] args) {
    // TODO 自動生成されたメソッド・スタブ,
    
       Check check = new Check();
       check.printName(firstName, firstName);
       
       Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
       pet.introduce();
       
       RobotPet robot = new  RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
       robot.introduce();
       }
}
