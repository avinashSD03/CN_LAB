import java.net.*;
import java.io.*; 
public class TCPC
{
    public static void main(String[] args) throws Exception
    {
        Socket sock=new Socket("127.0.01", 4000);

        BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the filename");
        String fname=keyRead.readLine();

        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream, true);
        pwrite.println(fname);

        InputStream istream=sock.getInputStream();
        BufferedReader sockRead=new BufferedReader(new InputStreamReader(istream));

        String str;
        while((str=sockRead.readLine())!=null)
            System.out.println(str);

        pwrite.close();
        sockRead.close();
        keyRead.close();

    }
}
