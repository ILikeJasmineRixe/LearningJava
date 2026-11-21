
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

        // DEBUG:
        void salty() {
            System.out.println(Arrays.toString(salt));
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

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_BITS);
        /* */
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            hash = f.generateSecret(spec).getEncoded();
            accounts.put(email, new Account(salt, hash, message));
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            spec.clearPassword();
        }
    }

    /*
    static String newHash(String password) {
        
    }
     */
    public static void main(String[] args) throws Exception {

        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;
            char selection;
            String[] loginTemp = {"", ""};
            String[] createTemp = {"", "", ""};

            do {
                System.out.println("What action would you like to perform?\n\t- (L) Login\n\t- (C) Create an account\n\t- (E) Exit");
                selection = input.next().charAt(0);
                if ((selection == 'C') || (selection == 'c')) {
                    System.out.print("\nWelcome to the account creation interface. Please provide the following information to create your account:\n\t- Email Address: ");
                    createTemp[0] = input.next();

                    System.out.print("\t- Password: ");
                    createTemp[1] = input.next();

                    System.out.print("\t- Your Secret Message (shush!): ");
                    createTemp[2] = input.next();
 
                    createAccount(
                        createTemp[0], 
                        createTemp[1], 
                        createTemp[2]
                    );

                    // DEBUG:
                    System.out.println(accounts.get(createTemp[0]));

                } else if ((selection == 'L') || (selection == 'l')) {

                    System.out.print("\nWelcome! Please provide the flolowing information to access your account:\n\t- Email Address: ");
                    loginTemp[0] = input.next();

                    System.out.print("\t- Password: ");
                    loginTemp[1] = input.next();

                    // this lwk just makes sure theyre account exists
                    if (accounts.containsKey(loginTemp[0])) {
                        
                        // accounts.getValue(loginTemp[0]);
                        // The method getValue(String) is undefined for the type HashMap<String,betterLoginHashThing.Account>
                        /* 
                            ok the issue here is we have to access this object, but it was initialized inside a hashmap,
                            meaning to access it we must first pull its name from the value of a key (user's email) in our hashmap
                            i cant figure out how to access and pull it out with differing types.
                        */


                    } else {
                        System.out.println("Account does not exist, please try again later.");
                    }

                } else if ((selection == 'E') || (selection == 'e')) {
                    exit = true;
                }

            } while (!exit);
        }

    }
}
