import java.util.List;

public interface LotteryInterface {
	public void createLotteryticket(String userName);
	public List<Lottery> getLotteryticket();
	public void distributePrize();
	public void getInput();
}
