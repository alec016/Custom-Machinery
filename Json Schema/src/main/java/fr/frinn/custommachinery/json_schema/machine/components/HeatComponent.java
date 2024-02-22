package fr.frinn.custommachinery.json_schema.machine.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.Config;

public class HeatComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private double capacity;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private double base_temp;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private double conduction;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private double insulation;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Config config;
}
