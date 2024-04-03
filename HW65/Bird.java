public class Bird extends Animal implements Flyer {

    public Bird(String name, String color) {
        super(name, color);
    }

    @Override
    public void fly() {
        System.out.printf("%s在天上飛\n", getName());
    }

}
