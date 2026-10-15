import java.util.Random;
import java.util.Scanner;
// new Random();

class Stringssssss {
  public String[] close = {
        "So close!",
        "Dawg you\'re like right there.",
        "hes right next to me isnt he...",
        "yuh but no type shit",
        "mhm yeah right about there pal",
        "buddy, youre so close",
        "the fact that youre so close but so wrong makes me want to kill you",
        "sorry pal, but you need just one or two more tries",
        "look, i dont wanna be mean, but gng youre off by 1 :(",
        "ok. figure it out from here",
        "hot"
    };
    
    public String[] less = {
        "Yeah thats way too high gng",
        "nope, the number is less than that",
        "someones overcompensating i think",
        "thats wrong, but like becaue its TOO big",
        "wowzers, you really think i could be that tall? well im not, im shorter than that",
        "bah humbug (im short and youre wrong)",
        "go downwards pal",
        "cold",
        "youre a weirdo that picks too big of numbers"
    };

    public String[] more = {
        "cold",
        "im taller than that pal",
        "i am NOT that short",
        "are you using a different measurement or something? whats with this short ass number you just gave me",
        "too low pal",
        "stop atp, youre too low",
        "i was gonna say cold but maybe youre really close... just... less than the number",
        "you need to go UP UP AND AWAY",
        "dumbass over here thinks the number is that small?"
    };

    public String[] correct = {
        "You did it!",
        "congrats bud",
        "CONGRATULATIONS AHHHAHAHAHHAHAHA",
        "you won. the game is over, good 4 u i guess :(",
        "bueno, adios",
        "thats crazy, you actually won.",
        "i was losing hope but here we are",
        "ok",
        "good job",
        "you did it... good boy"
    };
}

public class Main {
    static final Random random = new Random();
    static final Stringssssss str = new Stringssssss();

    static void correct() {
        System.out.println(str.correct[random.nextInt(str.correct.length)]);
    }

    static void close() {
        System.out.println(str.close[random.nextInt(str.close.length)]);
    }

    static void less() {
        System.out.println(str.less[random.nextInt(str.less.length)]);
    }

    static void more() {
        System.out.println(str.more[random.nextInt(str.more.length)]);
    }

  public static void main(String[] args) {

    if (args[0].equals("game")) {
      int randomNumber = (int) (Math.random() * 101);
      Scanner scanner = new Scanner(System.in);
      boolean correct = false;
      int attemptsCount = 0;
      while (correct == false) {
        System.out.print("\nGuess? ");
        int guess = scanner.nextInt();
        attemptsCount++;

        if (guess == (randomNumber + 1) || guess == (randomNumber - 1)) {
          close();
          continue;
        } else if (guess > randomNumber) {
          less();
          continue;
        } else if (guess < randomNumber) {
          more();
          continue;
        } else if (guess == randomNumber) {
          correct();
          break;
        }

        correct = true;
      }
      System.out.println("\nYou did it! Only took " + attemptsCount + " tries!");

    } else if (args[0].equals("name")) {
      if (args.length == 2) {
        System.out.println("Hello, " + args[1] + "!");
      } else {
        System.out.println("You must provide a name silly!");
      }
    }
  }
}