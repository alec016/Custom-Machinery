package fr.frinn.custommachinery.json_schema.utils;

public enum Phase {
  STARTING("starting"),
  CRAFTING_TICKABLE("crafting_tickable"),
  CRAFTING_DELAYED("crafting_delayed"),
  ENDING("ending");
  private final String value;
  Phase(String value) {
    this.value = value;
  }

  public String toString() {
    return value;
  }
}
