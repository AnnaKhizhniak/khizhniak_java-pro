package phonebook;

record Record(String name, String phoneNumber) {
  @Override
  public String toString() {
    return "  { name: \"" + name + "\", phoneNumber: " + phoneNumber + " }";
  }
}
