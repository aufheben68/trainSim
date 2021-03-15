//https://github.com/aufheben68
package trainsims;

public class Train { 
	private int waggonsnum; 
	private Waggon[] waggons;
	public Train(int numofwaggons, int maxpassperwaggon, float ticketckeckprobab,float hasticketprobability,float reducedticketprobability) {
		int i;
		waggonsnum = numofwaggons;
		waggons = new Waggon[numofwaggons];
		for(i=0;i<numofwaggons;i++){  
			waggons[i] = new Waggon(i+1,maxpassperwaggon,ticketckeckprobab,hasticketprobability,reducedticketprobability);
		}
		System.out.println("New train created with " + numofwaggons + " number of wagons.");
	}
	public void operate(int stathmoi){ 
		int i,j;
		for(i=0;i<stathmoi;i++){
			System.out.println("Train arrives at station " + i + ".");
			for(j=0;j<waggonsnum;j++){
				if(i==0){
					waggons[j].inFirstStation();
					waggons[j].betweenStations();
				}
				else if(i==(stathmoi-1)){
					waggons[j].inLastStation();
				}
				else{
					waggons[j].inStation();
					waggons[j].betweenStations();
				}
			}
		}
	}
	public void printStatistics(){ //prostima
		int i,prostima=0;
		for(i=0;i<waggonsnum;i++){
			waggons[i].printStatistics();
			prostima += waggons[i].getTotalProstima();
		}
		System.out.println("\nTotal money collected from fines: " + prostima);
	}
}
