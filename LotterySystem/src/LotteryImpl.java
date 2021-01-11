import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LotteryImpl implements LotteryInterface {

	static List<Lottery> lotteryList = ApplicationConstants.lotteryList;
	static LotteryService LotteryServiceObject = LotteryService.getInterfaceObj();

	static Random nuRandom = new Random();
	static int count = 1;

	public LotteryImpl() {
	}

	@Override
	public void createLotteryticket(String userName) {
		long userId = 0;
		long randTicket = nuRandom.nextInt(100000000);
		userId = userId + 1;
		boolean flag = false;

		Lottery lotteryTicketLottery = new Lottery(userId, userName, randTicket, flag);
		lotteryList.add(lotteryTicketLottery);
		ApplicationConstants.lotteryList = lotteryList;
	}

	@Override
	public List<Lottery> getLotteryticket() {
		return lotteryList;
	}

	@Override
	public void distributePrize() {
		System.out.println("Total Tickets: " + lotteryList.size()+ "\n");
		System.out.println("1 million rupees prize winner\n");
		prizeList(1);
		System.out.println("\n10 lakh rupees prize winner\n");
		prizeList(2);
		System.out.println("\nParticipation Prize\n");
		prizeList();
	}

	@Override
	public void getInput() {

		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		int count = 1;
		
		int totalLottery = 10; // Total lottery tickets -- 1 Million tickets
		
		System.out.println("---------------Lottery Contest--------------- \n\n");
		while (!isValid) {
			System.out.println("Enter Name");
			String userName = input.nextLine();
					
			if (count == totalLottery) {
				System.out.println("\nTickets sold\n");
				LotteryServiceObject.createLottery(userName);
				LotteryServiceObject.distributePrize();
				break;
			}
			if (userName.equals("seeAllBuyers")) {
				(LotteryServiceObject.getLotteryticket()).forEach(lottery -> {
					System.out.println(lottery.toString());
				});
				continue;
			}
			if (userName.length() >= 4) {
				LotteryServiceObject.createLottery(userName);
				count++;
				continue;
			}
			

			System.out.println("Invalid! Name should have atleast 4 char");
		}
	}
	
	private static void prizeList(int prizeNumber) {
		
		lotteryList.forEach(lotteryTicket -> {

			while (count <= prizeNumber) {
				int luckyNumberPrize = nuRandom.nextInt(lotteryList.size());

				if (lotteryTicket.getFlag() != true) {
					Lottery luckyLotteryNum = lotteryList.get(luckyNumberPrize);

					System.out.println("Name : " + luckyLotteryNum.getUserName() + " Lucky Id : "
							+ luckyLotteryNum.getRandTicket());
					luckyLotteryNum.setFlag(true);
					count++;
				}
			}
		});
		count = 1;
	}

	private static void prizeList() {
		lotteryList.forEach(lotteryTicket -> {
			int luckyNumberPrize = nuRandom.nextInt(10)+1;
			
			if (lotteryTicket.getFlag() != true) {
				System.out.println("Name : " + lotteryTicket.getUserName() + " Lucky Id : "
						+ lotteryTicket.getRandTicket() + " Prize Amount : " + luckyNumberPrize);
				lotteryTicket.setFlag(true);
			}
			
		});
	}

}
