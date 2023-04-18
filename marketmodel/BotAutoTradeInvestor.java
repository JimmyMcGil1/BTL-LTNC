package marketmodel;
import view.UserView;
public class BotAutoTradeInvestor implements IInvestor{
    //Attributes:
	private String name;
	private String[] msgLog;
	private int numOfMsg;
	private UserView uv;	
	//Methods:
	public BotAutoTradeInvestor(String name) {
		this.name = name;
		this.msgLog = new String[10];
		this.numOfMsg = 0;
		this.uv = null;
	}
	public void setUserView(UserView uv) {
		this.uv = uv;
	}
	public String getName() {
		return this.name;
	}
	public String getMsg(int i) {
		return this.msgLog[i];
	}
	@Override
	public void update(String msg) {
		// TODO Auto-generated method stub
		this.numOfMsg = (numOfMsg >= 10) ? numOfMsg : numOfMsg + 1;
		//bubble swap
		for(int i = numOfMsg - 1; i >= 0; i--) {
			if(this.msgLog[i] != null) this.msgLog[i+1] = this.msgLog[i];
		}
		//insert text & update
		this.msgLog[0] = msg;
		//System.out.println(this.name + ": " + this.msgLog[0]);
		if(this.uv != null) this.uv.msgUpdate();
	}
	
}