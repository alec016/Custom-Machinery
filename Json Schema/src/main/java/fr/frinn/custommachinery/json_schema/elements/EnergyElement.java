package fr.frinn.custommachinery.json_schema.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import jakarta.validation.constraints.Pattern;

public class EnergyElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean highlight;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_empty;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_filled;
}
