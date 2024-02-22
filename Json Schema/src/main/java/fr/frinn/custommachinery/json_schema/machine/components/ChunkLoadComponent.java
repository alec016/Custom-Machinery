package fr.frinn.custommachinery.json_schema.machine.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class ChunkLoadComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  @Max(32)
  private int radius;
}
