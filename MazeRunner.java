import java.util.*;
public class MazeRunner {
    public static Maze myMap = new Maze();
    public static int stepCount = 0;
    public static void main(String[] args) {
        intro();
        myMap.printMap();
        System.out.println("Where would you like to move ? ( R, L, U, D) ");
    }
    public static void intro() {
        System.out.println("Welcome to the Maze!");
        System.out.println("Here is your current position.");
        myMap.printMap();
    }
    public static String userMove(){
        Scanner input = new Scanner(System.in);
        String direction = "";
        do{
            if(MazeRunner.userSteps != 101)
            {
                System.out.print("Where would you like to move? (R, L, U, D)    ");
                direction = input.next();
            }

            if(direction.equals("R") || direction.equals("L") || direction.equals("U") || direction.equals("D")) {
                //Part 2 – Move Limit
                movesMessage(++MazeRunner.userSteps);

                if (myMap.canIMoveRight() == true && direction.equals("R")) {
                    myMap.moveRight();
                }
                else if (myMap.canIMoveLeft() == true && direction.equals("L")) {
                    myMap.moveLeft();
                }
                else if (myMap.canIMoveUp() == true && direction.equals("U")) {
                    myMap.moveUp();
                }
                else if (myMap.canIMoveDown() == true && direction.equals("D")) {
                    myMap.moveDown();
                }
                else {
                    if (MazeRunner.userSteps != 101) {
                        System.out.println("Sorry, you've hit a wall.");
                        System.out.print("Where would you like to move? (R, L, U, D)    ");
                        direction = input.next();
                        //Part 2 – Move Limit
                        movesMessage(++MazeRunner.userSteps);
                    }
                }

                myMap.printMap();
                break;
            }
        } while(direction.matches("[RLUD]") == false);

        return direction;
}

