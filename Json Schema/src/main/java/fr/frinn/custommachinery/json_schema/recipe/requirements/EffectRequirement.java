package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class EffectRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Pattern(regexp = Init.RL)
  private String effect;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private int time;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private int radius;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int level;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<@Pattern(regexp = Init.RL) String> filter;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean finish;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double delay;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double chance;
}
