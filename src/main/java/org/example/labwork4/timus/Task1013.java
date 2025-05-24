package org.example.labwork4.timus;

import java.math.BigInteger;
import java.util.Scanner;

public class Task1013 {

    static class Matrix {
        BigInteger[][] m = new BigInteger[2][2];

        Matrix() {
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    m[i][j] = BigInteger.ZERO;
        }

        static Matrix identity() {
            Matrix res = new Matrix();
            res.m[0][0] = res.m[1][1] = BigInteger.ONE;
            return res;
        }

        Matrix multiply(Matrix other, BigInteger mod) {
            Matrix res = new Matrix();
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    for (int k = 0; k < 2; k++)
                        res.m[i][j] = res.m[i][j].add(this.m[i][k].multiply(other.m[k][j])).mod(mod);
            return res;
        }
    }

    static Matrix matrixPower(Matrix base, BigInteger exp, BigInteger mod) {
        Matrix result = Matrix.identity();
        while (exp.signum() > 0) {
            if (exp.testBit(0)) {
                result = result.multiply(base, mod);
            }
            base = base.multiply(base, mod);
            exp = exp.shiftRight(1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger N = scanner.nextBigInteger();
        BigInteger K = scanner.nextBigInteger();
        BigInteger M = scanner.nextBigInteger();

        if (N.equals(BigInteger.ONE)) {
            System.out.println(K.subtract(BigInteger.ONE).mod(M));
            return;
        }

        Matrix base = new Matrix();
        base.m[0][1] = BigInteger.ONE;
        base.m[1][0] = K.subtract(BigInteger.ONE);
        base.m[1][1] = K.subtract(BigInteger.ONE);

        Matrix result = matrixPower(base, N.subtract(BigInteger.ONE), M);
        BigInteger a1 = BigInteger.ZERO;
        BigInteger b1 = K.subtract(BigInteger.ONE);

        BigInteger aN = result.m[0][0].multiply(a1).add(result.m[0][1].multiply(b1)).mod(M);
        BigInteger bN = result.m[1][0].multiply(a1).add(result.m[1][1].multiply(b1)).mod(M);

        System.out.println(aN.add(bN).mod(M));
    }
}
