package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.validation.constraints.Pattern;

public class UpgradedMachine extends MachineBuilder {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Pattern(regexp = Init.RL)
  private String parent;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonPropertyDescription("default value: Upgraded + `parent name`")
  @JsonSubTypes({
    @JsonSubTypes.Type(value = Tooltip.class),
    @JsonSubTypes.Type(value = String.class)
  })
  private String name;
}
