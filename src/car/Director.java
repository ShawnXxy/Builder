package car;

public class Director {

    private IBuilder builder;
    
    public Director(IBuilder builder) {
        this.builder = builder;
    }
    
    /**
     * ¹¹ÔìË³Ğò
     */
    public Production construct() {
        builder.buildPart1();
        builder.buildPart2();
        return builder.build();
    }
}
