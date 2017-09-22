package project_1.etc;

import java.io.PrintStream;
import java.util.HashMap;

public class ContactDeleteController extends AbstractCommand {
	@Override
	public String getCommandString() {
		return "contact/delete";
	}
	
	protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {
			ContactDao contactDao = ContactDao.getInstance();
    if (!contactDao.existEmail(paramMap.get("email"))) {
      out.println("이메일이 존재하지 않습니다.");
      return;
    }
    contactDao.delete(paramMap.get("email"));
    out.println("삭제하였습니다.");
  }
}