package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.DisplayMode;
import fr.frinn.custommachinery.json_schema.utils.Mode;

public class ExperienceElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private DisplayMode display;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Mode mode;
}
