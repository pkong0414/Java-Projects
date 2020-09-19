/* This class stores one square of the Wumpus world
 * It will represent if the square is breezy,
 * has a stench, has a pit, has a person,
 * has a Wumpus or has gold.
*/
	
	public class Square{
		private boolean breeze = false, gold = false, wumpus = false, 
						stench = false, pit = false, assigned = false,
						player = false;
		
		//default constructor
		public Square(){
			breeze = false;
			gold = false;
			wumpus = false;
			stench = false;
			pit = false;
			assigned = false;
			player = false;
		}
		
		
		public void setBreeze() {
			breeze = true;
		}
		
		public void setGold() {
			gold = true;
			assigned = true;
		}
		
		public void setPit() {
			pit = true;
			assigned = true;
		}
		
		//Wumpus features
		public void setWumpus() {
			wumpus = true;
		}
		
		public void setStench() {
			stench = true;
		}
		
		public void unsetWumpus() {
			wumpus = false;
		}
		
		public void unsetStench() {
			stench = false;
		}
		
		//player features
		public void setPlayer() {
			player = true;
		}
		
		public void unsetPlayer() {
			player = false;
		}
		
		
		
		//get attributes
		
		public boolean getBreeze() {
			if(breeze == true)
				return true;
			else
				return false;
		}
		
		public boolean getGold() {
			if(gold == true)
				return true;
			else
				return false;
		}
		
		public boolean getWumpus() {
			if(wumpus == true)
				return true;
			else
				return false;
		}
		
		public boolean getStench() {
			if(stench == true)
				return true;
			else
				return false;
		}
		
		public boolean getPit() {
			if(pit == true)
				return true;
			else
				return false;
		}
		
		public boolean getAssigned() {
			if(assigned == true)
				return true;
			else
				return false;
		}
		
		//Game reset feature
		public void gameReset() {
			breeze = false;
			gold = false;
			pit = false;
			wumpus = false;
			assigned = false;
		}
		
		
		
	}