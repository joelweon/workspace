package project_1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentController {
	private String filename = "student.data";
	ArrayList<Student> list;
	private boolean changed;
	private Scanner keyScan;
	
	public StudentController(Scanner keyScan) {
		list = new ArrayList<>();
		this.keyScan = keyScan;
		this.load();
	}
	
	public boolean isChanged() {
		return changed;
	}
	
	@SuppressWarnings("unchecked")
	private void load() {
		ObjectInputStream in = null;
		
		try {
			in = new ObjectInputStream(new FileInputStream(this.filename));
			
			while (true) {
				list = (ArrayList<Student>)in.readObject();
			}
		} catch (EOFException e) {
		} catch (Exception e) {
			System.out.println("학생 데이터 로딩 중 오류 발생!");
		} finally {
			try {
				in.close();
			} catch (Exception e) {}
		}
	}//load
	
	public void save() throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(
				                    new FileOutputStream(this.filename));
		out.writeObject(list);
		changed = false;
		
		out.close();
	}

	public void service() {
		loop:
		while (true) {
			System.out.print("학생관리> ");
			String command = keyScan.nextLine().toLowerCase();
			try {
				switch (command) {
				case "add": doAdd(); break;
				case "list": doList(); break;
				case "view": doView(); break;
				case "delete": doDelete(); break;
				case "update": doUpdate(); break;
				case "main": break loop; 
				default:
					System.out.println("잘못 입력하셨습니다.");
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("인덱스가 유효하지 않습니다.");
			} catch (Exception e) {
				System.out.println("실행 중 오류가 발생했습니다.");
			}//try
		}//while
	}
	
	
  private void doAdd() {
  	while (true) {
	  	Student student = new Student();
	  	System.out.print("아이디? ");
	  	student.userId = keyScan.nextLine();
	  	System.out.print("이름? ");
	  	student.name = keyScan.nextLine();
	  	
	  	while (true) {
	  		try {
			  	System.out.print("나이? ");
			  	student.age = Integer.parseInt(keyScan.nextLine());
			  	break;
	  		} catch (Exception e) {
	  			System.out.println("정수 값을 입력하세요.");
	  		}
	  	}
	  	
	  	System.out.print("재직중?(y/n) ");
  		student.working = (keyScan.nextLine().equals("y")) ? true : false;
	  	
	  	list.add(student);
	  	changed = true;
	  	
	  	System.out.print("계속 입력하시겠습니까?(y/n) ");
	  	if (!keyScan.nextLine().equals("y")) {
	  		break;
	  	}
  	}
  }//doAdd
  
  private void doList() {
  	for (int i = 0; i < list.size(); i++) {
  		Student student = (Student)list.get(i);
  		System.out.printf("%s,%s,%d,%b\n",
  				student.userId,
  				student.name,
  				student.age,
  				student.working);
  	}
  }//doList
  
  private void doView() {
  	System.out.print("조회할 학생의 인덱스? ");
  	int index = Integer.parseInt(this.keyScan.nextLine());
  	
  	Student student = (Student)list.get(index);
		System.out.printf("아이디? %s\n", student.userId);
		System.out.printf("이름? %s\n", student.name);
		System.out.printf("나이? %d\n", student.age);
		System.out.printf("재직중?(y/n) %b\n", student.working);
  }//doView
  
  private void doDelete() {
  	System.out.print("삭제할 학생의 인덱스? ");
  	int index = Integer.parseInt(keyScan.nextLine());
  	
  	Student deletedStudent = (Student)list.remove(index);
  	changed = true;
  	System.out.printf("%s 학생 정보 삭제완료.\n", deletedStudent.userId);
  }//doDelete
  
  private void doUpdate() {
  	System.out.print("변경할 학생의 인덱스? ");
  	int index = Integer.parseInt(keyScan.nextLine());
  		
  	Student oldStudent = (Student) list.get(index);
		Student student = new Student();
  			
		System.out.printf("이름(%s)? ", oldStudent.name);
		student.name = keyScan.nextLine();
		
		while (true) {
			try {
				System.out.printf("나이(%d)? ", oldStudent.age);
				student.age = Integer.parseInt(keyScan.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("정수 값을 입력하세요.");
			}
		}
		
		System.out.printf("재직중(%b)?(y/n) ", oldStudent.working);
		student.working = (keyScan.nextLine().equals("y")) ? true : false;
		
		System.out.println("저장하시겠습니까?(y/n) ");
		if (keyScan.nextLine().equals("y")) {
			student.userId = oldStudent.userId;
			list.set(index, student);
			changed = true;
			System.out.println("저장하였습니다.");
		} else {
			System.out.println("저장을 취소했습니다.");
		}
		return;
  }//doUpdate
  
}
