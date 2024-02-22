package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FluidElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean highlight;
}
