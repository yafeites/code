package problems;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class test  implements  Runnable{
    public  Thread thread;
    @Override
    public void run() {
        thread=Thread.currentThread();
        while (true)
        {
       System.out.println("xixix");
       System.out.println("xxxx");
       System.out.println("dddddd");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int[][]m={
                {1,2,3},
                {4,5},
                {6}
        };
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                System.out.println(m[i][j]);
            }
        }
//            ThreadPoolExecutor threadPoolExecutor= (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
//            test test=new test();
//            threadPoolExecutor.execute(test);
//             Thread.sleep(1000);
//             System.out.println(test.thread.getName());
//             test.thread.interrupt();
//             Thread.sleep(1000);
//
//            System.out.println(test.thread.isAlive());

    }
}
