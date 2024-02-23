package fr.frinn.custommachinery.json_schema.utils;

public enum DropAction {
  CHECK("check"),
  CONSUME("consume"),
  PRODUCE("produce");

  private final String value;
  DropAction(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
