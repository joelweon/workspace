package project_1;

import java.util.Scanner;

public class StudentController {
  private LinkedList<Student> list;
  private Scanner scan;
  
  Student[] students = new Student[100];

  public StudentController(Scanner scan) {
    list = new LinkedList<Student>();
    this.scan = scan;
  }
  
  public void service() {
    loop:
    while(true) {
      System.out.print("Student Mng > ");
      
      String cmd = scan.nextLine().toLowerCase();
      try {
        switch (cmd) {
        case "a" : doAdd(); break;
        case "l" : doList(); break;
        case "v" : doView(); break;
        case "d" : doDelete(); break;
        case "u" : doUpdate(); break;
        case "m" : break loop;
        default :
          System.out.println("잘못된 명령어.");
        }
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  private void doList() {
    for (int i = 0; i < list.size(); i++) {
      Student student = list.get(i);
      System.out.printf("%s,%s,%s,%s,%s,%s,%d,%s\n",
          student.userId,
          student.password,
          student.name,
          student.tel,
          student.email,
          ((student.working)?"yes":"no"),
          student.birthYear,
          student.school);
    }
  }
  
  private void doAdd() {
    while(true) {
      Student student = new Student();
      
      System.out.println("아이디? ");
      student.setUserId(scan.nextLine());
      
      System.out.print("암호(예:1111)? ");
      student.setPassword(scan.nextLine());
  
      System.out.print("이름(예:홍길동)? ");
      student.setName(scan.nextLine());
  
      System.out.print("전화(예:010-1111-2222)? ");
      student.setTel(scan.nextLine());
  
      System.out.print("이메일(예:hong@test.com)? ");
      student.setEmail(scan.nextLine());
  
      System.out.print("재직중(y/n)? ");
      student.setWorking((scan.nextLine().toLowerCase().equals("y")) ? true : false);
  
      System.out.print("태어난해(예:1980)? ");
      student.setBirthYear(Integer.parseInt(scan.nextLine()));
  
      System.out.print("최종학교(예:고등학교)? ");
      student.setSchool(scan.nextLine());
    
      list.add(student);
      
      System.out.println("계속입력? ");
      if(!"y".equals(scan.nextLine())) {
        break;
      }
    }
  }
  
  private void doView() {
    System.out.print("조회할 인덱스? ");
    
    int index = Integer.parseInt(scan.nextLine());
    
    Student student = list.get(index);
    
    System.out.printf("아이디: %s\n", student.userId);
    System.out.printf("암호: (***)\n");
    System.out.printf("이름: %s\n", student.name);
    System.out.printf("전화: %s\n", student.tel);
    System.out.printf("이메일: %s\n", student.email);
    System.out.printf("재직중: %s\n", (student.working) ? "Yes" : "No");
    System.out.printf("태어난 해: %d\n", student.birthYear);
    System.out.printf("학교: %s\n", student.school);
  }
  
  private void doDelete() {
    System.out.print("삭제할 인덱스? ");

    int index = Integer.parseInt(scan.nextLine());
    
    Student deleteStudent = (Student)list.remove(index);
    
    System.out.println(deleteStudent.userId + " 삭제완료!");
  }
  
  private void doUpdate() {
    System.out.print("변경할 학생의 인덱스? ");
    
    int index = Integer.parseInt(this.scan.nextLine());
    
    Student oldStudent = list.get(index);
    
    Student student = new Student();
    
    System.out.printf("암호: ");
    student.password = scan.nextLine();
    System.out.printf("이름: ");
    student.name = scan.nextLine();
    System.out.printf("전화: ");
    student.tel = scan.nextLine();
    System.out.printf("이메일: ");
    student.email = scan.nextLine();
    System.out.printf("재직중: ");
    student.working = (scan.nextLine().toLowerCase().equals("y")) ? true : false;
    System.out.printf("태어난 해: ");
    student.birthYear = Integer.parseInt(scan.nextLine());
    System.out.printf("학교: ");
    student.school = scan.nextLine();
        
    System.out.println("저장? ");
    if ("y".equals(scan.nextLine().toLowerCase())) {
      student.userId = oldStudent.userId;
      list.set(index, student);
      System.out.println("변경완료!");
    } else {
      System.out.println("변경취소!");
    }
  }

}
