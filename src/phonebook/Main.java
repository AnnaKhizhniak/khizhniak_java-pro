package phonebook;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    PhoneList phoneList = new PhoneList();

    phoneList.add(new Record("Anna", "+380123456712"));
    phoneList.add(new Record("Joe", "+380444444444"));
    phoneList.add(new Record("Dima", "+380222222222"));
    phoneList.add(new Record("Anna", "+380666666666"));
    phoneList.add(new Record("Ihor", "+38011111111"));
    phoneList.add(new Record("Maks", "+380999999999"));
    phoneList.add(new Record("Ira", "+381212121212"));
    phoneList.add(new Record("Dima", "+380333333333"));

    Record findOneRes = phoneList.find("Anna");
    System.out.println("One record = " + findOneRes);

    List<Record> findAllRes =  phoneList.findAll("Anna");
    System.out.println("All records = " + findAllRes);
  }
}
