package ru.svn.l03;

import sun.awt.SunToolkit;

import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) throws SunToolkit.InfiniteLoop {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;



    }
}
