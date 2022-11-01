import java.util.Scanner;
import java.util.InputMismatchException;

public class ProgramMenu {

    private final Program program;
    private final Scanner userInput;

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

            String userChoice;
            try{
                userChoice = userInput.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Wrong input");
                userChoice = "X";
            }

            if (userChoice.equals("a") || userChoice.equals("A")){
                System.out.println("Enter a file name.");

                try{
                    userChoice = userInput.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Wrong input");
                    userChoice = "NothingFile";
                }

                System.out.println(program.readFile(userChoice));
                userChoice = "";
            }

            if (userChoice.equals("b") || userChoice.equals("B")){

                boolean flipFlop = false;

                while (program.showTask() != null){
                    System.out.print("TICKET: " + ((program.showTask().isType()) ? "Complaint" : "Administrative"));
                    System.out.print("   PRIORITY: " + ((program.showTask().isPriority()) ? "High" : "Normal"));
                    System.out.print("   TICKETS: " + program.getDataRaw().size());
                    System.out.println("   STATUS: " + program.showTask().getStatus());

                    System.out.println("DESCRIPTION: " + program.showTask().getDescription());

                    if (program.showTask().isType()){
                        System.out.println("Menu: a - Process  |  b - Postpone  |  c - Cancel  |  d - Refuse  |  x - Back");
                        flipFlop = true;
                    }else{
                        System.out.println("Menu: a - Process  |  b - Postpone  |  c - Cancel  |  x - Back");
                        flipFlop = false;
                    }

                    try{
                        userChoice = userInput.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("Wrong input");
                        userChoice = "X";
                    }

                    if (userChoice.equals("a") || userChoice.equals("A")){
                        program.processed();
                    }

                    if (userChoice.equals("b") || userChoice.equals("B")){
                        program.postponed();
                    }

                    if (userChoice.equals("c") || userChoice.equals("C")){
                        program.canceled();
                    }

                    if (flipFlop){
                        if (userChoice.equals("d") || userChoice.equals("D")){
                            program.refused();
                        }
                    }

                    if (userChoice.equals("x") || userChoice.equals("X")){
                        userChoice = "";
                        break;
                    }
                }

                if (program.showTask() == null){
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
