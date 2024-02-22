package fr.frinn.custommachinery.json_schema.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class DumpElement extends Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private List<String> id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = "custommachinery:[item|fluid|source|mana]")
  private String component;
}
