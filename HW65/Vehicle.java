public abstract class Vehicle {
    private String name;
    private Double speed;

    public Vehicle(String name, Double speed) {
        setName(name);
        setSpeed(speed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("name= %s, speed= %.2f", getName(), getSpeed());
    }
}