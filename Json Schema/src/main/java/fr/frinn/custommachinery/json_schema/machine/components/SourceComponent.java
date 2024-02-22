package fr.frinn.custommachinery.json_schema.machine.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.ComponentIOMode;
import jakarta.validation.constraints.Positive;

public class SourceComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Positive
  private int capacity;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private ComponentIOMode mode;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Positive
  private int maxInput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Positive
  private int maxOutput;
}
