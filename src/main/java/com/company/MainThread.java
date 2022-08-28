package com.company;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 10; i++) {
            executorService.execute(new MyThread(new Date()));
            executorService.execute(new MyThread(new Date(2005, 3, 5)));
        }

        executorService.shutdown();
    }
}

class MyThread extends Thread {
    Date date;
    public MyThread(Date date) {
        this.date = date;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(date);
        }
    }
}