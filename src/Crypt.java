class Crypt {
    private static long[] dataInts;
    private static long seed1;
    private static long seed2;
    private static long seed3;
    private static int seed4;
    private static final long seed5 = System.currentTimeMillis();
    static void crypt(String data, long key1, long key2, long key3) {
        int key4 = DataGen.randomNum();
        key1 = Math.abs(key1);
        key2 = Math.abs(key2);
        seed1 = key1;
        seed2 = key2;
        seed3 = key3;
        seed4 = key4;

        char[] dataChar = data.toCharArray();

        dataInts = new long[dataChar.length];

        for (int i = 0; i < dataInts.length; i++) {
            dataInts[i] = dataChar[i];
        }

        for (int i = 0; i < dataInts.length; i++) {
            dataInts[i] = Math.abs((((dataInts[i]*key2)+(key1+key3))*key4)+ seed5);
        }

        resultWrite();
    }

    private static String finalSeed(long key1, long key2, long key3, int key4) {
        String str = ""+DataGen.randomLetter()+key1+DataGen.randomLetter()+key2+DataGen.randomLetter()+key3+DataGen.randomLetter()+Crypt.seed5;
        return key4+DataGen.reverseKey(str);
    }

    private static void resultWrite() {
        StringBuilder result = new StringBuilder("Data ");
        for (long dataInt : dataInts) {
            result.append(dataInt).append(DataGen.randomLetter());
        }
        System.out.println(result);
        System.out.println("Key " + finalSeed(seed1, seed2, seed3, seed4));
    }
}