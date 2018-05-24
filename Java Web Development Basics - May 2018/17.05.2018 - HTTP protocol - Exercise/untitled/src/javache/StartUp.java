package javache;

import java.io.IOException;

public class StartUp {

    public static void main(String[] args) {

        try {
            Server server = new Server(WebConstants.DEFAULT_SERVER_PORT);
            server.run();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}