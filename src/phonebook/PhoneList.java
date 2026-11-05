package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {
  private final List<Record> phoneList = new ArrayList<>();

  public void add(Record record) {
    phoneList.add(record);
  }

  public Record find(String name) {
    for(Record record : phoneList) {
      if (record.name().equals(name)) {
        return record;
      }
    }

    return null;
  }

  public List<Record> findAll(String name) {
    List<Record> result = new ArrayList<>();

    for(Record record : phoneList) {
      if (record.name().equals(name)) {
        result.add(record);
      }
    }

    return result.isEmpty() ? null : result;
  }
}
