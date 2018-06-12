package pattern.chainOfResp;

public abstract class Handler {
	
	private Handler nextHandler;
	private int level;
	public Handler(int level) {
		this.level = level;
	}
	
	public final void handlerMsg(Demand demand) {
		if (level == demand.demandLevel()) {
			this.report(demand);
		} else {
			if (this.nextHandler != null) {
				System.out.println("report to upper level");
				this.nextHandler.handlerMsg(demand);
			} else {
				System.out.println("No upper level");
			}
		}
	}
	
	public void setNextHandler(Handler handler) {
		this.nextHandler = handler;
	}
	
	public abstract void report(Demand demand);

}
