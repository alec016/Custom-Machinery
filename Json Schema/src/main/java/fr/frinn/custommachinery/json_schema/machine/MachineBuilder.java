package fr.frinn.custommachinery.json_schema.machine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.machine.components.Component;
import fr.frinn.custommachinery.json_schema.machine.elements.Element;
import fr.frinn.custommachinery.json_schema.utils.Tooltip;
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
