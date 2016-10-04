package by.sherby.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Sergey on 04.10.2016.
 */
public class Robot extends Thread{
    BlockingQueue<Runnable> queue;
    public Robot(BlockingQueue<Runnable> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        synchronized (queue){
            try {
                while (true){
                queue.wait();
                queue.take().run();
            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }

