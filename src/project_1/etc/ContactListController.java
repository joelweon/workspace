package project_1.etc;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactListController extends AbstractCommand {
	@Override
	public String getCommandString() {
		return "contact/list";
	}
	
	protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {
		ContactDao contactDao = ContactDao.getInstance();
		ArrayList<Contact> list = contactDao.getList();
		for (Contact contact : list) {
			out.printf("%s,%s,%s,%s\n",
					contact.getName(),
					contact.getPosition(),
					contact.getTel(),
					contact.getEmail());
		} 
	}
}
