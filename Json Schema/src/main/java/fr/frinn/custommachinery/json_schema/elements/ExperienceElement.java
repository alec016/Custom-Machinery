package fr.frinn.custommachinery.json_schema.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExperienceElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private DisplayMode display;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Mode mode;

  private enum Mode {
    INPUT_ONE,
    INPUT_TEN,
    INPUT_ALL,
    OUTPUT_ONE,
    OUTPUT_TEN,
    OUTPUT_ALL,
    DISPLAY,
    DISPLAY_BAR
  }
  private enum DisplayMode {
    LITERAL, LEVEL, BOTH
  }
}
