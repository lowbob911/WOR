package by.sherby.pojo;

/**
 * Created by Sergey on 03.10.2016.
 */
public class RobotReport {
    private String result,name;

    public RobotReport(String result,String name){
        this.result=result;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
