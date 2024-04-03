public class Balloon implements Flyer {

    private String color;

    public Balloon(String color){
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("color= %s", getColor());
    }

    @Override
    public void fly() {
        System.out.printf("%s顏色氣球在天上飛\n", getColor());
    }

}