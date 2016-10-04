package by.sherby.pojo;

import by.sherby.controller.TaskController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sergey on 04.10.2016.
 */
public class RobotTask implements Runnable{
    @Autowired
    TaskController tc;
    String text;
    public RobotTask(String text){
        this.text=text;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
    for(int i=text.length()-1;i>=0;i--){
        sb.append(text.charAt(i));
    }
        System.out.println(sb.toString());
    }
}
