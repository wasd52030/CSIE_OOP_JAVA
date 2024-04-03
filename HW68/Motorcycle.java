public class Motorcycle extends Vehicle {

    private boolean hasBasket;

    public Motorcycle(String color, boolean hasBasket) {
        super(400d, color);
        setHasBasket(hasBasket);

        checkMilage((int) (Math.random() * 2001) + 1000);
        checkOilConsumption((int) (Math.random() * 201) + 100);
        checkTotalConst();
    }

    public boolean getHasBasket() {
        return hasBasket;
    }

    public void setHasBasket(boolean hasBasket) {
        this.hasBasket = hasBasket;
    }

    @Override
    public double TotalRent(int days) {
        var r = super.TotalRent(days);
        if (hasBasket) {
            r += 50 * days;
        }
        return r;
    }

    @Override
    void showProfile() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(super.toString());
        System.out.printf("hasBasket: %b\n", getHasBasket());
    }

}
