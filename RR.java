
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
public class RR implements Algorithm {
    List<Task> queue1;
    int waiting = 0;
    int[] array;
    int ptr = 0;

    public RR(List<Task> queue) {
        queue1 = queue;
        array = new int[queue1.size()];
        for (int i = 0; i < queue1.size(); i++) {
            array[i] = queue1.get(i).getBurst();
            queue1.get(i).setRemaining(queue1.get(i).getBurst());
        }
        schedule();
    }
    private static StringBuilder s1 =new StringBuilder(" ");
    @Override
    public void schedule() {

        try {
            File file = new File("E:\\run.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.print("RR Algorithm\n\n");


            Task task1 = pickNextTask();

            while (task1 != null) {

                s1.append(task1.toString());
                if (ptr ==queue1.size()) {
                    ptr = 0;
                }
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
        if (!queue1.isEmpty()) {
            if (queue1.get(ptr).getRemaining_burst() <= 10) {
                queue1.get(ptr).setRemaining(0);
                return queue1.remove(ptr);
            } else {
                (queue1.get(ptr)).setRemaining(queue1.get(ptr).getRemaining_burst() - 10);
                int ptr1 = ptr;
                ptr += 1;
                return queue1.get(ptr1);
            }
        }
        else
            return null;
    }
}




