public class Car extends Vehicle {
    private int doorNum;

    public Car(String color, int doorNum) {
        super(1000d, color);
        setDoorNum(doorNum);
    }

    public int getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(int doorNum) {
        this.doorNum = doorNum;
    }

    @Override
    public double TotalRent(int days) {
        var r = super.TotalRent(days);
        if (doorNum <= 2) {
            r *= 2;
        }
        return r;
    }

    @Override
    void showProfile() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(super.toString());
        System.out.printf("door number: %d\n", getDoorNum());
    }
}
