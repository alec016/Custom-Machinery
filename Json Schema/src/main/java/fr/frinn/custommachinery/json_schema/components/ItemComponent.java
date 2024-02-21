package fr.frinn.custommachinery.json_schema.components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.ComponentIOMode;
import fr.frinn.custommachinery.json_schema.utils.Config;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class ItemComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private ComponentIOMode mode;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int capacity;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int maxInput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int maxOutput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<
    @Pattern(regexp = Init.RL)
    String
  > filter;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean whitelist;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Config config;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean locked;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Variant variant;

  @JsonSubTypes({
    @JsonSubTypes.Type(value = Default.class, name = "custommachinery:default"),
    @JsonSubTypes.Type(value = Energy.class, name = "custommachinery:energy"),
    @JsonSubTypes.Type(value = Filter.class, name = "custommachinery:filter"),
    @JsonSubTypes.Type(value = Fluid.class, name = "custommachinery:fluid"),
    @JsonSubTypes.Type(value = Fuel.class, name = "custommachinery:fuel"),
    @JsonSubTypes.Type(value = Result.class, name = "custommachinery:result"),
    @JsonSubTypes.Type(value = Upgrade.class, name = "custommachinery:upgrade")
  })
  @JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type"
  )
  private static class Variant {}
  private static class Default extends Variant {}
  private static class Energy extends Variant {}
  private static class Filter extends Variant {}
  private static class Fluid extends Variant {}
  private static class Fuel extends Variant {}
  private static class Result extends Variant {}
  private static class Upgrade extends Variant {}
}
