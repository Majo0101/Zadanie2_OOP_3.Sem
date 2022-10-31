import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileSave extends FileRead{

    ArrayList<TaskData> dataProcessed;
    FileWriter completedTask;
    FileWriter uncompletedTask;

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
//        Napisat kod pre rozdelenie a ulozenie do suborov

//        FileWriter myWriter = new FileWriter("filename.txt");
//        myWriter.write("Files in Java might be tricky, but it is fun enough!");
//        myWriter.close();
//        System.out.println("Successfully wrote to the file.");
    }

    public ArrayList<TaskData> getDataProcessed() {
        return dataProcessed;
    }
}
