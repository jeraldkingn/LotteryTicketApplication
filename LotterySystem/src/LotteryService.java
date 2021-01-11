import java.util.List;

public class LotteryService {

	private LotteryInterface lotteryInterface;
	
	public LotteryService(LotteryInterface lotteryInterface) {
		this.lotteryInterface = lotteryInterface;
	}
	
	public static LotteryService getInterfaceObj(){
        return new LotteryService(new LotteryImpl());
    }
	
	public List<Lottery> getLotteryticket(){
    	 return lotteryInterface.getLotteryticket();	
	}
	

	public void createLottery(String userName){
    	 lotteryInterface.createLotteryticket(userName);	
	}
	
	public void distributePrize(){
		lotteryInterface.distributePrize();	
	}
	public void getInput() {
		lotteryInterface.getInput();	
	}

}
