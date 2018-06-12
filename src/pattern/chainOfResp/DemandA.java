package pattern.chainOfResp;

public class DemandA implements Demand {

	@Override
	public int demandLevel() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String detail() {
		// TODO Auto-generated method stub
		return "do sth here";
	}

}
