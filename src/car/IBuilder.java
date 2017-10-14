package car;

public interface IBuilder {
    
    // The number of buildPart() will be the same number of parts
    public void buildPart1();
    public void buildPart2();
    // return production
    public Production build();
}
