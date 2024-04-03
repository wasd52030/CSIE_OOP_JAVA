import java.lang.reflect.Field;

public abstract class Vehicle implements Rental {
    private Double rent;
    private String color;

    public Vehicle(Double r, String c) {
        setRent(r);
        setColor(c);
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
}
