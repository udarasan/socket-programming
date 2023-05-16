import java.io.*;
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
            //client accepted
            System.out.println("Client Accepted!");
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

            //Java application uses an input stream to read data from a source; it may be a file,
            // an array, peripheral device or socket.
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            String message="";
            String reply="";

            while (!message.equals("finish")){

                //UTF-8 character encoding values set to string
                message=dataInputStream.readUTF();
                //print Message
                System.out.println(message);
                reply= bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();

            }
            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

            //close a socket
            socket.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}