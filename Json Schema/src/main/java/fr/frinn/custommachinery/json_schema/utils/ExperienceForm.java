package fr.frinn.custommachinery.json_schema.utils;

public enum ExperienceForm {
  LEVEL("level"),
  POINT("point");

  private final String value;
  ExperienceForm(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
