package by.sherby.robots;

import by.sherby.pojo.ClientTask;
import by.sherby.pojo.RobotReport;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sergey on 05.10.2016.
 */
public class UpperCountRobot extends Robot {
    private static Logger log = Logger.getLogger(UpperCountRobot.class.getName());
    public UpperCountRobot(String name){
        super(name);
        thread = new Thread(new Task());
        thread.start();
    }

    private class Task implements Runnable{
        public Task(){

        }
        @Override
        public void run() {
            while(true) {
                try {
                    ClientTask task = tasks.take();
                    String str = task.getString();
                    int count = 0;
                    for (int i = str.length() - 1; i >= 0; i--) {
                        if (Character.isUpperCase(str.charAt(i))) count++;
                    }
                    tc.sendLogMessage(new RobotReport(String.valueOf(count), getName()));
                } catch (InterruptedException e) {
                    log.log(Level.SEVERE, e.getMessage(), e);;
                }
            }
        }
    }
}
