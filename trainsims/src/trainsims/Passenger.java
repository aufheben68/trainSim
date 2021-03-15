//https://github.com/aufheben68
package trainsims;

public class Passenger { 

	private boolean hasticket; 
	private boolean reducedticket;
	private boolean iscaught;
	public Passenger(float hasticketprobability,float reducedticketprobability) {
		float randomhasticket = randFloat(0.0f, 1.0f); //random
		float randomreducedticket = randFloat(0.0f, 1.0f); //random
		if(randomhasticket < hasticketprobability){ 
			hasticket = true;
		}
		else{
			hasticket = false;
		}
		if(randomreducedticket < reducedticketprobability){ 
			reducedticket = true;
		}
		else{
			reducedticket = false;
		}
		iscaught = false;
	}
	
	public boolean getHasTicket(){ 
		return hasticket;
	}
	public boolean getReducedTicket(){ 
		return reducedticket;
	}
	public boolean getIsCaught(){ 
		return iscaught;
	}
	public void setCaught(){ 
		iscaught = true;
	}

	public static float randFloat(float min, float max) {
		float random;
		random = (float)Math.random() < 0.5 ? ((1-(float)Math.random()) * (max-min) + min) : ((float)Math.random() * (max-min) + min);
		return random;
	}
	

}
