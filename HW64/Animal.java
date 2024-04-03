public abstract class Animal {
    private String name, color;

    public Animal(String name, String color) {
        setName(name);
        setColor(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("name= %s, color= %s", getName(), getColor());
    }
}
