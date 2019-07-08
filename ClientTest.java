import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTest {


	public static void main(String[] args) throws Exception {

		String message;
		String modMessage;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket("localhost",5555);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		message = inFromUser.readLine();
		outToServer.writeBytes(message);
		modMessage = inFromServer.readLine();
		System.out.println(modMessage);
		clientSocket.close();
	}

}
