package by.sherby.robots;

import by.sherby.pojo.ClientTask;
import by.sherby.pojo.RobotReport;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sergey on 04.10.2016.
 */
public class InvertRobot extends Robot {
    private static Logger log = Logger.getLogger(InvertRobot.class.getName());
    public InvertRobot(String name){
        super(name);
        thread = new Thread(new Task());
        thread.start();
    }

    @Override
    public Integer getType() {
        return 1;
    }

    private class Task implements Runnable{
        public Task(){
        }
        @Override
        public void run() {
            while(true){
                try {
                    ClientTask task = tasks.take();
                    String str = task.getString();
                    StringBuilder sb = new StringBuilder();
                    for(int i=str.length()-1;i>=0;i--){
                        sb.append(str.charAt(i));
                    }
                    tc.sendLogMessage(new RobotReport(sb.toString(),getName()));
                } catch (InterruptedException e) {
                    log.log(Level.SEVERE, e.getMessage(), e);
                }
            }

        }
    }
    }

