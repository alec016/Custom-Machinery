package fr.frinn.custommachinery.json_schema.machine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.utils.Tooltip;

public class Machine extends MachineBuilder {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @JsonSubTypes({
    @JsonSubTypes.Type(value = Tooltip.class),
    @JsonSubTypes.Type(value = String.class)
  })
  private String name;
}