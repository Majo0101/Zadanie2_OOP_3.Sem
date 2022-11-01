import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileSave extends FileRead{

    private final ArrayList<TaskData> dataProcessed;
    private FileWriter completedTask;
    private FileWriter uncompletedTask;

    public FileSave(){
        this.dataProcessed = new ArrayList<TaskData>();

        try {
            this.completedTask = new FileWriter("Completed_Tasks.csv",true);
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            this.uncompletedTask = new FileWriter("Uncompleted_Tasks.csv", true);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fileSave(){
        String tmpDateIn;
        String tmpDateOut;
        SimpleDateFormat dateCreated =new SimpleDateFormat("HH:mm-dd/MM/yyyy");
        SimpleDateFormat dateClosed =new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        for (TaskData i : dataProcessed){
            tmpDateIn = dateCreated.format(i.getDateOpen());
            tmpDateOut = dateClosed.format(i.getDateClose());

            try{
                completedTask.write(tmpDateIn
                        + ","
                        + i.getStatus()
                        + ","
                        + i.getDescription()
                        + ","
                        + ((i.isType()) ? "C":"A")
                        + ","
                        + ((i.isPriority()) ? "Y":"N")
                        + ","
                        + "Closed: "
                        + tmpDateOut +"\n");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if (getDataRaw().size() != 0){
            for (TaskData i : getDataRaw()){
                tmpDateIn = dateCreated.format(i.getDateOpen());

                try {
                    uncompletedTask.write(tmpDateIn
                            + ","
                            + i.getStatus()
                            + ","
                            + i.getDescription()
                            + ","
                            + ((i.isType()) ? "C":"A")
                            + ","
                            + ((i.isPriority()) ? "Y":"N")
                            + "\n");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        try{
            completedTask.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            uncompletedTask.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        dataProcessed.clear();
        getDataRaw().clear();
    }

    public ArrayList<TaskData> getDataProcessed() {
        return dataProcessed;
    }
}