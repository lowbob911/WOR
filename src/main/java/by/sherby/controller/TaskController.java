package by.sherby.controller;

/**
 * Created by Sergey on 03.10.2016.
 */
import by.sherby.pojo.RobotReport;
import by.sherby.pojo.Task;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Controller;

import java.util.Random;

@Controller
public class TaskController {

    private Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    private void sendLogMessgae(RobotReport rr){
        simpMessagingTemplate.convertAndSend("/topic/color", rr);
    }
}
