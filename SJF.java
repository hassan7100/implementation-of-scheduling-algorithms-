
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;
public class SJF implements Algorithm {
    List<Task> queue1=new ArrayList<Task>();
    int waiting = 0;
    int[] array;

    public SJF(List<Task> queue) {
        queue1 = queue;
        array = new int[queue1.size()];
        for (int i = 0; i < queue1.size(); i++) {
            array[i] = queue1.get(i).getBurst();

        }

        boolean sorted = false;
        int temp;
        Task temp1;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    temp1=queue1.get(i+1);
                    array[i] = array[i+1];
                    array[i+1]=temp;
                    Collections.swap(queue1, i, i+1);
                    sorted = false;
                }
            }

        }
        schedule();
    }
    private static StringBuilder s1 =new StringBuilder(" ");
    @Override
    public void schedule() {
        try {
            File file=new File("E:\\run.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw=new PrintWriter(fw);
            pw.print("SJF Algorithm\n\n");
            Task task1 = pickNextTask();

            while (task1 != null) {
                s1.append(task1.toString());
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
            return queue1.remove(0);
        }
        else
            return null;
    }
}
