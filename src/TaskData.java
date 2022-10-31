import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class TaskData {

    String description;
    String status;
    boolean type;
    boolean priority;
    Date date;

    public TaskData(String dateStr, String description, String status,boolean type,boolean priority){
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.type = type;

        try{
            SimpleDateFormat formatter=new SimpleDateFormat("HH:mm-dd/MM/yyyy");
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Broken data !");
        }
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public boolean isPriority() {
        return priority;
    }

    public Date getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
