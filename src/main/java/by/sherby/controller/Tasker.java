package by.sherby.controller;

import by.sherby.pojo.RobotTask;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Sergey on 05.10.2016.
 */
public class Tasker implements Runnable{
    BlockingQueue q;
    public Tasker(BlockingQueue q){
        this.q=q;
    }
    @Override
    public void run() {
    synchronized (q){
        q.add(new RobotTask("hello"));
        q.notify();

    }
    }
}
