package PetShop;

public class Pet {
    public String name;
    private int age;
    private int meses;

    public Pet() {

    }
    public Pet(String name, int age, int meses) {
        this.name = name;
        this.age = age;
        this.meses = meses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
}
