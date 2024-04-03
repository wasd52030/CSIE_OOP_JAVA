// file encode utf8 build command -> javac -encoding utf-8 main.java

public class main {

    public static void main(String[] args) {
        Dog d1 = new Dog("犬科", "麻吉", 12, "嗚~汪汪汪", "鬆獅犬", "淺褐色", "大型");
        Dog d2 = new Dog("犬科", "麻吉", 12, "嗚~汪汪汪", "鬆獅犬", "淺褐色", "大型");

        d1.showProfile();
        d1.makeSound();

        d2.showProfile();
        d2.makeSound();
        System.out.println();

        // 在不做額外動作的話執行得到false
        // Java Class都繼承自Object class,equals這個method就是從那裏來的
        // 要比對內容的話需要override equals method
        System.out.println(d1.equals(d2));
    }
}

class Dog extends Animal {
    private String breed, color, size;

    public Dog() {
    }

    public Dog(String species, String name, int age, String voice, String breed, String color, String size) {
        super(species, name, age, voice);
        this.breed = breed;
        this.color = color;
        this.size = size;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog d = (Dog) o;
            boolean b1 = this.getName().equals(d.getName()) && this.getAge() == d.getAge()
                    && this.getSpecies().equals(d.getSpecies())
                    && this.getVoice().equals(d.getVoice());
            boolean b2 = this.getBreed().equals(d.getBreed()) && this.getColor().equals(d.getColor())
                    && this.getSize().equals(d.getSize());

            return b1 && b2;
        }

        return false;

    }

    @Override
    void showProfile() {
        super.showProfile();
        System.out.printf("品種：%s\n", this.getBreed());
        System.out.printf("顏色：%s\n", this.getColor());
        System.out.printf("體型：%s\n", this.getSize());
    }

    @Override
    void makeSound() {
        System.out.printf("姓名叫做%s的%s，發出了%s的聲音\n", super.getName(), super.getSpecies(), super.getVoice());
        System.out.printf("牠的品種是%s,顏色是%s,體型是%s", this.getBreed(), this.getColor(), this.getSize());
    }
}