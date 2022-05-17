package otros;

import java.nio.charset.*;
import java.util.*;

public class AlphaNumericStringGenerator {
    public static String getRandomString(int i)
    {

        byte[] bytearray;
        String mystring;
        StringBuffer thebuffer;

        bytearray = new byte[256];
        new Random().nextBytes(bytearray);

        mystring
                = new String(bytearray, Charset.forName("UTF-8"));

        // Create the StringBuffer
        thebuffer = new StringBuffer();

        for (int m = 0; m < mystring.length(); m++) {

            char n = mystring.charAt(m);

            if (((n >= 'A' && n <= 'Z')
                    || (n >= '0' && n <= '9'))
                    && (i > 0)) {

                thebuffer.append(n);
                i--;
            }
        }

        // resulting string
        return thebuffer.toString();
    }

    public static void main(String[] args)
    {
        // the random string length
        int i = 5;

        // output
        System.out.println("A random string: " +  getRandomString(i));


    }
}
