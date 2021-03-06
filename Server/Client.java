import java.io.*;
import java.net.*;

import com.xentio.terminal.protocol.Protocol;

// w024

public class Client {
	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.err.println("Usage: java EchoClient <host name> <port number>");
			System.exit(1);
		}

		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);
		
		
		try (Socket socket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
			
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				String fromServer;
				String fromUser;
				System.out.println("Connected to server!");
			
			while ((fromServer = in.readLine()) != null) {

				
				if (fromServer.equals(Protocol.END_OF_COMMAND_STRING)) { 					
					fromUser = stdIn.readLine();
					
					if (fromUser != null && !fromUser.isEmpty()) {
						System.out.println("sending command: "+fromUser);
						out.println(fromUser);
						
					 
						if (fromUser.equals("exit")) {
							socket.close();
					        System.out.println("The server is shut down!");
					      	System.out.println("Waiting for socket");
						}
					
					}
				} else {
					System.out.println(fromServer);
				}
					
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}
}
