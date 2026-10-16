public class Main {
  public static void main(String[] args) {
    Cat cat = new Cat("Monya");
    cat.run(200);
    cat.swim(200);

    Dog dog = new Dog("Bobik");
    dog.swim(10);
    dog.run(200);

    Dog dog2 = new Dog("Buba");
    dog2.swim(15);
    dog2.run(-200);

    System.out.println("Dogs count: " + Dog.getDogsCount());
    System.out.println("Cats count: " + Cat.getCatsCount());
    System.out.println("Animals count: " + Animal.getAnimalsCount());
  }
}
