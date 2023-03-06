
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
public class FCFS implements Algorithm {
 List<Task> queue1;
 int waiting=0;
 public FCFS(List<Task> queue){
  queue1=queue;
   schedule();
 }
 private static StringBuilder s1 =new StringBuilder(" ");
 @Override
 public void schedule() {


  try{
   File file=new File("E:\\run.txt");
   FileWriter fw = new FileWriter(file);
   PrintWriter pw=new PrintWriter(fw);
   pw.print("FCFS Algorithm\n\n");
   Task task1 = pickNextTask();
    while (task1 != null) {
     String s2=task1.toString();
    s1.append(s2);
    waiting += task1.getBurst();
    task1 = pickNextTask();
    }
   pw.println(s1);
    pw.close();
   }
   catch (IOException e) {
   System.out.println("An error occurred.");
   e.printStackTrace();
  }
 }
 @Override
 public Task pickNextTask() {
  if(!queue1.isEmpty()) {
   Task task1 = queue1.remove(0);
   return task1;
  }
  else
   return null;
 }
}
