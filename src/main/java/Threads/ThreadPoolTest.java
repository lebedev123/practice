package Threads;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src) :");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g. volatile):");
            String keyword = in.nextLine();
            ExecutorService pool = Executors.newCachedThreadPool();
            MathCounter counter = new MathCounter(new File(directory),keyword,pool);
            Future<Integer> result = pool.submit(counter);
            try{
                System.out.println(result.get() + "matching files.");
            }catch (ExecutionException ex){
                ex.printStackTrace();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            pool.shutdown();
            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size  = " + largestPoolSize);
        }
    }
}
class MathCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MathCounter(File directory, String keyword,ExecutorService pool) {
        this.directory = directory;
        this.pool = pool;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try{
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for(File file : files)
                if(file.isDirectory()){
                    MathCounter counter = new MathCounter(file,keyword,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else {
                    if(search(file)) count++;
                }
                for(Future<Integer> result : results)
                    try{
                        count+= result.get();
                    }catch (ExecutionException ex) {
                        ex.printStackTrace();
                    }
            }catch (InterruptedException e){

        }
        return count;
    }
    public boolean search(File file){
        try{
            try(Scanner in = new Scanner(file,"UTF-8")){
                boolean found = false;
                while(!found && in.hasNextLine()){
                    String line = in.nextLine();
                    if(line.contains(keyword)) found = true;
                }
                return found;
            }
        }catch (IOException e){
            return  false;
        }
    }
}