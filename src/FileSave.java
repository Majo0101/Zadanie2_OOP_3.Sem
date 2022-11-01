import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileSave extends FileRead{
//    TODO Object - Inheritance from FileRead - Save data to files separately by Completed and Uncompleted tasks

    private final ArrayList<TaskData> dataProcessed;
    private FileWriter completedTask;
    private FileWriter uncompletedTask;

    public FileSave(){
//        TODO Constructor - FileSave
        this.dataProcessed = new ArrayList<TaskData>();

        try {
            this.completedTask = new FileWriter("Completed_Tasks.csv", true);
        }catch (IOException e){
            e.printStackTrace();
        }
//        Create file Completed tasks file with writing to the end

        try{
            this.uncompletedTask = new FileWriter("Uncompleted_Tasks.csv");
        }catch (IOException e){
            e.printStackTrace();
        }
//        Create file Uncompleted tasks with overwriting old data
    }

    public void fileSave(){
//        TODO Function - Save data to file - Processed data do Completed, Raw to uncompleted
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
//        Parse completed task to file with processing date

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
//        Parse Uncompleted task to file

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
//        Clear stacks
    }

//    Getters
    public ArrayList<TaskData> getDataProcessed() {
        return dataProcessed;
    }
}