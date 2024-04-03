import java.lang.reflect.Field;

public abstract class Vehicle implements Rental, Check {
    private Double rent;
    private String color;

    private int Milage; // 里程數
    private int OilConsumpton; // 耗油量
    private int TotalCost; // 總成本

    public Vehicle(Double r, String c) {
        setRent(r);
        setColor(c);

        getOilValue();
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double r) {
        rent = r;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        color = c;
    }

    abstract void showProfile();

    @Override
    public double TotalRent(int days) {
        return rent * days;
    }

    @Override
    public String toString() {
        // https://stackoverflow.com/questions/15315368/get-all-private-fields-using-reflection
        var fields = this.getClass().getSuperclass().getDeclaredFields();
        var strBuild = new StringBuilder();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                strBuild.append(String.format("%s: %s\n", field.getName(), field.get(this)));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return strBuild.toString();
    }

    public void getOilValue() {
        System.out.println(String.format("油價: %d\n", OilValue));
    }

    @Override
    public void checkMilage(int Milage) {
        this.Milage = Milage;
    }

    @Override
    public int getMilage() {
        return Milage;

    }

    @Override
    public void checkOilConsumption(int OilConsumption) {
        this.OilConsumpton = OilConsumption;
    }

    public int getOilConsumpton() {
        return OilConsumpton;
    }

    @Override
    public int TotalCost(int OilValue, int Milage, int OilConsumption) {
        return 3 * getMilage() + getOilConsumpton() * OilValue;
    }

    public void checkTotalConst() {
        this.TotalCost = TotalCost(OilValue, getMilage(), getOilConsumpton());
    }
}
