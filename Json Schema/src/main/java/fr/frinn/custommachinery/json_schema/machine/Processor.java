package fr.frinn.custommachinery.json_schema.machine;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class Processor {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Pattern(regexp = "custommachinery:[machine|craft]")
  private String type;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private int amount;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int cooldown;
}
