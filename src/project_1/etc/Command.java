package project_1.etc;

import java.io.PrintStream;
import java.util.HashMap;

public interface Command {
  void service(HashMap<String,String> paramMap, PrintStream out);
}
