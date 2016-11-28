package project_1;

import java.io.File;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;

public class EduAppServer {
	HashMap<String,Command> commandMap = new HashMap<>();
	
  public EduAppServer() {
  	ArrayList<Class> classList = new ArrayList<>();
  	ReflectionUtil.getCommandClasses(new File("./bin"), classList);
  	
  	for (Class c : classList) {
  		try {
  			AbstractCommand command = (AbstractCommand)c.newInstance();
  			commandMap.put(command.getCommandString(), command);
  		} catch (Exception e) {}
  	}
  }
	
  private void service() throws Exception {
  	ServerSocket ss = new ServerSocket(8888);
  	System.out.println("Server running...");
  	
  	while (true) {
  		new RequestThread(ss.accept(), commandMap).start();
  	}
  }
  
  public static void main(String[] args) throws Exception {
  	EduAppServer eduServer = new EduAppServer();
  	eduServer.service();
  }//main
}
  


