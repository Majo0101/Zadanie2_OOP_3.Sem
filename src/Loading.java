public class Loading {

    public Loading() {}

    private final StringBuilder loadBar = new StringBuilder("[          ]");
    private final StringBuilder saveBar = new StringBuilder("[          ]");

    public int loadingBar(int i){
        if (i <= 100){
            if ((i % 10) == 0){
                loadBar.setCharAt(i/10, '=');
            }
            System.out.print(loadBar + " " + i + "%  Loading FIKTIV s.r.o." + "\r");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.print(loadBar + " " + "ERROR!  Loading FIKTIV s.r.o." + "\r\n");
                System.exit(100);
            }

            return loadingBar(i + 1);
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
        if (i <= 100){
            if ((i % 10) == 0){
                saveBar.setCharAt(i/10, '=');
            }
            System.out.print(saveBar + " " + i + "%  Saving FIKTIV s.r.o." + "\r");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.print(saveBar + " " + "ERROR!  Saving FIKTIV s.r.o." + "\r\n");
                System.exit(100);
            }

            return saveBar(i + 1);
        } else {
            System.out.print(saveBar + " " + "OK!  Saved FIKTIV s.r.o.");
            return 0;
        }
    }
}
