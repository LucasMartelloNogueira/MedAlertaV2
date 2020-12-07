package backend.farmacia;

import java.io.*;
import java.nio.*;

public class TestesArq {
    public static void main(String[] args) {
        String nomeArq = "backend\\farmacia\\TesteFarmacia.txt";
        File arq = new File(nomeArq);
        System.out.println(arq.getAbsolutePath());
    }
}
