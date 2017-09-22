package project_1.etc;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public abstract class AbstractDao<T> {
  
	private String filename;
	protected ArrayList<T> list;
	
	public AbstractDao(String filename) {
		this.filename = filename;
	}
	
	@SuppressWarnings("unchecked")
	protected void load() {
		try (
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.filename));) {
				list = (ArrayList<T>)in.readObject();
		} catch (EOFException e) {
    } catch (Exception e) {
      	System.out.println("연락처 데이터 로딩 중 오류 발생!");
      	list = new ArrayList<>();
    }
	}//load
	
	synchronized public void save() throws Exception {
	  try (ObjectOutputStream out = new ObjectOutputStream(
	  		                      new FileOutputStream(filename)); ) {
	  	out.writeObject(list);
	  } catch (Exception e) {
	  	throw e;
	  }
	}//save
	

	

}
