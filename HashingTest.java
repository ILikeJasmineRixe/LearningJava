
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashingTest {

    static final int ITERATIONS = 600000;
    static final int KEY_BITS = 256;

    static byte[] derive(char[] password, byte[] salt, int iterations) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, KEY_BITS);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            return f.generateSecret(spec).getEncoded();
        } finally {
            spec.clearPassword();
        }
    }

    static String create(String email, String password) throws Exception {
        int i;
        for (i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                // System.out.println(email);
                break;
                
            }
        }
        byte[] salt = email.substring(0, i).getBytes(StandardCharsets.UTF_8);
        char[] charedPassword = password.toCharArray();

        PBEKeySpec spec = new PBEKeySpec(charedPassword, salt, ITERATIONS, KEY_BITS);
        /* */
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] dk = f.generateSecret(spec).getEncoded();

            new SecureRandom().nextBytes(salt);
            Base64.Encoder b64 = Base64.getEncoder().withoutPadding();
            return ITERATIONS + ":" + b64.encodeToString(salt) + ":" + b64.encodeToString(dk);
        } finally {
            spec.clearPassword();
        }

        // System.out.println(email + password);
    }

    public static void main(String[] args) throws Exception {
        Dictionary<String, String> hashes = new Hashtable<>();
        Scanner input = new Scanner(System.in);
        String[] temp = {"", ""};
        char selection;
        boolean exit = false;
        String message;

        while (!exit) {
            System.out.print("Would you like to create an account? (C) or Login to an account? (L) or Exit (E)\t");
            selection = input.next().charAt(0);

            if ((selection == 'c') || (selection == 'C')) {

                System.out.print("Please Provide an Email: ");
                temp[0] = input.next(); // email
                System.out.print("Please Provide a Password: ");
                temp[1] = input.next(); // password

                System.out.print("What Message Does Your Account Say? ");
                message = input.next();

                hashes.put(create(temp[0], temp[1]), message);

                System.out.println(hashes);

                // System.out.println("Created");
            } else if ((selection == 'l') || (selection == 'L')) {

                // System.out.println("Logged");
            } else if ((selection == 'e') || (selection == 'E')) {
                exit = true;
            } else {
                System.out.println("Please select a valid option");
            }
        }
    }
}
