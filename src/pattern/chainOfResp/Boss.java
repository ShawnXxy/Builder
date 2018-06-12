package pattern.chainOfResp;

public class Boss extends Handler {

	public Boss() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void report(Demand demand) {
		// TODO Auto-generated method stub
		System.out.println(demand.detail());
		System.out.println(getClass().getSimpleName());
	}
	
}
