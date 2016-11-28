package project_1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactViewController  extends AbstractCommand {
	@Override
	public String getCommandString() {
		return "contact/view";
	}
	
  protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {
  	ContactDao contactDao = ContactDao.getInstance();
  	ArrayList<Contact> list = contactDao.getListByName(paramMap.get("name"));
  	for (Contact contact : list) {
			out.println("--------------------------");
			out.printf("이름? %s\n", contact.getName());
			out.printf("직위? %s\n", contact.getPosition());
			out.printf("번호? %s\n", contact.getTel());
			out.printf("이메일? %s\n", contact.getEmail());
  	}
	}//doView
}
