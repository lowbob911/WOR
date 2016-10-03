package by.sherby.pojo;

/**
 * Created by Sergey on 03.10.2016.
 */
public class Task {
    private Integer type;
    private String comment;

    public Task(Integer type,String comment){
        this.type=type;
        this.comment=comment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
