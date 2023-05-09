import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author $USER
 * @TimeStamp $DATE $TIME
 * @ProjectDetails $PROJECT_NAME
 */
public class Main {
    public static void main(String[] args) {
        try{
            //open a socket and say server address and port
            Socket socket=new Socket("localhost",3000);

            //output stream used for write data to server
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

            //UTF8 encoding
            dataOutputStream.writeUTF("Hello Server");

            //When you call flush(), the DataOutputStream will write any data that is currently
            // in its buffer to the output stream, and then clear the buffer.
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
