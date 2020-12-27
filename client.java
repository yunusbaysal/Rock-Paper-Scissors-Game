import java.net.*;
import java.io.*;
import java.util.*;
public class client{

	public static void main(String[] args) throws IOException{

		// kullanıcıdan degerler alındı
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a this string (rock / paper / scissors): ");
		String str_in=sc.nextLine(); 
		

		Socket socket =new Socket("127.0.0.1",9706);

		PrintWriter pr =new PrintWriter(socket.getOutputStream());
		pr.println(str_in);
		pr.flush();


		// client'a server dan result geldi ve ekrana bastırıldı
		InputStreamReader input = new InputStreamReader(socket.getInputStream());
		BufferedReader bf = new BufferedReader(input);

		String str =bf.readLine();

		System.out.println("Clientdaki Result :"+str);

	}
}