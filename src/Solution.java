import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Solution {
    private static final Scanner sc = new Scanner(System.in, "cp866");

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println("Enter 1 to crypt\nEnter 2 to encrypt");
        if (sc.hasNextInt()) {
            int isOne = sc.nextInt();
            if (isOne == 1) {
                Crypt.crypt(getData(), getKey1(), getKey2(), DataGen.secretKey());
            } else {
                if (isOne == 2) Encrypt.encrypt(getData(), getSeed());
                else System.out.println("Enter 1 or 2");
            }
        } else System.out.println("Try again, enter 1 or 2");
    }

    private static String getData() {
        System.out.println("Enter data");
        String skip = sc.nextLine();
        return sc.nextLine().trim();
    }

    private static long getKey1() {
        System.out.println("Enter key 1");
        return sc.nextLong();
    }

    private static long getKey2() {
        System.out.println("Enter key 2");
        return sc.nextLong();
    }

    private static String getSeed() {
        System.out.println("Enter key");
        return sc.nextLine();
    }
}

