import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;

public class FileRead {
//    TODO Object - Read file to stack(ArrayList) and sort

    private final ArrayList<TaskData> dataRaw;
    private final ArrayList<TaskData> tmpHigh;
    private final ArrayList<TaskData> tmpLow;

    public FileRead() {
//        TODO Constructor - FileRead
        this.dataRaw = new ArrayList<TaskData>();
        this.tmpHigh = new ArrayList<TaskData>();
        this.tmpLow = new ArrayList<TaskData>();
    }

    public void sortByPriority(){
//        TODO Function - Sort data from main stack by priority to High and low stack
        for (TaskData i : dataRaw){
            if (i.priority){
                tmpHigh.add(i);
            }
        }
//        Parser high priority

        for (TaskData i : dataRaw){
            if (!i.priority){
                tmpLow.add(i);
            }
        }
//        Parser Low priority
        dataRaw.clear();
    }

    public void sortByDate(){
//        TODO Function - Sort data by date separately in high and low priority stacks
        Collections.sort(tmpLow, new Comparator<TaskData>(){
            public int compare(TaskData s1, TaskData s2) {
                return s1.getDateOpen().compareTo(s2.getDateOpen());
            }
        });
//        Low priority sort by date

        Collections.sort(tmpHigh, new Comparator<TaskData>(){
            public int compare(TaskData s1, TaskData s2) {
                return s1.getDateOpen().compareTo(s2.getDateOpen());
            }
        });
//        High priority sort by date

        dataRaw.addAll(tmpHigh);
        dataRaw.addAll(tmpLow);
//        Copy data from temporary stacks to main stack

        tmpLow.clear();
        tmpHigh.clear();
//        clear temporary stacks
    }

    public String readFile(String fileName){
//        TODO Function - Read data from file to stack
        int lineCounter = 0;
        try{
            FileReader fileR = new FileReader(fileName);
            BufferedReader buffR = new BufferedReader(fileR);

            String line = buffR.readLine();
            while(line != null){
                String[] lineArr = line.split(",");
                lineCounter++;

                try{
                    dataRaw.add(new TaskData(lineArr[0], lineArr[1], lineArr[2], (lineArr[3].equals("C") || lineArr[3].equals("c")), (lineArr[4].equals("Y") || lineArr[4].equals("y"))));
                }catch (Exception e){
                    e.printStackTrace();
                    dataRaw.add(new TaskData(lineArr[0], "Broken DATA at line" + lineCounter, "Error", true, true));
                }
//                Every line creates object to ArrayList. Protected by try/catch
                line = buffR.readLine();
            }
        } catch(FileNotFoundException e) {
            return "File not found";
        } catch (Exception e){
            return "Error while reading";
        }

        sortByPriority();
//        Call sort function with priority
        sortByDate();
//        Call sort function with date

        return "File was read";
    }

//    Getters
    public ArrayList<TaskData> getDataRaw() {
        return dataRaw;
    }
}
