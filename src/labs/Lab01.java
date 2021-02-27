package labs;

import mooc.*;

public class Lab01 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            io.println(io.nextInt() + io.nextInt());
        }
    }
}
