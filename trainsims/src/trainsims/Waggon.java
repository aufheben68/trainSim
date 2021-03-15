//https://github.com/aufheben68
package trainsims;

import java.util.ArrayList;
import java.util.Random;
import trainsims.Passenger;

public class Waggon { 
	private int id; 
	private ArrayList<Passenger> passengers;
	private int maxpassengers;
	private float ticketcheckprobability;
	private float hasticketprobability;
	private float reducedticketprobability;
	private boolean docheck;
	private int synolikoiparavates = 0;
	private int synolikoiparavatespoudenentopistikan = 0;
	private int totalprostima = 0;
	public Waggon(int idid, int maxpass, float ticketckeckprobab,float hasticketprobab,float reducedticketprobab) { 
		id = idid;
		maxpassengers = maxpass;
		ticketcheckprobability = ticketckeckprobab;
		hasticketprobability = hasticketprobab;
		reducedticketprobability = reducedticketprobab;
		passengers = new ArrayList<Passenger>();
		System.out.println("Created wagon: " + id + " with capacity of: "+ maxpassengers +".");
	}
	public void inStation(){ 
		int i,prosepivivasi,prosapovivasi,prosapovivasinoticket=0;
		for(i=passengers.size()-1;i>=0;i--){
			if(passengers.get(i).getHasTicket()==false){
				if(passengers.get(i).getIsCaught()==true){
					synolikoiparavates++;
					passengers.remove(i);
				}
				else{
					synolikoiparavatespoudenentopistikan++;
				}
				prosapovivasinoticket++;
			}
		}
		prosepivivasi = randInt(0,(maxpassengers-(passengers.size())));
		prosapovivasi = randInt(0,passengers.size());
		for(i=prosapovivasi-1;i>=0;i--){ 
			passengers.remove(i);
		}
		for(i=0;i<prosepivivasi;i++){
			passengers.add(new Passenger(hasticketprobability, reducedticketprobability));
		}
		System.out.println("Wagon with id: " + id + " has " +passengers.size()+ " passengers,");
		System.out.println("people disembarking: " + (prosapovivasi+prosapovivasinoticket));
		System.out.println("people boarding: " + prosepivivasi);
		if(randFloat(0.0f,1.0f)<ticketcheckprobability){ 
			docheck = true;
			System.out.println("A check for tickets will take place.");
		}
		else{
			docheck = false;
			System.out.println("There won't be any check for tickets.");
		}
	}
	public void inFirstStation(){ 
		int i,prosepivivasi;
		prosepivivasi = randInt(0,(maxpassengers-(passengers.size())));
		for(i=0;i<prosepivivasi;i++){
			passengers.add(new Passenger(hasticketprobability, reducedticketprobability));
		}
		System.out.println("Wagon: " + id + " has " +passengers.size()+ " passengers,");
		System.out.println("people boarding: " + prosepivivasi);
		if(randFloat(0.0f,1.0f)<ticketcheckprobability){
			docheck = true;
			System.out.println("A check for tickets will take place.");
		}
		else{
			docheck = false;
			System.out.println("There won't be any check for tickets.");
		}
	}
	public void inLastStation(){
		for(int i=passengers.size()-1;i>=0;i--){
			if(passengers.get(i).getHasTicket()==false){
				if(passengers.get(i).getIsCaught()==true){
					synolikoiparavates++;
				}
				else{
					synolikoiparavatespoudenentopistikan++;
				}
			}
			passengers.remove(i);
		}
		System.out.println("Wagon" + id + " has " +passengers.size()+ " passengers,");
		System.out.println("people disembarking: " + passengers.size());
		docheck = false;
	}
	public void betweenStations(){ 
		if(docheck){
			for(int i=0;i<passengers.size();i++){
				if(passengers.get(i).getHasTicket()==false){
					passengers.get(i).setCaught();
					if(passengers.get(i).getReducedTicket()==true){
						totalprostima += 1;
					}
					else{
						totalprostima += 2;
					}
					
				}
			}
		}
	}
	
	public void printStatistics(){ //sunartisi print gia ta statistika
		System.out.println("\nStatistics for wagon: " + id);
		System.out.println("Total number of passengers with no ticket that were caught on all stations: " + synolikoiparavates);
		System.out.println("Total number of passengers with no ticket that got away with it: " + synolikoiparavatespoudenentopistikan);
	}
	
	public int getTotalProstima(){ 
		return totalprostima;
	}
	
	public static int randInt(int min, int max) { 
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	public static float randFloat(float min, float max) { 
		float random;
		random = (float)Math.random() < 0.5 ? ((1-(float)Math.random()) * (max-min) + min) : ((float)Math.random() * (max-min) + min);
		return random;
	}
}