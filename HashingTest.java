
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashingTest {

    static final int ITERATIONS = 600000;
    static final int KEY_BITS = 256;

    static String getHash(String email, String password) throws Exception {
        int i;
        for (i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
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
            
            do {
                System.out.print("\nWould you like to create an account? (C) or Login to an account? (L) or Exit (E)\t");
                selection = input.nextLine().charAt(0);
                
                if ((selection == 'c') || (selection == 'C')) {
                    
                    System.out.print("Please Provide an Email: ");
                    temp[0] = input.nextLine(); // email
                    System.out.print("Please Provide a Password: ");
                    temp[1] = input.nextLine(); // password
                    
                    System.out.print("What Message Does Your Account Say? ");
                    String message = input.nextLine();
                    
                    hashes.put(getHash(temp[0], temp[1]), message);
                    
                } else if ((selection == 'l') || (selection == 'L')) {
                    
                    System.out.print("Please Provide an Email: ");
                    login[0] = input.nextLine(); // email
                    System.out.print("Please Provide a Password: ");
                    login[1] = input.nextLine(); // password
                    int i;
                    for (i = 0; i < login[0].length(); i++) {
                        if (login[0].charAt(i) == '@') {
                            // System.out.println(email);
                            break;
                            
                        }
                    }
                    if (hashes.containsKey(getHash(login[0], login[1]))) {
                            System.out.println("Login Success!");
                            System.out.println("Here\'s your stored message: " + hashes.get(getHash(login[0], login[1])));
                    } else {
                        System.out.println("Login unsuccessful. Please try again");
                    }
                    
                } else if ((selection == 'e') || (selection == 'E')) {
                    exit = true;
                } else {
                    System.out.println("Please select a valid option");
                }
            } while (!exit);
        }
    }
}
