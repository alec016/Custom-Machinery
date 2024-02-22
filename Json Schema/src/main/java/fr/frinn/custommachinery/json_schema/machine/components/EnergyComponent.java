package fr.frinn.custommachinery.json_schema.machine.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.Config;
import jakarta.validation.constraints.Positive;

public class EnergyComponent extends Component {

  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Positive
  private long capacity;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Positive
  private long maxInput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Positive
  private long maxOutput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Config config;
}
