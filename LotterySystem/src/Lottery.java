
public class Lottery {

	private String userName;
	private long userId;
	private long randTicket;
	private boolean flag;

	public Lottery(long userId, String userName, long randTicket, boolean flag) {
		this.flag = flag;
		this.userId = userId;
		this.userName = userName;
		this.randTicket = randTicket;
	}
	
	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getRandTicket() {
		return randTicket;
	}

	public void setRandTicket(long randTicket) {
		this.randTicket = randTicket;
	}

	@Override
	public String toString(){
	        return String.format(userName +  userId +  randTicket + flag);
	    }

}
