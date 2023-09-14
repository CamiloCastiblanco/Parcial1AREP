package co.escuelaing.edu.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        ReflexCalculator calculadora=new ReflexCalculator();
        try {
            serverSocket = new ServerSocket(35001);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35001.");
            System.exit(1);
        }

        try {
            System.out.println("Listo para recibir ...");
            while (true) {
                Socket clientSocket;
                clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                String recurso;
                PrintWriter out;
                while ((inputLine = in.readLine()) != null) {

                    System.out.println(inputLine);
                    String res=inputLine;
                    String[] split=res.split(" ");
                    Double num=Double.parseDouble(split[0]);
                    String oper=split[1];
                    Double respuesta=0.0;
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    switch (oper) {
                        case "sin":
                            respuesta = calculadora.operate(num,calculadora.sin);
                            break;
                        case "cos":
                            respuesta = calculadora.operate(num,calculadora.cos);
                            break;
                        case "tan":
                            respuesta = calculadora.operate(num,calculadora.tan);
                            break;
                    }
                    out.println(respuesta);
                    out.close();

                    if (inputLine.contains("GET")) {
                        recurso = inputLine.split(" ")[1];
                        recurso = recurso.substring(1);
                        System.out.println(recurso);
                    }
                    if(!in.ready()){
                        break;
                    }
                }
                in.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35001;
    }
}

