import java.util*;
public class RedCongestionControl 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the maximum number of packets:");//number of packets to be sent
        int maxPackets = scanner.nextInt();

        System.out.println("Enter the queue size:");//size of the queue the packets can be stored
        int queueSize = scanner.nextInt();

        System.out.println("Enter the maximum probability:");
        double maxProbability = scanner.nextDouble();

        System.out.println("Enter the minimum probability:");//used to calculated the drop probabilty (max-min)
        double minProbability = scanner.nextDouble();

        System.out.println("Enter the threshold value:");//the value after which the congestion control comes to action 
        int threshold = scanner.nextInt();

        simulateCongestion(maxPackets, queueSize, maxProbability, minProbability, threshold);
    }

    private static void simulateCongestion(int maxPackets, int queueSize, double maxProbability, double minProbability, int threshold) 
    {
        Random rand = new Random(System.currentTimeMillis());
        int queueLength = 0;

        for (int i = 0; i < maxPackets; i++) 
        {
            double dropProbability = calculateDropProbability(queueLength, queueSize, maxProbability, minProbability, threshold);

            if (queueLength >= threshold && rand.nextDouble() < dropProbability) 
                System.out.println("Packet dropped (CONGESTION AVOIDANCE)");

            else 
            {
                System.out.println("Packet accepted " + (i + 1));
                queueLength++;
            }

        }
    }

    private static double calculateDropProbability(int currentQueueLength, int queueSize, double maxProbability, double minProbability, int threshold) 
    {
        double slope = (maxProbability - minProbability) / (queueSize - threshold);
        return minProbability + slope * (currentQueueLength - threshold);
    }
}
