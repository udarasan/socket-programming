import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author $USER
 * @TimeStamp $DATE $TIME
 * @ProjectDetails $PROJECT_NAME
 */
public class Main {
    public static void main(String[] args) {
        try{
            //create a server socket and bind port
            ServerSocket serverSocket=new ServerSocket(3000);

            //accept connection and move to new socket
            Socket socket=serverSocket.accept();

            //Java application uses an input stream to read data from a source; it may be a file,
            // an array, peripheral device or socket.
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());

            //UTF-8 character encoding values set to string
            String message=dataInputStream.readUTF();

            //print statement
            System.out.println(message);

            //close a socket
            socket.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}