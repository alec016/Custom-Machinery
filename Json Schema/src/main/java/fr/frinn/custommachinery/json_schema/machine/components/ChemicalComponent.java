package fr.frinn.custommachinery.json_schema.machine.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.ComponentIOMode;
import fr.frinn.custommachinery.json_schema.utils.Config;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public abstract class ChemicalComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private long capacity;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private ComponentIOMode mode;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<@Pattern(regexp = Init.RL) String> filter;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean whitelist;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private long max_input;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private long max_output;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Config config;
}
