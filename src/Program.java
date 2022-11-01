import java.util.Date;

public class Program extends FileSave {
//    TODO Object - Inheritance from FileSave - Main methods for work with task

    public Program(){
//        TODO Constructor - Program
    }

    public TaskData showTask(){
//        TODO Function - Read task info to console
        if (getDataRaw().size() != 0){
            return getDataRaw().get(0);
        }else{
            return null;
        }
    }

    public void processed(){
//        TODO Function - Process the task - Task moved from dataRaw to dataProcessed with new status
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Processed");
            getDataRaw().get(0).setDateClose(new Date());
            getDataProcessed().add(getDataRaw().get(0));
            getDataRaw().remove(0);
        }
    }

    public void postponed(){
//        TODO Function - Postpone the task - Task moved from top in the stack to bottom with new status
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Postponed");
            getDataRaw().get(0).setDateClose(new Date());
            TaskData tmp = getDataRaw().get(0);
            getDataRaw().remove(0);
            getDataRaw().add(tmp);
        }
    }

    public void canceled(){
//        TODO Function - Cancel the task - Task moved from dataRaw to dataProcessed with new status
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Canceled");
            getDataRaw().get(0).setDateClose(new Date());
            getDataProcessed().add(getDataRaw().get(0));
            getDataRaw().remove(0);
        }
    }

    public void refused(){
//        TODO Function - Refuse the task - Task moved from dataRaw to dataProcessed with new status
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Refused");
            getDataRaw().get(0).setDateClose(new Date());
            getDataProcessed().add(getDataRaw().get(0));
            getDataRaw().remove(0);
        }
    }
}
