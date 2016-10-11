package by.sherby.pojo;

import by.sherby.robots.Robot;

/**
 * Created by Sergey on 11.10.2016.
 */
public class Robot4List {
    String name;
    Integer type;

    public Robot4List(String name,Integer type){
        this.name=name;
        this.type=type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
