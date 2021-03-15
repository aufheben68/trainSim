//https://github.com/aufheben68
package trainsims;

public class MetroSim {

	public static void main(String[] args) {
		int numofwaggons = 5;
		int maxpassengersperwaggon = 50;
		float ticketckeckprobab = 0.2f; /* 0-1 */
		float hasticketprobability = 0.7f; /* 0-1 */
		float reducedticketprobability = 0.3f; /* 0-1 */
		int stathmoi = 15;
		
		Train train = new Train(numofwaggons,maxpassengersperwaggon,ticketckeckprobab,hasticketprobability,reducedticketprobability);
		train.operate(stathmoi);
		train.printStatistics();
	}
	
}