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

    public void readFile(String fileName){
        try{
            this.fileR = new FileReader(fileName);
            this.buffR = new BufferedReader(fileR);

            String line = buffR.readLine();

            while(line != null){
                String[] lineArr = line.split(",");


//                bezpecne naladovat data do objektu
                dataRaw.add(new TaskData(lineArr[0], lineArr[1], lineArr[2], false, false));

                line = buffR.readLine();
            }
        } catch(Exception e) {
            System.out.println("Nepodarilo sa nacitat subor");
        }
    }

    public ArrayList<TaskData> getDataRaw() {
        return dataRaw;
    }
}
