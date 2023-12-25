import java.util.Scanner;
class CRC {
    public static void main(String args[])
   {
        Scanner sc = new Scanner(System.in); 

        System.out.println("Enter the size of the data:");
        int n = sc.nextInt();
        int data[] = new int[n];
        
        System.out.println("Enter the data, bit by bit:");
        for (int i = 0; i < n; i++) 
            data[i] = sc.nextInt();

        System.out.println("Enter the size of the divisor:");
        n = sc.nextInt();
        int divisor[] = new int[n];

        System.out.println("Enter the divisor, bit by bit:");
        for (int i = 0; i < n; i++) 
            divisor[i] = sc.nextInt();

        int remainder[] = divide(data, divisor);

        for (int i = 0; i < remainder.length - 1; i++) 
            System.out.print(remainder[i]);

        System.out.println("\nThe CRC code generated is:");
        for (int i = 0; i < data.length; i++) 
            System.out.print(data[i]);

        for (int i = 0; i < remainder.length - 1; i++) 
            System.out.print(remainder[i]);

        System.out.println();

        int sent_data[] = new int[data.length + remainder.length - 1];

        System.out.println("Enter the data to be sent:");
        for (int i = 0; i < sent_data.length; i++) 
        {
            System.out.println("Enter bit number " + (sent_data.length - i)
                    + ":");
            sent_data[i] = scan.nextInt();
        }

        receive(sent_data, divisor);
    }

    public static int[] divide(int old_data[], int divisor[]) 
    {
        int i;
        int data[] = new int[old_data.length + divisor.length];

        System.arraycopy(old_data, 0, data, 0, old_data.length);

        int remainder[] = new int[divisor.length];

        System.arraycopy(data, 0, remainder, 0, divisor.length);

        for (i = 0; i < old_data.length; i++) 
        {
            System.out.println((i + 1) + ".) "+ i +" th data bit is : "
                    + remainder[0]);

            System.out.print("Remainder : ");
            if (remainder[0] == 1) 
            {
                for (int j = 1; j < divisor.length; j++) 
                {
                    remainder[j - 1] = exor(remainder[j], divisor[j]);
                    System.out.print(remainder[j - 1]);
                }
            } 
            else 
            {
                for (int j = 1; j < divisor.length; j++) 
                {
                    remainder[j - 1] = exor(remainder[j], 0);
                    System.out.print(remainder[j - 1]);
                }
            }
            remainder[divisor.length - 1] = data[i + divisor.length];
            System.out.println(remainder[divisor.length - 1]);
        }
        return remainder;
    }

    public static int exor(int a, int b) 
    {
        if (a == b) 
            return 0;
        return 1;
    }

    public static void receive(int data[], int divisor[]) 
    {
        int remainder[] = divide(data, divisor);
        for (int i = 0; i < remainder.length; i++) 
        {
            if (remainder[i] != 0) 
            {
                System.out.println("There is an error in received data...");
                return;
            }
        }
        System.out.println("Data was received without any error.");
    }

}

-------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;
public class CRCCode 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);

        System.out.println("Enter the data and key values");
        String data = in.next();
        String key = in.next();

        System.out.println("At Sender side");
        EncodeData(data, key);

        System.out.println("At Receiver side");
        System.out.println("Enter the code word received");
        String rec=in.next();

        int i= data.length() + key.length() - 1;

        if(rec.length()> i ||rec.length()< i) 
            System.out.println("Enter a valid received codeword");

        else Receiver(rec,key);

    }
    private static void EncodeData(String data, String key) 
    {
        int len = key.length();

        String str=new String(new char[len - 1]);

        String append = (data + str.replace("\0", "0"));
        String remainder = Mod2Division(append, key);

        String codeword = data + remainder;

        System.out.println("Remainder : " + remainder);
        System.out.println("CodeWord encoded is : " + codeword);

    }
    private static void Receiver(String data, String key) 
    {
        String curXor = Mod2Division(data.substring(0, key.length()), key);
        int curr = key.length();

        while (curr != data.length()) 
        {
            if (curXor.length() != key.length())
                curXor += data.charAt(curr++);

            else curXor = Mod2Division(curXor, key);
        }

        if (curXor.length() == key.length()) 
            curXor = Mod2Division(curXor, key);

        if (curXor.contains("1")) 
            System.out.println("Error has occurred. Incorrect codeword received");

        else 
            System.out.println("No error. Correct message received");

    }

    private static String Mod2Division(String dividend, String divisor) 
    {
        int pick = divisor.length();

        String temp = dividend.substring(0, pick);
        int n = dividend.length();

        while (pick < n) 
        {
            if (temp.charAt(0) == '1')
                temp = Xor(divisor, temp) + dividend.charAt(pick);

            else 
            {
                String str=new String(new char[pick]);
                temp = Xor(str.replace("\0", "0"), temp) + dividend.charAt(pick);
            }

            pick += 1;

        }

        if (temp.charAt(0) == '1')
            temp = Xor(divisor, temp);

        else 
        {
            String str=new String(new char[pick]);
            temp = Xor(str.replace("\0", "0"), temp);
        }
        return temp;

    }

    private static String Xor(String divisor, String temp) 
    {
        StringBuilder result = new StringBuilder();
        int n = temp.length();

        for (int i = 1; i < n; i++) 
        {
            if (divisor.charAt(i) == temp.charAt(i))
                result.append("0");

            else result.append("1");
        }

        return result.toString();

    }
}
