import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Client { 
	public static void main(String args[]) throws Exception	{
		Socket sk=new Socket("127.0.0.1",5555);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		try{
			while (  true )	{			
			System.out.println("Server is ONLINE");
			System.out.println("To disconnect from the server, please type: Exit");
			System.out.print("Client: ");
			s=stdin.readLine();
			sout.println(s);
			if ( s.equalsIgnoreCase("Exit") ) {
				System.out.println("Connexion with the server has ended.");
				break; 
				}
			s=sin.readLine();
			System.out.print("Server: "+s+"\n");
		}	
		sk.close();
		sin.close();
		sout.close();
 		stdin.close();
		}
		catch(IOException ex){
            	System.out.println("Server is OFFLINE: "+ex);
		}
	}
}