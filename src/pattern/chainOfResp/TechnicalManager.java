package pattern.chainOfResp;

public class TechnicalManager extends Handler{

	public TechnicalManager() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void report(Demand demand) {
		// TODO Auto-generated method stub
		System.out.println(demand.detail());
		System.out.println(getClass().getSimpleName());
	}

}


