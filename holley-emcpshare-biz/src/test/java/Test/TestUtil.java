package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtil {

    public static boolean      isrun = true;
    public static int          count = 0;
    public final static String mark  = null;

    public static void main(String[] args) throws IOException {
        Dectorebase in = null;
        List<Dectorebase> l = new ArrayList<Dectorebase>();
        for (int x = 0; x < 1000000; x++) {
            in = new Dectorebase();
            in.setAge(x);
            l.add(in);
        }

        Collections.shuffle(l);
        long start = System.currentTimeMillis();
        Dectorebase max = l.get(0);
        for (Dectorebase b : l) {
            Dectorebase tem = b;
            if (tem.getAge() > max.getAge()) {
                max = tem;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("max1:" + max.getAge());
        System.out.println(end - start);

        long start2 = System.currentTimeMillis();
        Dectorebase max2 = l.get(0);
        for (int x = 0; x < l.size(); x++) {
            Dectorebase tem = l.get(x);
            if (tem.getAge() > max2.getAge()) {
                max2 = tem;
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println("max2:" + max2.getAge());
        System.out.println(end2 - start2);
    }
}
