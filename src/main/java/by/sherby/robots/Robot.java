package by.sherby.robots;

import by.sherby.controller.TaskController;
import by.sherby.pojo.ClientTask;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Sergey on 05.10.2016.
 */
public abstract class Robot {
    protected TaskController tc=null;
    protected ArrayBlockingQueue<ClientTask> tasks = new ArrayBlockingQueue<ClientTask>(5);
    private String name;
    protected Thread thread;

    public Robot(String name) {
        this.name = name;
    }

    public void addTask(ClientTask task){
        try {
            tasks.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean isFree(){
        return tasks.size()==0;
    }

    public String getName() {
        return name;
    }

    public void setTc(TaskController tc) {
        this.tc = tc;
    }
    abstract public Integer getType();
}

