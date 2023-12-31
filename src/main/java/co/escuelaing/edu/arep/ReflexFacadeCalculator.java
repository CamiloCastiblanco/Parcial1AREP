package co.escuelaing.edu.arep;

import java.io.*;
import java.net.*;

/**
 * Hello world!
 *
 */
public class ReflexFacadeCalculator {
    private static ReflexFacadeCalculator _instance = new ReflexFacadeCalculator();

    public String  getOperation(String oper) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
        out.println(oper);
        String response=in.readLine();
        out.close();
        in.close();
        echoSocket.close();
        return response;
    }

}