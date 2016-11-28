package project_1;

import java.io.PrintStream;
import java.util.HashMap;

public abstract class AbstractCommand implements Command {
	public abstract String getCommandString();
	
	@Override
	public void service(HashMap<String,String> paramMap, PrintStream out) { 
  	try {
  		doResponse(paramMap, out);
	  } catch (Exception e) {
	  	out.println("작업중 예외 발생");
	  	e.printStackTrace();
		}
	}
	
	protected void doResponse(HashMap<String, String> paramMap, PrintStream out) throws Exception {
		System.out.println("작업을 준비중 입니다.");
	}
}
