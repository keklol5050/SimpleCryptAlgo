import java.security.SecureRandom;
import java.util.Random;
import java.util.StringTokenizer;

public class DataGen {
    private static final Random rn = new Random();
    public static long secretKey(){
        int n = rn.nextInt(1, 6);
        SecureRandom random = new SecureRandom();
        byte[] seed = random.generateSeed(n);
        String randomFinish = "";
        for (int i=0; i<n; i++) {
            randomFinish = randomFinish + Math.abs(seed[i]);
        }
        return Long.parseLong(randomFinish);
    }

    public static char randomLetter() {
        return (char) (rn.nextInt(65,90));
    }

    public  static String reverseKey(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public  static int randomNum() {
        return rn.nextInt(1, 10);
    }

    static long[] getData(String data) {
        StringTokenizer tokenizer = new StringTokenizer(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        long[] keys = new long[tokenizer.countTokens()];
        int i = 0;
        while(tokenizer.hasMoreTokens()) {
            keys[i] = Long.parseLong(tokenizer.nextToken());
            i++;
        }
        return keys;
    }
}