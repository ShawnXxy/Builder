package car;

public class BuilderA implements IBuilder {
    
    private Production production = new Production();

    @Override
    public void buildPart1() {
        // TODO Auto-generated method stub
        System.out.println("������������ĵ�һ���֡�");
        production.setPart1("This is part1 of Lamborghini");
    }

    @Override
    public void buildPart2() {
        // TODO Auto-generated method stub
        System.out.println("������������ĵڶ����֡�");
        production.setPart2("This is part2 of Lamborghini");
    }

    @Override
    public Production build() {
        // TODO Auto-generated method stub
        System.out.println("�ǲ���������������ã�");
        return production;
    }

}
