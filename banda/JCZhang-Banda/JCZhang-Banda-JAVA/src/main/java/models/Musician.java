package models;

public class Musician extends Person{
    String name;
    int yearsOfExperience;

    static double salary = 1500.00;
    public Musician(String name, int yearsOfExperience){
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;

    }

    @Override
    public void breath() {
        super.breath();
    }

    public void interpret(){
        System.out.println("Im interpreting");
    }
}
