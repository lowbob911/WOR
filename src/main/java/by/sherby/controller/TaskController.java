package by.sherby.controller;

/**
 * Created by Sergey on 03.10.2016.
 */
import by.sherby.pojo.RobotReport;
import by.sherby.pojo.ClientTask;
import by.sherby.pojo.RobotTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    private Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RobotsArea ra;


    @MessageMapping("/task")
    public void receiveColor(ClientTask t){
        Robot r = new Robot(ra.taskQueue);
        r.start();
        Tasker tasker = new Tasker(ra.taskQueue);
        Thread  tt = new Thread(tasker,"tasker");
        tt.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tt.isAlive());
        tt=new Thread(tasker,"tasker");
        tt.start();
    }
    public void sendLogMessgae(RobotReport rr){
        simpMessagingTemplate.convertAndSend("/topic/color", rr);
    }
}
