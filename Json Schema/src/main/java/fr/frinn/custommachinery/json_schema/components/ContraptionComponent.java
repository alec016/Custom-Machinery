package fr.frinn.custommachinery.json_schema.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.Config;
import jakarta.validation.constraints.PositiveOrZero;

public class ContraptionComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @PositiveOrZero
  private float stress_impact;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Config config;
}
