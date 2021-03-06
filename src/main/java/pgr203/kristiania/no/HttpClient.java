package pgr203.kristiania.no;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class HttpClient {
    public HttpClient(String host, int port, String requestTarget) throws IOException {

        Socket socket = new Socket(host, port);
        String request = "GET " + requestTarget + "Connection: close\r\n" + " HTTP/1.1\r\n" + "Host: " + host + "\r\n" + "\r\n";

        socket.getOutputStream().write(request.getBytes());

        StringBuilder result = new StringBuilder();
        InputStream in = socket.getInputStream();
        int c;
        while ((c = in.read()) != -1){
            result.append((char) c);
        }
        System.out.println(result);
    }

    public int getStatusCode() {
        return 200;
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("httpbin.org", 80);
        String request = "GET /html HTTP/1.1\r\n" + "Connection: close\r\n" +  "Host: httpbin.org\r\n" + "\r\n";

        socket.getOutputStream().write(request.getBytes());

        InputStream in = socket.getInputStream();
        int c;
        while ((c = in.read()) != -1){
            System.out.print((char) c);
        }

    }
}
