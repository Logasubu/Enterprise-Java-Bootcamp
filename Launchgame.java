import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Art{
	
String logo = "\r\n" + 
		".___                                             ________                            .__                   ________                        \r\n" + 
		"|   | ____   ____  __ _________  ____   ____    /  _____/ __ __   ____   ______ _____|__| ____    ____    /  _____/_____    _____   ____   \r\n" + 
		"|   |/    \\_/ __ \\|  |  \\_  __ \\/  _ \\ /    \\  /   \\  ___|  |  \\_/ __ \\ /  ___//  ___/  |/    \\  / ___\\  /   \\  ___\\__  \\  /     \\_/ __ \\  \r\n" + 
		"|   |   |  \\  ___/|  |  /|  | \\(  <_> )   |  \\ \\    \\_\\  \\  |  /\\  ___/ \\___ \\ \\___ \\|  |   |  \\/ /_/  > \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  \r\n" + 
		"|___|___|  /\\___  >____/ |__|   \\____/|___|  /  \\______  /____/  \\___  >____  >____  >__|___|  /\\___  /   \\______  (____  /__|_|  /\\___  > \r\n" + 
		"         \\/     \\/                         \\/          \\/            \\/     \\/     \\/        \\//_____/           \\/     \\/      \\/     \\/  \r\n" + 
		"";
void instructions() throws InterruptedException 
{
	System.out.println("Welcome to Ineuron Guessing Game !!. Please read below Instructions...");
	TimeUnit.SECONDS.sleep(2);
	System.out.println(" ");
	System.out.println("This game consist of Two Difficulty levels...");
	TimeUnit.SECONDS.sleep(2);
	System.out.println(" ");
	System.out.println("The Player will be allowed to decide which level to be played...");
	TimeUnit.SECONDS.sleep(2);
	System.out.println(" ");
	System.out.println("This is a single player game...");
	TimeUnit.SECONDS.sleep(2);
	System.out.println(" ");
	System.out.println("The player will be given some attempts depending on the difficulty level to guess the Number...");
	TimeUnit.SECONDS.sleep(2);
	System.out.println(" ");
	System.out.println("Guess the number and Beat the Machine !! Best of Luck !! ...");
	TimeUnit.SECONDS.sleep(2);
	System.out.println(" ");
}

}
class Set_Difficulty{
    String choice;
    int EASY_LEVEL_TURNS = 10;
    int HARD_LEVEL_TURNS = 5;
    int difficulty()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Choose a difficulty. Type 'easy' or 'hard': ");
        System.out.println(" ");
        choice=scan.next();
        if(choice.equals("easy"))
        {
            System.out.println(" ");
            System.out.println("You have chosen Easy option !! ");
            System.out.println(" ");
            return EASY_LEVEL_TURNS;
        }
        else
        {
            System.out.println(" ");
            System.out.println("You have chosen Hard option !! ");
            System.out.println(" ");
            return HARD_LEVEL_TURNS;
        }
    }
}
class Guesser
{
    int guessNum;
    public int guessNumber()
    {
        Random random = new Random();
        guessNum=random.nextInt(100);
        return guessNum;
    }
}

class Game {
    int check_answers(int numFromPlayer, int numFromGuesser, int turn)
    {
        if(numFromPlayer > numFromGuesser)
        {
            System.out.println("Oops !! Guessed number is too High. Try guessing is it correctly ...");
            System.out.println(" ");
            return turn -1 ;
        }
        else if(numFromPlayer < numFromGuesser)
        {
            System.out.println("Oops !! Guessed number is too Low. Try guessing is it correctly ...");
            System.out.println(" ");
            return turn -1 ;
        }
        else
        {
            System.out.println("You have got it !!. The correct answer was " + numFromGuesser);
            System.out.println(" ");
        }
        return turn;
    }
}

class Umpire
{
    int numFromGuesser;
    void compare() {
        Guesser g=new Guesser();
        numFromGuesser=g.guessNumber();
        Set_Difficulty s = new Set_Difficulty();
        int turn_check = s.difficulty();
        int numFromPlayer = 0;
        while(numFromPlayer != numFromGuesser)
        {
            System.out.println("You have " + turn_check + "  attempts remaining to guess the number");
            System.out.println(" ");
            Scanner scan=new Scanner(System.in);
            System.out.print("Guess the number : ");
            System.out.println(" ");
            numFromPlayer = scan.nextInt();
            Game game = new Game();
            int attempts = game.check_answers(numFromPlayer, numFromGuesser, turn_check);
            if (attempts == 0)
            {
                System.out.println("You've run out of guesses, you lose.");
                break;
            }
            else if (numFromPlayer != numFromGuesser)
            {
                System.out.println("Guess again.");
                System.out.println(" ");
                turn_check -= 1;
            }
            
        }
    }
}

public class Launchgame {

    public static void main(String[] args) throws InterruptedException {
        Art a = new Art();
        System.out.print(a.logo);
        System.out.println(" ");
        a.instructions();
        Umpire u=new Umpire();
        u.compare();
    }
}