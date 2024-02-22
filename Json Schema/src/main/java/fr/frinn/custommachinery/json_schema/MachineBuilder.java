package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.components.Component;
import fr.frinn.custommachinery.json_schema.elements.Element;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class MachineBuilder {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Appearance appearance;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes({
    @JsonSubTypes.Type(Tooltip.class)
  })
  private List<Tooltip> tooltips;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Element> gui;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Element> jei;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Component> components;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Processor processor;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<
    @Pattern(regexp = Init.RL)
    String
  > catalysts;
}
