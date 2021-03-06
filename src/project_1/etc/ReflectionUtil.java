package project_1.etc;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class ReflectionUtil {
  public static void getCommandClasses(File dir, ArrayList<Class> classList) {
  	if (!dir.isDirectory()) {
  		return;
  	}
  	
  	File[] files = dir.listFiles(new FileFilter() {
  		@Override
  		public boolean accept(File pathname) {
  			if (pathname.isDirectory())
  				return true;
  			if (pathname.getName().endsWith(".class") && !pathname.getName().contains("$"))
  				return true;
  			return false;
  		}
  	});
  	
  	for (File file : files) {
  		if (file.isDirectory()) {
  			getCommandClasses(file, classList);
  		} else {
  			String path = file.getAbsolutePath().replaceAll("\\\\", "/").replaceAll(".class", "");
  			
  			int pos = path.indexOf("/bin/");
  			try {
  				String classname = path.substring(pos + 5).replaceAll("/", ".");
  				Class c = Class.forName(classname);
  				
  				Class superClass = c.getSuperclass();
  				
  				if (superClass == AbstractCommand.class) {
  					classList.add(c);
  				}
  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  		}
  	}
  }
}
