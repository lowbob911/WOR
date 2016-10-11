package by.sherby.controller;

import by.sherby.pojo.Robot4List;
import by.sherby.robots.InvertRobot;
import by.sherby.robots.Robot;
import by.sherby.robots.UpperCountRobot;
import by.sherby.pojo.ClientTask;
import by.sherby.utils.RobotFactory;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 04.10.2016.
 */
@Service
@Scope("singleton")
public class RobotsArea {
    @Autowired
    TaskController tc;
    private ArrayList<Robot> robots = new ArrayList<>();

    public RobotsArea(){
        super();
    }
    private void addRobot(Robot r){
        robots.add(r);
    }
    private Robot getFreeRobotByType(Class type){
        for(Robot r:robots){
            if(r.getClass().equals(type) && r.isFree()) return r;
        }
        return null;
    }
    public void executeTask(ClientTask t){
            Class type = null;
            switch (t.getType()) {
                case 1:
                    type = InvertRobot.class;
                    break;
                case 2:
                    type = UpperCountRobot.class;
                    break;
            }
            Robot r = getFreeRobotByType(type);
            if (r != null) {
                r.addTask(t);
            } else {
                Robot newR = RobotFactory.createRobotByClass(type, "name" + robots.size());
                newR.setTc(tc);
                newR.addTask(t);
                addRobot(newR);
                tc.sendRobots();
            }
    }

    public List<Robot4List> getRobotsAsList() {
        if (robots.size() > 0) {
            ArrayList<Robot4List> arr = new ArrayList<>();
            for (Robot r : robots) {
                arr.add(new Robot4List(r.getName(), r.getType()));
            }
            return arr;
        } else
            return null;
    }
}
