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
  @JsonIgnore
  public static final Appearance DEFAULT = new Appearance();
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  private int hardness;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  private int resistance;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = TT)
  @JsonSubTypes({ @JsonSubTypes.Type(String.class) })
  private List<
    @Pattern(regexp = TT)
    String
  > tool_type;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = ML)
  private List<
    @Pattern(regexp = ML)
    String
  > mining_level;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean requires_tool;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes(
    @JsonSubTypes.Type(int[][].class)
  )
  private String shape;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes(
    @JsonSubTypes.Type(int[][].class)
  )
  private String shape_collision;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder idle = AppearanceBuilder.DEFAULT;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder running = AppearanceBuilder.DEFAULT;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder errored = AppearanceBuilder.DEFAULT;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder paused = AppearanceBuilder.DEFAULT;

  public void setIdle(AppearanceBuilder builder) {
    this.idle = builder;
  }

  public AppearanceBuilder getIdle() {
    return this.idle;
  }

  public void setRunning(AppearanceBuilder builder) {
    this.running = builder;
  }

  public AppearanceBuilder getRunning() {
    return this.running;
  }

  public void setErrored(AppearanceBuilder builder) {
    this.errored = builder;
  }

  public AppearanceBuilder getErrored() {
    return this.errored;
  }

  public void setPaused(AppearanceBuilder builder) {
    this.paused = builder;
  }

  public AppearanceBuilder getPaused() {
    return this.paused;
  }
}
