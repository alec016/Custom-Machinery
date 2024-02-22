package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.Orientation;
import jakarta.validation.constraints.Pattern;

public class BarElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int min;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int max;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean highlight;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_empty;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_filled;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Orientation orientation;
}
