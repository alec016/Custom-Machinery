package fr.frinn.custommachinery.json_schema.utils;

public enum BlockAction {
  CHECK("check"),
  BREAK("break"),
  DESTROY("destroy"),
  PLACE("place"),
  REPLACE_BREAK("replace_break"),
  REPLACE_DESTROY("replace_destroy");

  private final String value;

  BlockAction(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
