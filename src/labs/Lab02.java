package labs;

import mooc.EdxIO;

import java.math.BigInteger;

public class Lab02 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            BigInteger firstNum = BigInteger.valueOf(io.nextInt());
            BigInteger secondNum = BigInteger.valueOf(io.nextInt());

            io.println(""+firstNum.add(secondNum.multiply(secondNum)));
        }
    }

}
