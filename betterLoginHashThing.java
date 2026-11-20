import java.util.*;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class betterLoginHashThing {
    static final int ITERATIONS = 600000;
    static final int KEY_BITS = 256;

    class Account {
        //
    }

    static String getHash(String password) {
        //
    }
    
    public static void mai (String[] args) {

        HashMap<String, String> creds = new HashMap<>();
        
        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;
            char selection;

            do {
                System.out.println("What action would you like to perform?\n\t- (L) Login\n\t- (C) Create an account\n\t- (E) Exit");
                selection = input.next().charAt(0);
                if ((selection == 'C') || (selection == 'c')) {
                    
                } else if ((selection == 'L') || (selection == 'l')) {
                    
                } else if ((selection == 'E') || (selection == 'e')) {
                    exit = true; 
                }
                
            } while (!exit);
        }

    }
}

















