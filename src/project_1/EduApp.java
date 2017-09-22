package project_1;

import java.util.Scanner;

public class EduApp {
  
  static Scanner scan = new Scanner(System.in);
  
  public static void main(String[] args) {

    StudentController studentController = new StudentController(scan);
    
    while(true) {
      System.out.println("Command> ");
      String cmd = scan.nextLine().toLowerCase();
      
      switch(cmd) {
      case "menu" : doMenu(); break;
      case "go 1" : studentController.service(); break;
      case "quit" : 
        System.out.println("Good Bye!");
        break;
      default :
        System.out.println("잘못된 명령어.");
      }
    }
  }
  static void doMenu() {
    System.out.println("[Menu]");
    System.out.println("1. Student");
    System.out.println("If you want to go to other menu, type 'go menu number' ");
  }
}