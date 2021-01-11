public class Main {

	/**
	 * 
	 * 
	 * ---------Lottery Ticket ( Prototype )-------------- 
	 * 
	 * Made with scanner for Interaction 
	 * 
	 * Implemented with 10 lottery tickets  || After 10 tickets , Tickets sold message will be shown 
	 * 
	 * 		prize : 1 person - 1 million /- 
	 * 				2 persons - 10 lakh /- 
	 * 				rest - will get 1-10 rupees
	 * 
	 * Implementation - realtime
	 * 		We can use cron for 1 hour interval and database for storing id,userName,TicketNo(12 digit),flag
	 * 		Same business logic implemented in the prototype can be implemented for the realtime
	 * 	
	 * Provide sample inputs, for example: "Your Name" || Should be >3 ( Validation included )
	 */

	static LotteryService LotteryServiceObject = LotteryService.getInterfaceObj();

	public static void main(String[] args) {
		LotteryServiceObject.getInput();
	}
}
