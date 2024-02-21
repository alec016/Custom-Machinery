package fr.frinn.custommachinery.json_schema.components;

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
  @Pattern(regexp = "custommachinery:[energy|filter|fluid|fuel|result|upgrade]")
  private String variant;
}
