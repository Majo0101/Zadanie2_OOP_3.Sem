import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {

    private final ArrayList<TaskData> dataRaw;

    public FileRead() {
        this.dataRaw = new ArrayList<TaskData>();
    }

    public void sortBy(){
//        vymysliet triedenie podla priority a datumu v stacku
    }

    public String readFile(String fileName){
        try{
            FileReader fileR = new FileReader(fileName);
            BufferedReader buffR = new BufferedReader(fileR);

            String line = buffR.readLine();

            while(line != null){
                String[] lineArr = line.split(",");


//                bezpecne naladovat data do objektu
                dataRaw.add(new TaskData(lineArr[0], lineArr[2], lineArr[1], false, true));

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
