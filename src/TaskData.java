import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TaskData {
//    TODO Object - Data object for tasks

    String description;
    String status;
    boolean type;
    boolean priority;
    Date dateOpen;
    Date dateClose;

    public TaskData(String dateStr, String description, String status,boolean type,boolean priority){
//        TODO Constructor - TaskData
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.type = type;

        try{
            SimpleDateFormat formatter=new SimpleDateFormat("HH:mm-dd/MM/yyyy");
            dateOpen = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            dateOpen = new Date();
            this.description = this.description + " - Wrong DATE";
        }
//        Parse date from String to Date object

        if (type){
            try{
                Calendar addDays = Calendar.getInstance();
                addDays.setTime(new Date());
                addDays.add(Calendar.DATE, -15);

                Date dateComp = addDays.getTime();

                if (dateOpen.compareTo(dateComp) < 0){
                    this.priority = true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
//        Compare date with Actual date - 15 days. Older Complaint tasks will be High Priority
    }

//    Getters and Setters

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public boolean isPriority() {
        return priority;
    }

    public boolean isType() {
        return type;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
