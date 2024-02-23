package fr.frinn.custommachinery.json_schema.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.recipe.requirements.Requirement;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class Recipe {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Pattern(regexp = Init.RL)
  private String machine;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Requirement> requirements;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Requirement> jei;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int priority;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int jeiPriority;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean hidden;
}
