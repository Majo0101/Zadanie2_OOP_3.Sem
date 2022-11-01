import java.util.Date;

public class Program extends FileSave {

    public Program(){
    }

    public TaskData showTask(){
        if (getDataRaw().size() != 0){
            return getDataRaw().get(0);
        }else{
            return null;
        }
    }

    public void processed(){
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Processed");
            getDataRaw().get(0).setDateClose(new Date());
            getDataProcessed().add(getDataRaw().get(0));
            getDataRaw().remove(0);
        }
    }

    public void postponed(){
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Postponed");
            getDataRaw().get(0).setDateClose(new Date());
            TaskData tmp = getDataRaw().get(0);
            getDataRaw().remove(0);
            getDataRaw().add(tmp);
        }
    }

    public void canceled(){
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Canceled");
            getDataRaw().get(0).setDateClose(new Date());
            getDataProcessed().add(getDataRaw().get(0));
            getDataRaw().remove(0);
        }
    }

    public void refused(){
        if (getDataRaw().size() != 0){
            getDataRaw().get(0).setStatus("Refused");
            getDataRaw().get(0).setDateClose(new Date());
            getDataProcessed().add(getDataRaw().get(0));
            getDataRaw().remove(0);
        }
    }
}
