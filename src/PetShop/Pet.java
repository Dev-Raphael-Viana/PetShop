package PetShop;

public class Pet {
    public String name;
    private int age;
    private int meses;
    private double peso;

    public Pet() {

    }
    public Pet(String name, int age, int meses, double peso) {
        this.name = name;
        this.age = age;
        this.meses = meses;
        this.peso = peso;
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
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

}
