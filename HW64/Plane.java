public class Plane extends Vehicle implements Flyer {

    public Plane(String name, Double speed) {
        super(name, speed);
    }

    @Override
    public void fly() {
        System.out.printf("%s在天上飛\n", getName());
    }
    
}
