import java.io.*; 
import java.net.*;
public class UDPClient
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader inPut=new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSock=new DatagramSocket();
        InetAddress ipAdd=InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        byte[] recvData = new byte[1024];

        System.out.println("Enter the string in lowercase so that you receive the message in Uppercase from the server");
        String sentence=inPut.readLine();

        sendData=sentence.getBytes();

        DatagramPacket sendPack = new DatagramPacket(sendData, sendData.length,ipAdd, 9884);
        clientSock.send(sendPack);

        DatagramPacket recvPack=new DatagramPacket(recvData, recvData.length);
        clientSock.receive(recvPack);

        String modifiedSentence=new String(recvPack.getData());
        System.out.println("FROM SERVER: "+modifiedSentence);

        clientSock.close();
    }
}
