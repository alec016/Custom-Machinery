package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class DimensionRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<@Pattern(regexp = Init.RL) String> filter;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean blacklist;
}
