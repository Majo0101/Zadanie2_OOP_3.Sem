public class Main {
    public static void main(String[] args){

    Loading loading = new Loading();
    ProgramMenu fiktiv = new ProgramMenu();

    loading.loadingBar(1);        //Fake loading for fun- Recursion in JAVA with Thread.sleep
    fiktiv.run();                   //Run Fiktiv s.r.o. software
    loading.saveBar(1);          //Fake loading
    }
}
