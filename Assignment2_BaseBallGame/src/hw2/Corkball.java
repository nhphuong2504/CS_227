package hw2;

/**
 * Model of an obscure game called "Corkball" or sometimes "Fuzzball", generally
 * played in the St Louis area.  It is vaguely similar to baseball, except that
 * it is much simpler since there are no actual bases and the runners are imaginary.
 * See the assignment pdf for further explanation.
 * 
 * @author Hoang Phuong Nguyen
 */
public class Corkball
{
  /**
   * Number of strikes causing a player to be out.
   */
  public static final int MAX_STRIKES = 2;

  /**
   * Number of balls causing a player to walk.
   */
  public static final int MAX_BALLS = 5;

  /**
   * Number of outs before the teams switch.
   */
  public static final int MAX_OUTS = 3;
  
  /**
   * Number of total inning in a game
   */
  private int totalInning;
  
  /**
   * Number of current inning
   */
  private int currentInning;
  
  /**
   * Check first half or second half of a inning
   */
  private boolean topOrbottom;
  
  /**
   * Number of ball means the batter doesn't swing at the ball, but the umpire declares that it wasn’t accurately thrown.
   */
  private int numOfball;
  
  /**
   * Number of the batter doesn't swing at the ball, but the umpire declares that it was accurately thrown.
   */
  private int numOfstrike;
  
  /**
   * Number of people out
   */
  private int numOfout;
  
  /**
   * Check if game is over or not
   */
  private boolean checkGameEnded;
  
  /**
   * Check if base 1 have people of team batter or not
   */
  private boolean base1;
  
  /**
   * Check if base 2 have people of team batter or not
   */
  private boolean base2;
  
  /**
   * Check if base 3 have people of team batter or not
   */
  private boolean base3;
  
  /**
   * Points for team 0
   */
  private int team0;
  
  /**
   * Points for team 1
   */
  private int team1;
  
  /**
   * Constructs a game that has the given number of innings and starts at the top of inning 1.
   * @param givenNumInnings
   */
  public Corkball(int givenNumInnings) {
	  
	  totalInning = givenNumInnings;
	  currentInning = 1;
	  topOrbottom = true;
	  numOfstrike = 0;
	  numOfball = 0;
	  numOfout = 0;
	  checkGameEnded = false;
	  base1 = false;
	  base2 = false;
	  base3 = false;
	  team0 = 0;
	  team1 = 0;
  }
  
  /**
   * Returns true if the game is over, false otherwise.
   */
  public boolean gameEnded() {
	  return checkGameEnded;
  }
  
  /**
   * Returns the current inning.
   */
  public int whichInning() {
	  return currentInning;
  }
  
  /**
   * Returns the count of balls for the current batter.
   */
  public int getBallCount() {
	  return numOfball;
  }
  
  /**
   * Returns the number of called strikes for the current batter.
   */
  public int getCalledStrikes() {
	  return numOfstrike;
  }
  
  /** 
   * Returns the number of outs for the team currently at bat.
   */
  public int getCurrentOuts() {
	  return numOfout;
  }
  
  /** 	
   * Returns the score for team 0.
   */
  public int getTeam0Score() {
	  return team0;
  }
  
  /**
   * Returns the score for team 1.
   */
  public int getTeam1Score() {
	  return team1;
  }
  
  /**
   * Returns true if it's the first half of the inning (team 0 is at bat).
   */
  public boolean isTopOfInning() {
	  return topOrbottom;
  }
  
  /**
   * Returns true if there is a runner on the indicated base, false otherwise.
   */
  public boolean runnerOnBase(int which) {
	  if (which == 1) {
		  return base1;
	  }
	  else if (which == 2) {
		  return base2;
	  }
	  else if (which == 3) {
		  return base3;
	  }
	  else {
	  return false;
	  }
  }
  
  
  /**
   * Method called to indicate that the batter hit the ball.
   */
  public void hit(int distance) {
	  
	  if (!checkGameEnded) {						//if the game is not over
	  
		  if (distance < 15) {						// a foul, batter is out
			  
			  SwitchToNewBat();
			  numOfout += 1;
			  
			  if (numOfout == MAX_OUTS ) {			// team switch when each team reaches maximum the number of people out
				   
				  SwitchingTeam();
					  
				  if (currentInning > totalInning) {	// when team switch, inning will change so must check when the inning reach max inning
				  
					  checkGameEnded = true;  
				  }
			  }
		  }
		  else if (distance < 150) {				//a single
			  
			  SwitchToNewBat();
			  
			  shiftRunners();
			  base1 = true; 
		  }  
		  else if (distance < 200) {			//a double
			  
			  SwitchToNewBat();	
			  
			  shiftRunners();
			  base1 = true;
			  shiftRunners();
		  }
		  else if (distance < 250) {			//a triple
			  
			  SwitchToNewBat();
			  
			  shiftRunners();
			  base1 = true;
			  shiftRunners();
			  shiftRunners();
		  }
		  else {						// Home run
			  
			  SwitchToNewBat();
			  
			  updateScores(1);
			  
			  if (base1) {
				  updateScores(1);
			  }
			  if (base2) {
				  updateScores(1);
			  }
			  if (base3) {
				  updateScores(1);
			  }
		  }
	  }
	  else {							//if game is over
		  
		  CannotChangeWhengameEnded(); 	  
	  }	  
  }
  
  /**
   * Method called to indicate a strike for the current batter.
   */
  public void strike(boolean swung) {
	  
	  if (!checkGameEnded) {
	  
		  if (swung) {					// when the batter swings the stick at the ball and misses​, the batter is out immediately	
			  
			  SwitchToNewBat();
			  numOfout += 1;
		  }
		  else {						// when batter not swung, but good thrown
			  
			  numOfstrike += 1; 		 
			  
			  if (numOfstrike == MAX_STRIKES) {		// two strikes will be out
				  
				  SwitchToNewBat();
				  numOfout += 1;
			  }
		  }
	  }
	  else {							//if game is over
		  
		  CannotChangeWhengameEnded();
		  
	  }
	  if (numOfout == MAX_OUTS) {			// team switch when each team reaches maximum the number of people out
		  	  
		  SwitchingTeam();
	  }	
		  if (currentInning > totalInning) {	// when team switch, inning will change so must check when the inning reach max inning
			  checkGameEnded = true;
		  }	  
  }
  
  /**
   * Method called to indicate a bad pitch at which the batter did not swing.
   */
  public void ball() {
	  
	  if (!checkGameEnded) {		//if the game is not over
		  
		  numOfball += 1;			//number of ball add one when its a bad pitch at which the batter did not swing
		  
		  if (numOfball == MAX_BALLS) {		//when the number of ball reaches max_balls, batter gets a walk
			
			  SwitchToNewBat();	
			  
			  shiftRunnersForWalk();	  
		  }
	  }
	  else {						//if the game is over
		  
		  CannotChangeWhengameEnded(); 
	  }
  }
  
  /**
   * Method called to indicate that the batter is out due to a caught fly.
   */
  public void caughtFly() {
	  
	  if (!checkGameEnded) { 					//if the game is not over
		  
		  SwitchToNewBat();
		  numOfout += 1;						//when ball is caught, batter is immediately out
		  
		  if (numOfout == MAX_OUTS ) {			// team switch when each team reaches maximum the number of people out
			  	  
			  SwitchingTeam();
		  }	
	  }
	  else {									//if the game is over
		  
		  CannotChangeWhengameEnded(); 
	  }
	  if (currentInning > totalInning) {	// when reach maximum inning, game ends
		  
		  checkGameEnded = true;
	  }
  }
  
  
  /**
   * Updating score for the appropriate team, depending on whether it top or bottom
   * @param numPointsGot 
   */
  private void updateScores(int numPointsGot) { 
	  
	  if (!topOrbottom) {
		  
		  team1 += numPointsGot;
	  }
	  else {
		  
		  team0 += numPointsGot;
	  }
  }
  
  /**
   * Switching teams 
   * (switches top to bottom, or bottom to top plus next inning, and resets outs)
   */
  private void SwitchingTeam() {
	  
	  base1 = false;
	  base2 = false;
	  base3 = false;
	  numOfout = 0;
	  
	  if (topOrbottom) {
		  
		  topOrbottom = false;
	  }
	  else {
		  
		  topOrbottom = true;
		  currentInning += 1;	  
	  }
  }
  
  /**
   * Switching to a new batter (resets balls and strikes)
   */
  private void SwitchToNewBat() {
	  
	  numOfball = 0;
	  numOfstrike = 0;
  }
  
  /**
   * Shifting all runners to the next base
   */
  private void shiftRunners() {
	  
	  if (base3) {
		  
		  updateScores(1);
		  base3 = false;
	  }
	  if (base2) {
		  
		  base3 = true;
		  base2 = false;
	  }
	  if (base1) {
		  
		  base2 = true;
		  base1 = false;
	  }
  }
  
  /**
   * Shifting runners for a walk
   */
  private void shiftRunnersForWalk() {
	  
	  if (!base1) {
		  
		  base1 = true;
	  }
	  else {
		  
		  if (!base2) {
			  base2 = true;
		  }
		  else {
			  
			  if (!base3) {
				  
				  base3 = true;
			  }
			  else {
				  
				  updateScores(1);
			  }
		  }
	  }
  }
  
  /**
   * When game ended, all variables can not be modified
   */
  private void CannotChangeWhengameEnded() {
	  
	  base1 = false;
	  base2 = false;
	  base3 = false;
	  team0 = 0;
	  team1 = 0;
	  numOfstrike = 0;
	  numOfball = 0;
	  numOfout = 0; 
  }

  /**
   * Returns a three-character string representing the players on base, in the
   * order first, second, and third, where 'X' indicates a player is present and
   * 'o' indicates no player. For example, the string "XXo" means that there are
   * players on first and second but not on third.
   * 
   * @return three-character string showing players on base
   */
  public String getBases()
  {
    return (runnerOnBase(1) ? "X" : "o") + (runnerOnBase(2) ? "X" : "o")
        + (runnerOnBase(3) ? "X" : "o");
  }

  /**
   * Returns a one-line string representation of the current game state. The
   * format is:
   * 
   * <pre>
   *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
   * </pre>
   * 
   * The first three characters represent the players on base as returned by the
   * <code>getBases()</code> method. The 'T' after the inning number indicates
   * it's the top of the inning, and a 'B' would indicate the bottom. The score always
   * shows team 0 first.
   * 
   * @return one-line string representation of the game state
   */
  public String toString()
  {
    String bases = getBases();
    String topOrBottom = (isTopOfInning() ? "T" : "B");
    String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
    return String.format(fmt, bases, whichInning(), topOrBottom, getTeam0Score(),
        getTeam1Score(), getBallCount(), getCalledStrikes(), getCurrentOuts());
  }


}
