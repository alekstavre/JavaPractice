import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) throws Exception {

		String clientMsg;
		String returnMsg;

		ServerSocket entrySocket = new ServerSocket(5555);

		while (true) {

			Socket connectSocket = entrySocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectSocket.getOutputStream());

			clientMsg = inFromClient.readLine();
			returnMsg = clientMsg.toLowerCase() + '\n';
			outToClient.writeBytes(returnMsg);
		}

	}

}
