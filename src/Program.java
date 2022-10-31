public class Program extends FileSave {

    public Program(){
    }

    public TaskData showTask(){
        if (dataRaw.size() != 0){
            return dataRaw.get(0);
        }else{
            return null;
        }
    }

    public void processed(){
//      Spracuj ulohu
    }

    public void postponed(){
//        odloz ulohu
    }

    public void canceled(){
//        zamietnut ulohu
    }

    public void refused(){

    }

}
