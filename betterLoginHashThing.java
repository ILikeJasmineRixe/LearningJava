import java.util.*;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class betterLoginHashThing {
    static final int ITERATIONS = 600000;
    static final int KEY_BITS = 256;

    class Account {
        private String email;
        private String hash;
        private String secretMessage;

        void Account(String email, String hash, String secretMessage) {
            this.email = email;
            this.hash = hash;
            this.secretMessage = secretMessage;
        }
        /*
        public String lookup(String email) {
            return hash;
        }
        */
        public String oooWhatchuSayyyyyy(String email, String hash) {
            return secretMessage;
        }
    }

    /*
    static String newHash(String password, byte[] salt) {
        
    }
    */
    
    public static void mai (String[] args) {

        HashMap<String, String> creds = new HashMap<>();

        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;
            char selection;
            String[] loginTemp = {"",""};

            do {
                System.out.println("What action would you like to perform?\n\t- (L) Login\n\t- (C) Create an account\n\t- (E) Exit");
                selection = input.next().charAt(0);
                if ((selection == 'C') || (selection == 'c')) {
                    // ask for email -> temp[0]
                    // ask for password -> temp[1]
                    // 
                    
                } else if ((selection == 'L') || (selection == 'l')) {
                    
                } else if ((selection == 'E') || (selection == 'e')) {
                    exit = true; 
                }
                
            } while (!exit);
        }

    }
}

















