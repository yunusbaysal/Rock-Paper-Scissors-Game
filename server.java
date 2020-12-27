import java.net.*;
import java.io.*;
import java.lang.Math;
public class server{

	public static void main(String[] args) throws IOException{

		ServerSocket ss=new ServerSocket(9706);
		//accept() methoduyla server ile client bağlantısı kuruldu
		Socket socket=ss.accept();

		System.out.println("Client connected succesfully...");

		// socket ten data  read edildi.
		InputStreamReader input = new InputStreamReader(socket.getInputStream());
		BufferedReader bf = new BufferedReader(input);

		String str =bf.readLine();
		String random_str="";

		System.out.println("Client dan gelen input :"+str);


		int rand_num=(int)(Math.random()*3+1);  // taş a 1, kagıtda 2, makas a 3 karsılık geldi
									// rock / paper / scissors



		if(rand_num == 1){

			random_str="rock";

		}
		else if(rand_num == 2){
			random_str="paper";
		}
		else if(rand_num == 3){

			random_str = "scissors";
		}

		//SERVER Generates a Random variable and prints it on the screen.
		System.out.println("Server da olusturulan random variable :"+random_str);

			String result,value;
		//if(str.equals(random))
		 value=str;

		 //Compare the values (SERVER -> random vs Client -> user input)

		if(((str.equals("rock"))||(str.equals("paper"))||(str.equals("scissors"))) && (str.equals(random_str)) )
		{
				result = "draw"; //berabere 
		}
		else if( (value.equals("rock") && random_str.equals("scissors")) || (value.equals("scissors") && random_str.equals("paper")) || (value.equals("paper") && random_str.equals("rock"))   )
		{
				result = "win"; //kazandı
		}
		else{

				result = "lost";  // kaybetti
		}
		
		//SERVER Prints the result statement (win / lost / draw) on the screen.
		System.out.println("Server daki Result :"+result);


		//Result client'a gönderildi.
		PrintWriter pr =new PrintWriter(socket.getOutputStream());
		pr.println(result);
		pr.flush();

	}
}