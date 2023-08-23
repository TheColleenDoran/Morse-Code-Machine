/*
 * Colleen Doran
 * 
 */
import java.io.*;

public class Main {
    public static final void main(String[] args) {
        MorseMaster carl = new MorseMaster();
        String hi = carl.decipher("... --- ...");
        System.out.println(hi);
        // hi = carl.encipher("hi");
        // System.out.println(hi);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Name: ");
            String name = in.readLine();
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
        
    }
}

