package fr.frinn.custommachinery.json_schema.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class RedstoneComponent extends Component {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(16)
  private int powertopause;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(16)
  private int craftingpoweroutput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(16)
  private int idlepoweroutput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(16)
  private int erroredpoweroutput;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = "custommachinery:[energy|fluid|item]")
  private String compratorinputtype;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private String comparatorinputid;
}
