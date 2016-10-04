package by.sherby.controller;

import by.sherby.pojo.RobotReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Sergey on 04.10.2016.
 */
@Service
@Scope("singleton")
public class RobotsArea {
    BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
    public RobotsArea(){
        super();
    }
}
