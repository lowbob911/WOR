package by.sherby.controller;

/**
 * Created by Sergey on 03.10.2016.
 */
import by.sherby.pojo.Robot4List;
import by.sherby.pojo.RobotReport;
import by.sherby.pojo.ClientTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import by.sherby.robots.Robot;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.logging.Level;

@Controller
public class TaskController {
    private static Logger log = Logger.getLogger(TaskController.class.getName());

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RobotsArea ra;

   @SubscribeMapping("/robotlist")
   public List getRobots(){
       return ra.getRobotsAsList();
   }

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

    @MessageMapping("/kill")
    public void receiveKill(String t){
        try {
            System.out.println(t);
           if(ra.killRobot(t)) sendRobots();
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
    public void sendRobots(){
        simpMessagingTemplate.convertAndSend("/robotlist", ra.getRobotsAsList());
    }
}
