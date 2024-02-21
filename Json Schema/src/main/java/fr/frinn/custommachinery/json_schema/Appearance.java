package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.appearance.AppearanceBuilder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class Appearance extends AppearanceBuilder {
  private static final String TT = "minecraft:mineable/[shovel|pickaxe|axe|hoe]";
  private static final String ML = "[minecraft:needs_[stone|iron|diamond]|forge:needs_netherite]_tool";
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  private int hardness;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  private int resistance;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<
    @Pattern(regexp = TT)
    String
  > tool_type;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = ML)
  private String mining_level;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean requires_tool;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes(@JsonSubTypes.Type(int[][].class))
  private String shape;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes(@JsonSubTypes.Type(int[][].class))
  private String shape_collision;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String ambient_sound;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  @JsonSubTypes({
    @JsonSubTypes.Type(InteractionSound.class),
    @JsonSubTypes.Type(String.class)
  })
  private String interaction_sound;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder idle;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder running;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder errored;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder paused;

  private static class InteractionSound {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @Pattern(regexp = Init.RL)
    private String place;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @Pattern(regexp = Init.RL)
    private String breeak;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @Pattern(regexp = Init.RL)
    private String step;
  }
}
