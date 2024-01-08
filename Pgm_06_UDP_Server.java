import java.net.*;
public class UDPServer 
{
    public static void main(String args[]) throws Exception 
    {
        DatagramSocket serverSock= new DatagramSocket(9884);

        System.out.println("Server is Ready for the client");

        byte[] recvData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) 
        {
            DatagramPacket recvPack = new DatagramPacket(recvData, recvData.length);
            serverSock.receive(recvPack);

            String sentence = new String(recvPack.getData());
            System.out.println("RECEIVED: " + sentence);

            InetAddress ipAdd = recvPack.getAddress();
            int port = recvPack.getPort();

            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPack = new DatagramPacket(sendData, sendData.length, ipAdd, port);
            serverSock.send(sendPack);

        }           
    }
}
