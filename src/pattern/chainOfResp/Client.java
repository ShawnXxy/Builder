package pattern.chainOfResp;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demand demandA =  new DemandA();
		Demand demandB = new DemandB();
		
		Boss boss = new Boss();
		TechnicalManager technicalManager = new TechnicalManager();
		technicalManager.setNextHandler(boss);
		
		technicalManager.handlerMsg(demandA);
		technicalManager.handlerMsg(demandB);

	}

}
