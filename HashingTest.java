
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashingTest {

    static final int ITERATIONS = 600000;
    static final int KEY_BITS = 256;

    static boolean verify(byte[] salt, char[] password, String stored) throws Exception {
        byte[] actual;
        String[] p = stored.split(":");
        byte[] expected = Base64.getDecoder().decode(p[2]);
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_BITS);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            actual = f.generateSecret(spec).getEncoded();
        } finally {
            spec.clearPassword();
        }
        return MessageDigest.isEqual(expected, actual);
    }
    // hashes.get(key)

    static String getHash(String email, String password) throws Exception {
        int i;
        for (i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                // System.out.println(email);
                break;

            }
        }
        byte[] salt = email.substring(0, i).getBytes(StandardCharsets.UTF_8);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_BITS);
        /* */
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] dk = f.generateSecret(spec).getEncoded();
            Base64.Encoder b64 = Base64.getEncoder().withoutPadding();
            return ITERATIONS + ":" + b64.encodeToString(salt) + ":" + b64.encodeToString(dk);
        } finally {
            spec.clearPassword();
        }

        // System.out.println(email + password);
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, String> hashes = new HashMap<>();
        try (Scanner input = new Scanner(System.in)) {
            String[] temp = {"", ""};
            String[] login = {"", ""};
            char selection;
            boolean exit = false;
            String selectedHash;
            
            while (!exit) {
                System.out.print("\nWould you like to create an account? (C) or Login to an account? (L) or Exit (E)\t");
                selection = input.next().charAt(0);
                
                if ((selection == 'c') || (selection == 'C')) {
                    
                    System.out.print("Please Provide an Email: ");
                    temp[0] = input.next(); // email
                    System.out.print("Please Provide a Password: ");
                    temp[1] = input.next(); // password
                    
                    System.out.print("What Message Does Your Account Say? ");
                    String message = input.next();
                    
                    hashes.put(getHash(temp[0], temp[1]), message);
                    
                    System.out.println("\n");
                    System.out.println(hashes);
                    System.out.println(getHash(temp[0], temp[1]));
                    System.out.println(hashes.get(getHash(temp[0], temp[1])));
                    
                    // System.out.println("Created");
                } else if ((selection == 'l') || (selection == 'L')) {
                    
                    System.out.print("Please Provide an Email: ");
                    login[0] = input.next(); // email
                    System.out.print("Please Provide a Password: ");
                    login[1] = input.next(); // password
                    /*
                    lookup = getHash(login[0], login[1]);
                    
                    if (verify(login[1].toCharArray(), getHash(login[0], login[1]))) {
                    System.out.println("Login Success!\nMessage Stored: \"" + hashes.get(lookup) "\""); // hashes.get(key)
                    }
                    */
                    int i;
                    for (i = 0; i < login[0].length(); i++) {
                        if (login[0].charAt(i) == '@') {
                            // System.out.println(email);
                            break;
                            
                        }
                    }
                    byte[] salt = login[0].substring(0, i).getBytes(StandardCharsets.UTF_8);
                    selectedHash = getHash(login[0], login[1]);
                    if (verify(salt, login[1].toCharArray(), selectedHash)) {
                        System.out.println("Login Success!");
                        System.out.println("Here\'s your stored message: " + hashes.get(selectedHash));
                    }
                    
                    // System.out.println("Logged");
                } else if ((selection == 'e') || (selection == 'E')) {
                    exit = true;
                } else {
                    System.out.println("Please select a valid option");
                }
            }
        }
    }
}
