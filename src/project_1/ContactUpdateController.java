package project_1;

import java.io.PrintStream;
import java.util.HashMap;

public class ContactUpdateController extends AbstractCommand {
	@Override
	public String getCommandString() {
		return "contact/update";
	}
	protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {
    try {
	  	ContactDao contactDao = ContactDao.getInstance();
	  	if (!contactDao.existEmail(paramMap.get("email"))) {
	      out.println("이메일을 찾지 못했습니다.");
	      return;
	    }
	    
	    Contact contact = new Contact();
	    contact.setName(paramMap.get("name"));
	    contact.setPosition(paramMap.get("position"));
	    contact.setTel(paramMap.get("tel"));
	    contact.setEmail(paramMap.get("email"));
	    contactDao.update(contact);
			out.println("변경하였습니다.");
    } catch (Exception e) {
      out.println("작업중 예외가 발생하였습니다.");
      e.printStackTrace();

    }
  }

}
