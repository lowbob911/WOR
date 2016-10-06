package by.sherby.utils;

import by.sherby.robot.InvertRobot;
import by.sherby.robot.Robot;
import by.sherby.robot.UpperCountRobot;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Sergey on 05.10.2016.
 */
@Service
@Scope("singleton")
public class RobotFactory {
    public static Robot createRobotByClass(Class cls, String name){
        if(InvertRobot.class.equals(cls)) return new InvertRobot(name);
        if(UpperCountRobot.class.equals(cls)) return new UpperCountRobot(name);
        return null;
    }
}
