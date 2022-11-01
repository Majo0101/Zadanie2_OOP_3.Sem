import java.util.Scanner;
import java.util.InputMismatchException;

public class ProgramMenu {
//    TODO Object - Console menu whe app is running

    private final Program program;
    private final Scanner userInput;

    public ProgramMenu() {
//        TODO Constructor - ProgramMenu
        this.program = new Program();
        this.userInput = new Scanner(System.in);
    }

    public void run(){
//        TODO Function - Menu loops for console
        while (true){
//            TODO While loop - Main Menu
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
//            User input - choice Main Menu

            if (userChoice.equals("a") || userChoice.equals("A")){
                System.out.println("Enter a file name.");

                try{
                    userChoice = userInput.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Wrong input");
                    userChoice = "NothingFile";
                }
//                User input - File name

                System.out.println(program.readFile(userChoice));
                userChoice = "";
            }

            if (userChoice.equals("b") || userChoice.equals("B")){

                boolean flipFlop;

                while (program.showTask() != null){
//                    TODO While loop - Task Menu
                    System.out.print("TICKET: " + ((program.showTask().isType()) ? "Complaint" : "Administrative"));
                    System.out.print("   PRIORITY: " + ((program.showTask().isPriority()) ? "High" : "Normal"));
                    System.out.print("   TICKETS: " + program.getDataRaw().size());
                    System.out.println("   STATUS: " + program.showTask().getStatus());

                    System.out.println("DESCRIPTION: " + program.showTask().getDescription());

                    if (program.showTask().isType()){
//                        Show different options for Tasks
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
//                    user input - choice Task Menu

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
//                    End Task Menu
                    System.out.println("No tickets");
                }
            }

            if (userChoice.equals("x") || userChoice.equals("X")){
//                End Main Menu
                program.fileSave();
                break;
            }
        }
    }
}
