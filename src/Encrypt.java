import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

class Encrypt {
    private static char[] dataChar;
    private static StringBuilder builder = new StringBuilder();

    static void encrypt(String data, String seed) throws UnsupportedEncodingException {
        Encrypt.builder = new StringBuilder(seed);
        int key4 = getFirstNum();

        long[] keys = getKey(Encrypt.builder.toString());
        long key1 = keys[0];
        long key2 = keys[1];
        long key3 = keys[2];
        long key5 = keys[3];

        long[] dataInts = DataGen.getData(data);

        for (int i = 0; i < dataInts.length; i++) {
            dataInts[i] = Math.abs((((dataInts[i]-key5)/key4)-(key1+key3))/key2);
        }

        dataChar = new char[dataInts.length];
        for (int i = 0; i < dataChar.length; i++) {
            dataChar[i] = (char) dataInts[i];
        }

        resultWrite();
    }

    private static long[] getKey(String seed) {
        String res = DataGen.reverseKey(seed);
        return DataGen.getData(res);
    }

    private static void resultWrite() throws UnsupportedEncodingException {
        PrintStream printStream = new PrintStream(System.out, true, "cp866");
        StringBuilder result = new StringBuilder();
        for (char c : dataChar) {
            result.append(c);
        }
        printStream.println(result);
    }

    private static int getFirstNum() {
        char first = builder.charAt(0);
        builder.deleteCharAt(0);
        return Character.getNumericValue(first);
    }
}