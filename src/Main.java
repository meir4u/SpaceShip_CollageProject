import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final String FILE_FOLDER = "data/";
        final String PHASE_1_FILE_PRICE = FILE_FOLDER + "phase-1.txt";
        final String PHASE_2_FILE_PRICE = FILE_FOLDER + "phase-2.txt";
        final String PHASE_1_FILE = FILE_FOLDER + "phase-1_noPrice.txt";
        final String PHASE_2_FILE = FILE_FOLDER + "phase-2_noPrice.txt";

        int[] costU1 = {0};
        int[] costU2 = {0};
        String answer, fileNameP1, fileNameP2;

        Scanner in = new Scanner(System.in);
        Simulation sim = new Simulation();

        //answer = menu(in);

        while(!(answer = menu(in)).equalsIgnoreCase("q")) {

            fileNameP1 = (answer.equals("1")) ? PHASE_1_FILE : PHASE_1_FILE_PRICE;
            fileNameP2 = (answer.equals("1")) ? PHASE_2_FILE : PHASE_2_FILE_PRICE;

            costU1[0] = costU2[0] = 0;


            /*
            * calc first phase for U1 and U2
            * */

            calcCost(costU1, costU2, fileNameP1, sim);

            /*
             * calc second phase for U1 and U2
             * */
            calcCost(costU1, costU2, fileNameP2, sim);

            /*
            * print total cost
            * */
            printTotalCost(costU1[0],costU2[0]);

        }

        System.out.println("Program ENDED!");

    }

    public static void calcCost(int[] cost1, int[] cost2, String fileName, Simulation sim){
        sim.setItems(fileName);

        cost1[0] += sim.runSimulation("U1");
        cost2[0] += sim.runSimulation("U2");
    }

    public static void printTotalCost(int cost1, int cost2){
        System.out.println("");
        System.out.println("cost for rocket U1: " + cost1);
        System.out.println("cost for rocket U2: " + cost2);
    }

    public static String menu(Scanner in){
        String answer;
        int error = 0;
        do{
            System.out.println("");
            if(error++ == 1)
                System.out.println("Please enter only options from the menu!!!");
            System.out.println("");
            System.out.println("To calculate file with price enter - 1");
            System.out.println("To calculate file with price enter - 2");
            System.out.println("To exit press - q");
            answer = in.nextLine();

        }while(!answer.equalsIgnoreCase("1") &&
                !answer.equalsIgnoreCase("2")  &&
                !answer.equalsIgnoreCase("q") );



        return answer;
    }
}
