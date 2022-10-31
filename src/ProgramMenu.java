import java.util.Scanner;
import java.util.InputMismatchException;

public class ProgramMenu {

    Program program;
    Scanner userInput;
    String userChoice;

    public ProgramMenu() {
        this.program = new Program();
        this.userInput = new Scanner(System.in);
    }

    public void run(){

        while (true){
            System.out.println("MENU:");
            System.out.println("a - Read file");
            System.out.println("b - Ticket agent");
            System.out.println("x - Save & Exit");

            userChoice = userInput.nextLine();

            if (userChoice.equals("a") || userChoice.equals("A")){
                System.out.println("Enter a file name.");
                userChoice = userInput.nextLine();
                System.out.println(program.readFile(userChoice));
                userChoice = "";
            }

            if (userChoice.equals("b") || userChoice.equals("B")){
                if(program.showTask() != null){
                    while (true){
                        System.out.print("TICKET: " + ((program.showTask().type) ? "Complaint" : "Administrative"));
                        System.out.print("   PRIORITY: " + ((program.showTask().priority) ? "High" : "Normal"));
                        System.out.println("   TICKETS: " + program.dataRaw.size());

                        System.out.println("DESCRIPTION: " + program.showTask().description);

                        if (program.showTask().type){
                            System.out.println("Menu: a - Process  |  b - Postpone  |  c - Cancel  |  d - Refuse  |  x - Back");
                        }else{
                            System.out.println("Menu: a - Process  |  b - Postpone  |  c - Cancel  |  x - Back");
                        }

                        userChoice = userInput.nextLine();

                        if (userChoice.equals("a") || userChoice.equals("A")){
                            program.processed();
                        }

                        if (userChoice.equals("b") || userChoice.equals("B")){
                            program.postponed();
                        }

                        if (program.showTask().type){
                            if (userChoice.equals("c") || userChoice.equals("C")){
                                program.canceled();
                            }
                        }

                        if (userChoice.equals("d") || userChoice.equals("D")){
                            program.refused();
                        }

                        if (userChoice.equals("x") || userChoice.equals("X")){
                            userChoice = "";
                            break;
                        }
                    }
                }else{
                    System.out.println("No tickets");
                }
            }

            if (userChoice.equals("x") || userChoice.equals("X")){
                program.fileSave();
                userChoice = "";
                break;
            }
        }
    }
}
