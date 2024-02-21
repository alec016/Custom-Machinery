package fr.frinn.custommachinery.json_schema.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;
import java.util.List;

public class ExperienceComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Positive
  private int capacity;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Positive
  private boolean retrieve;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<String> slots;
}
