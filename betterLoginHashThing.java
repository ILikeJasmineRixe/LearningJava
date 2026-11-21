import java.util.*;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

public class betterLoginHashThing {
    static SecureRandom superveryrandomsecurelol = new SecureRandom();
    static HashMap<String, Account> accounts = new HashMap<>();

    static final int ITERATIONS = 600000;
    static final int KEY_BITS = 256;

    static class Account {
        private byte[] salt;
        private byte[] hash;
        private String message;

        public Account(byte[] salt, byte[] hash, String message) {
            this.salt = salt;
            this.hash = hash;
            this.message = message;
        }
        /*
        public String lookup(String email) {
            return hash;
        }
        */
        public String oooWhatchuSayyyyyy(String lookupEmail, byte[] lookupHash) {

            return message;
        }
    }

    static void createAccount(String email, String password, String message) throws Exception {
        byte[] hash;
        byte[] randomBytes = new byte[8];
        superveryrandomsecurelol.nextBytes(randomBytes);
        byte[] salt = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes).getBytes(StandardCharsets.UTF_8);

        accounts.put(email, new Account(salt, hash, message));
    }

    /*
    static String newHash(String password) {
        
    }
    */
    
    public static void mai (String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;
            char selection;
            String[] loginTemp = {"",""};
            String[] createTemp = {"","",""};

            do {
                System.out.println("What action would you like to perform?\n\t- (L) Login\n\t- (C) Create an account\n\t- (E) Exit");
                selection = input.next().charAt(0);
                if ((selection == 'C') || (selection == 'c')) {
                    System.out.print("\nWelcome to the account creation interface. Please provide the following information to create your account:\n\t- Email Address: ");
                    createTemp[0] = input.next();
                    System.out.print("\n\t- Password: ");

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

















