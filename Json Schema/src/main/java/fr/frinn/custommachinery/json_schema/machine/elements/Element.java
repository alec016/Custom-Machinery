package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.Tooltip;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@JsonSubTypes({
  @JsonSubTypes.Type(value = BarElement.class, name = "custommachinery:bar"),
  @JsonSubTypes.Type(value = ButtonElement.class, name = "custommachinery:button"),
  @JsonSubTypes.Type(value = ConfigElement.class, name = "custommachinery:config"),
  @JsonSubTypes.Type(value = DumpElement.class, name = "custommachinery:dump"),
  @JsonSubTypes.Type(value = EnergyElement.class, name = "custommachinery:energy"),
  @JsonSubTypes.Type(value = ExperienceElement.class, name = "custommachinery:experience"),
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public abstract class Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Min(0)
  private int x;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Min(0)
  private int y;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(-1)
  private int width;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(-1)
  private int height;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int priority;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Tooltip> tooltips;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String textureHovered;
}
