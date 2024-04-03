import java.lang.reflect.Field;

public abstract class Appliances {
    private String type, name, location;
    private int consumption;

    public Appliances(String type, String name, String location, int consumption) {
        setType(type);
        setName(name);
        setLocation(location);
        setConsumption(consumption);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    void showProfile() {
        System.out.println(this);
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
