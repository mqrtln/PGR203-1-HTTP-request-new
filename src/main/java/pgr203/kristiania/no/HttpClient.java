package pgr203.kristiania.no;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class HttpClient {
    public HttpClient(String s, int i, String s1) throws IOException {

        Socket socket = new Socket("httpbin.org", 80);
        String request = "GET /html HTTP/1.1\r\n" + "Host: httpbin.org\r\n" + "\r\n";

        socket.getOutputStream().write(request.getBytes());

        InputStream in = socket.getInputStream();
        int c;
        while ((c = in.read()) != -1){
            System.out.print((char) c);
        }
    }

    public static void main(String[] args)  {
    }

    public int getStatusCode() {
        return 200;
    }
}