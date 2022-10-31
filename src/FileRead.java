import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {

    ArrayList<TaskData> dataRaw;
    BufferedReader buffR;
    FileReader fileR;

    public FileRead() {
        this.dataRaw = new ArrayList<TaskData>();
    }

    public void sortBy(){
//        vymysliet triedenie podla priority a datumu v stacku
    }

    public String readFile(String fileName){
        try{
            this.fileR = new FileReader(fileName);
            this.buffR = new BufferedReader(fileR);

            String line = buffR.readLine();

            while(line != null){
                String[] lineArr = line.split(",");


//                bezpecne naladovat data do objektu
                dataRaw.add(new TaskData(lineArr[0], lineArr[2], lineArr[1], true, true));

                line = buffR.readLine();
            }
        } catch(FileNotFoundException e) {
            return "File not found";
        } catch (Exception e){
            return "Error while reading";
        }
        return "File was read";
    }

    public ArrayList<TaskData> getDataRaw() {
        return dataRaw;
    }
}
