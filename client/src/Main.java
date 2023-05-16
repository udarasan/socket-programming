import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            String message="";
            String reply="";
            while (!message.equals("finish")){
                reply= bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                message=dataInputStream.readUTF();
                System.out.println(message);
                dataOutputStream.flush();
            }
            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

            socket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
