public class Main {
    public static void main(String[] args){

    Loading loading = new Loading();
    ProgramMenu fiktiv = new ProgramMenu();

    loading.loadingBar(1);
//    TODO Run loading recursion with Thread.sleep()
    fiktiv.run();
//    TODO Run Main Fiktiv s.r.o. APP
    loading.saveBar(1);
//    TODO Run loading recursion if Main APP was ended
    }
//    AUTHOR Marian Bodnar - bmcode.sk
}
