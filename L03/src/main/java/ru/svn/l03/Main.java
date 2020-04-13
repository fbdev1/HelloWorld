package ru.svn.l03;


/**
 * VM options -Xmx512m -Xms512m
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */
import java.lang.management.ManagementFactory;
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
    public static void main(String[] args) throws  InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 2_000_000;

        System.out.println("Starting the loop");



        while (true){
            System.gc();
            Thread.sleep(10);

            Runtime runtime = Runtime.getRuntime();
           // System.out.println("Total mem: " + runtime.totalMemory());
           // System.out.println("Free mem: " + runtime.freeMemory());
            long mem = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("total used before create array: " + mem);

            Object[]array = new Object[size];
            System.out.println();

            //System.out.println("Free mem: " + runtime.freeMemory());
            long mem2 = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("total used after create array: " + mem2);
            System.out.println("link: "+ (mem2-mem));
            System.out.println("mem under 1 link: " + (mem2-mem)/size);

            System.out.println("New array of size: " + array.length + " created");

            for(int i = 0; i<=size-1;i++){
               //array[i] = new Object();
                //array[i] = new String(""); //String pool
                //array[i] = new String(new char[0]); //without String pool
                array[i] = new MyClass();
            }
            long mem3 = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("After array full: " + (mem3 - mem2)/size);

            System.out.println("Created "+ size + " objects");

            Thread.sleep(1000);


        }


    }

    private static class MyClass{
        private int i=0;
        private long l=1;
    }
}
