package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManaElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean highlight;
}
