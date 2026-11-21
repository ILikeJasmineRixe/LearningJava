
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

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
        public void oooWhatchuSayyyyyy(byte[] lookupHash) {
            if (Arrays.equals(lookupHash, hash)) {
                System.out.println(message);
            } else {
                System.out.println("Invalid credentials, please try again later.");
            }
        }
    }

    // @SuppressWarnings("unlikely-arg-type")
    static void login(String email, String password, byte[] salt) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_BITS);

        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] loginHash = f.generateSecret(spec).getEncoded();
        accounts.get(email).oooWhatchuSayyyyyy(loginHash);
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
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            spec.clearPassword();
        }
    }
    public static void main(String[] args) throws Exception {

        try (Scanner input = new Scanner(System.in)) {
            boolean exit = false;
            char selection;
            String[] loginTemp = {"", ""};
            String[] createTemp = {"", "", ""};

            do {
                System.out.println("\nWhat action would you like to perform?\n\t- (L) Login\n\t- (C) Create an account\n\t- (E) Exit");
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
                    // System.out.println(accounts.get(createTemp[0]));

                } else if ((selection == 'L') || (selection == 'l')) {

                    System.out.print("\nWelcome! Please provide the flolowing information to access your account:\n\t- Email Address: ");
                    loginTemp[0] = input.next();

                    System.out.print("\t- Password: ");
                    loginTemp[1] = input.next();

                    // this lwk just makes sure theyre account exists
                    if (accounts.containsKey(loginTemp[0])) {

                        /*
                        if (checkValidity(loginTemp[0], loginTemp[1], accounts.get(loginTemp[0]).salt)) {
                            System.out.println(accounts.get(loginTemp[0]).message);
                        } else {
                            System.out.println("Invalid credentials, please try again later");
                        }
                        */
                        login(loginTemp[0], loginTemp[1], accounts.get(loginTemp[0]).salt);

                        // The method getValue(String) is undefined for the type HashMap<String,betterLoginHashThing.Account>
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