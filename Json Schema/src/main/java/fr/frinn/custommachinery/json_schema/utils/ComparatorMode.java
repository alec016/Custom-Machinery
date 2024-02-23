package fr.frinn.custommachinery.json_schema.utils;

public enum ComparatorMode {

  GREATER(">>"),
  GREATER_OR_EQUALS(">="),
  EQUALS("=="),
  LESSER_OR_EQUALS("<="),
  LESSER("<<");
  private final String prefix;

  ComparatorMode(String prefix) {
    this.prefix = prefix;
  }

  public String toString() {
    return prefix;
  }
}
