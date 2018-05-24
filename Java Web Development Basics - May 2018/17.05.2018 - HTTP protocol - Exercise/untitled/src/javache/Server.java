package javache;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.FutureTask;

public class Server {

    private static final String LISTENING_MESSAGE = "Listening on port: ";

    public static final int SOCKET_TIMEOUT_MILLISECONDS = 5000;

    public static final String TIME_OUT_DETECTED_MESSAGE = "TimeOut Detected";

    private ServerSocket server;

    private Integer port;

    private Integer timeOuts;

    public Server(Integer port) {
        this.port = port;
        this.timeOuts = 1;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        System.out.println(LISTENING_MESSAGE + this.port);

        this.server.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

        while (true) {
            try (Socket clientSocket = this.server.accept()) {
                clientSocket.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket, new RequestHandler());
                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();

            }catch (SocketTimeoutException e) {
                System.out.println(TIME_OUT_DETECTED_MESSAGE);
                this.timeOuts++;
            }
        }
    }
}