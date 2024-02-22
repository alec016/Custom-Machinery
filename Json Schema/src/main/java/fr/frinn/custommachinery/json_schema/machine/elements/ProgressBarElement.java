package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.Orientation;
import jakarta.validation.constraints.Pattern;

public class ProgressBarElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_empty;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_filled;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Orientation direction;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private float start;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private float end;
}
