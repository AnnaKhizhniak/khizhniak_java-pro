package lists_practice;

public record ListEntity(String name, Integer occurrence) {
  @Override
  public String toString() {
    return "  { name: \"" + name + "\", occurrence: " + occurrence + " }";
  }
}
