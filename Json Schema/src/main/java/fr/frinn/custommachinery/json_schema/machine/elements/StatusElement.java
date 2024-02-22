package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import jakarta.validation.constraints.Pattern;

public class StatusElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_idle;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_running;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_errored;
}
