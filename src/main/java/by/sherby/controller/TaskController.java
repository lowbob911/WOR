package by.sherby.controller;

/**
 * Created by Sergey on 03.10.2016.
 */
import by.sherby.pojo.RobotReport;
import by.sherby.pojo.ClientTask;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.logging.Level;

@Controller
public class TaskController {
    private static Logger log = Logger.getLogger(TaskController.class.getName());

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RobotsArea ra;


    @MessageMapping("/task")
    public void receiveTask(ClientTask t){
     try {
         ra.executeTask(t);
     }
     catch (Exception ex){
         sendErrMessage(ex.toString());
         log.log(Level.SEVERE, ex.getMessage(), ex);
     }
    }
    public void sendLogMessage(RobotReport rr){
        simpMessagingTemplate.convertAndSend("/task/resp", rr);
    }
    public void sendErrMessage(String err){
        simpMessagingTemplate.convertAndSend("/task/err", err);
    }
}
