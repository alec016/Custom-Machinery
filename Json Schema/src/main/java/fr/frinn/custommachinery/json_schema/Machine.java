package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import fr.frinn.custommachinery.json_schema.components.ChunkLoadComponent;
import fr.frinn.custommachinery.json_schema.components.Component;
import fr.frinn.custommachinery.json_schema.components.EnergyComponent;
import fr.frinn.custommachinery.json_schema.elements.Element;
import jakarta.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Machine {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String name;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Appearance appearance;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Tooltip> tooltips;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Element> gui;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Element> jei;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonFormat(
    shape = JsonFormat.Shape.ARRAY
  )
  private List<Component> components;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Processor processor;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<
    @Pattern(regexp = Init.RL)
    String
  > catalysts;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setAppearance(Appearance appearance) {
    this.appearance = appearance;
  }

  public Appearance getAppearance() {
    return this.appearance;
  }

  public void setTooltips(List<Tooltip> tooltips) {
    this.tooltips = tooltips;
  }

  public void addTooltips(Tooltip... tooltips) {
    this.tooltips.addAll(List.of(tooltips));
  }

  public List<Tooltip> getTooltips() {
    return this.tooltips;
  }

  public void setGui(List<Element> guiElements) {
    this.gui = guiElements;
  }

  @SafeVarargs
  public final <T extends Element> void addElementsToGui(T... elements) {
    this.gui.addAll(List.of(elements));
  }

  public List<Element> getGui() {
    return this.gui;
  }

  public void setJei(List<Element> jeiElements) {
    this.jei = jeiElements;
  }

  @SafeVarargs
  public final <T extends Element> void addJeiElements(T... elements) {
    this.jei.addAll(List.of(elements));
  }

  public List<Element> getJei() {
    return this.jei;
  }

  public void setComponents(List<Component> components) {
    this.components = components;
  }

  @SafeVarargs
  public final <T extends Component> void addComponents(T... components) {
    this.components.addAll(List.of(components));
  }

  public List<Component> getComponents() {
    return this.components;
  }

  public void setProcessor(Processor processor) {
    this.processor = processor;
  }

  public Processor getProcessor() {
    return this.processor;
  }

  public void setCatalysts(List<String> catalysts) {
    this.catalysts = catalysts;
  }

  public void addCatalysts(String... catalysts) {
    this.catalysts.addAll(List.of(catalysts));
  }

  public List<String> getCatalysts() {
    return this.catalysts;
  }
}