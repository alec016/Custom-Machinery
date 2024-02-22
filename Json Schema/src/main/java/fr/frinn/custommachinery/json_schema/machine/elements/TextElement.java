package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.utils.Alignment;
import fr.frinn.custommachinery.json_schema.utils.Tooltip;

public class TextElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @JsonSubTypes({
    @JsonSubTypes.Type(Tooltip.class),
    @JsonSubTypes.Type(String.class)
  })
  private Tooltip text;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Alignment alignment;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean jei;
}
