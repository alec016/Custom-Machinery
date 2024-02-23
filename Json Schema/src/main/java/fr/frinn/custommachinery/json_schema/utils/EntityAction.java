package fr.frinn.custommachinery.json_schema.utils;

public enum EntityAction {
  CHECK_AMOUNT("check_amount"),
  CHECK_HEALTH("check_health"),
  CONSUME_HEALTH("consume_health"),
  KILL("kill");

  private final String value;

  EntityAction(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
