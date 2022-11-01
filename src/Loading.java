public class Loading {
//    TODO Object - Fake loader for fun

    private final StringBuilder loadBar;
    private final StringBuilder saveBar;

    public Loading() {
//        TODO Constructor - Loading
        this.loadBar = new StringBuilder("[          ]");
        this.saveBar = new StringBuilder("[          ]");
    }

    public int loadingBar(int i){
//        TODO Function - FAKE Loading App
        if (i <= 100){
            if ((i % 10) == 0){
                loadBar.setCharAt(i/10, '=');
//                Progress Bar
            }
            System.out.print(loadBar + " " + i + "%  Loading FIKTIV s.r.o." + "\r");
//            Print Percentage from Recursion and Progress bar

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.print(loadBar + " " + "ERROR!  Loading FIKTIV s.r.o." + "\r\n");
                System.exit(100);
            }

            return loadingBar(i + 1);
//            TODO Recursion loading
        } else {
            System.out.print(loadBar + " " + "OK!  Loading FIKTIV s.r.o." + "\r");

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.print(loadBar + " " + "ERROR!  Loading FIKTIV s.r.o." + "\r\n");
                System.exit(100);
            }

            System.out.println("=================FIKTIV=================\n");
            return 0;
        }
    }

    public int saveBar(int i){
//        TODO Function - FAKE Saving App
        if (i <= 100){
            if ((i % 10) == 0){
                saveBar.setCharAt(i/10, '=');
//                Progress Bar
            }
            System.out.print(saveBar + " " + i + "%  Saving FIKTIV s.r.o." + "\r");
//            Print Percentage from Recursion and Progress bar

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.print(saveBar + " " + "ERROR!  Saving FIKTIV s.r.o." + "\r\n");
                System.exit(100);
            }

            return saveBar(i + 1);
//            TODO Recursion saving
        } else {
            System.out.print(saveBar + " " + "OK!  Saved FIKTIV s.r.o.");
            return 0;
        }
    }
}
