package fr.frinn.custommachinery.json_schema.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.Tooltip;
import fr.frinn.custommachinery.json_schema.utils.ItemStack;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class ButtonElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_toggle;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture_toggle_hovered;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean toggle;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Tooltip text;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes({
    @JsonSubTypes.Type(String.class),
    @JsonSubTypes.Type(ItemStack.class)
  })
  @Pattern(regexp = Init.RL)
  private String item;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int hold_time;
}
