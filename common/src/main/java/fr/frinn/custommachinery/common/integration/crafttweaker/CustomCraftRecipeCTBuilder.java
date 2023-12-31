package fr.frinn.custommachinery.common.integration.crafttweaker;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.CraftTweakerConstants;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import fr.frinn.custommachinery.api.requirement.IChanceableRequirement;
import fr.frinn.custommachinery.api.requirement.IDelayedRequirement;
import fr.frinn.custommachinery.api.requirement.IRequirement;
import fr.frinn.custommachinery.common.crafting.craft.CustomCraftRecipe;
import fr.frinn.custommachinery.common.crafting.craft.CustomCraftRecipeBuilder;
import fr.frinn.custommachinery.common.integration.crafttweaker.requirements.*;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType.Method;
import org.openzen.zencode.java.ZenCodeType.Name;
import org.openzen.zencode.java.ZenCodeType.OptionalString;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@ZenRegister
@Name(CTConstants.RECIPE_BUILDER_CRAFT)
public class CustomCraftRecipeCTBuilder implements EnergyRequirementCT<CustomCraftRecipeCTBuilder>, EnergyPerTickRequirementCT<CustomCraftRecipeCTBuilder>,
        FluidRequirementCT<CustomCraftRecipeCTBuilder>, FluidPerTickRequirementCT<CustomCraftRecipeCTBuilder>, ItemRequirementCT<CustomCraftRecipeCTBuilder>,
        ItemTransformRequirementCT<CustomCraftRecipeCTBuilder>, DurabilityRequirementCT<CustomCraftRecipeCTBuilder>, TimeRequirementCT<CustomCraftRecipeCTBuilder>,
        PositionRequirementCT<CustomCraftRecipeCTBuilder>, BiomeRequirementCT<CustomCraftRecipeCTBuilder>, DimensionRequirementCT<CustomCraftRecipeCTBuilder>,
        FuelRequirementCT<CustomCraftRecipeCTBuilder>, CommandRequirementCT<CustomCraftRecipeCTBuilder>, EffectRequirementCT<CustomCraftRecipeCTBuilder>,
        WeatherRequirementCT<CustomCraftRecipeCTBuilder>, RedstoneRequirementCT<CustomCraftRecipeCTBuilder>, EntityRequirementCT<CustomCraftRecipeCTBuilder>,
        LightRequirementCT<CustomCraftRecipeCTBuilder>, BlockRequirementCT<CustomCraftRecipeCTBuilder>, StructureRequirementCT<CustomCraftRecipeCTBuilder>,
        LootTableRequirementCT<CustomCraftRecipeCTBuilder>, DropRequirementCT<CustomCraftRecipeCTBuilder>, FunctionRequirementCT<CustomCraftRecipeCTBuilder>,
        ButtonRequirementCT<CustomCraftRecipeCTBuilder>, SkyRequirementCT<CustomCraftRecipeCTBuilder>, ItemFilterRequirementCT<CustomCraftRecipeCTBuilder>,
        ExperienceRequirementCT<CustomCraftRecipeCTBuilder>, ExperiencePerTickRequirementCT<CustomCraftRecipeCTBuilder> {

    public static final Map<ResourceLocation, Integer> IDS = new HashMap<>();
    private final CustomCraftRecipeBuilder builder;
    private IRequirement<?> lastRequirement;
    private boolean jei = false;

    public CustomCraftRecipeCTBuilder(CustomCraftRecipeBuilder builder) {
        this.builder = builder;
    }

    @Method
    public static CustomCraftRecipeCTBuilder create(String machine, IItemStack output) {
        try {
            return new CustomCraftRecipeCTBuilder(new CustomCraftRecipeBuilder(new ResourceLocation(machine), output.getImmutableInternal()));
        } catch (ResourceLocationException e) {
            throw new IllegalArgumentException("Invalid Machine name: " + machine + "\n" + e.getMessage());
        }
    }

    @Method
    public void build(@OptionalString String name) {
        final ResourceLocation recipeID;
        try {
            if(!name.isEmpty()) {
                if(name.contains(":"))
                    recipeID = new ResourceLocation(name);
                else
                    recipeID = new ResourceLocation(CraftTweakerConstants.MOD_ID, name);
            }
            else {
                int uniqueID = IDS.computeIfAbsent(this.builder.getMachine(), m -> 0);
                IDS.put(this.builder.getMachine(), uniqueID + 1);
                recipeID = new ResourceLocation(CraftTweakerConstants.MOD_ID, "custom_craft/" + this.builder.getMachine().getNamespace() + "/" + this.builder.getMachine().getPath() + "/" + uniqueID);
            }
        } catch (ResourceLocationException e) {
            throw new IllegalArgumentException("Invalid Recipe name: " + name + "\n" + e.getMessage());
        }
        CustomCraftRecipe recipe = this.builder.build(recipeID);
        ActionAddRecipe<CustomCraftRecipe> action =  new ActionAddRecipe<>(CustomCraftRecipeCTManager.INSTANCE, recipe);
        CraftTweakerAPI.apply(action);
    }

    @Override
    public CustomCraftRecipeCTBuilder addRequirement(IRequirement<?> requirement) {
        this.lastRequirement = requirement;
        if(!this.jei)
            this.builder.withRequirement(requirement);
        else
            this.builder.withJeiRequirement(requirement);
        return this;
    }

    @Override
    public CustomCraftRecipeCTBuilder error(String error, Object... args) {
        CraftTweakerAPI.LOGGER.error(error, args);
        return this;
    }

    /** CHANCE **/

    @Method
    public CustomCraftRecipeCTBuilder chance(double chance) {
        if(this.lastRequirement != null && this.lastRequirement instanceof IChanceableRequirement)
            ((IChanceableRequirement<?>)this.lastRequirement).setChance(chance);
        else
            CraftTweakerAPI.LOGGER.error("Can't set chance for requirement: " + this.lastRequirement);
        return this;
    }

    /** HIDE **/

    @Method
    public CustomCraftRecipeCTBuilder hide() {
        this.builder.hide();
        return this;
    }

    /** DELAY **/

    @Method
    public CustomCraftRecipeCTBuilder delay(double delay) {
        if(this.lastRequirement != null && this.lastRequirement instanceof IDelayedRequirement<?>)
            ((IDelayedRequirement<?>)this.lastRequirement).setDelay(delay);
        else
            CraftTweakerAPI.LOGGER.error("Can't put delay for requirement: " + this.lastRequirement);
        return this;
    }

    /** JEI **/

    @Method
    public CustomCraftRecipeCTBuilder jei() {
        this.jei = true;
        return this;
    }

    /** PRIORITY **/

    @Method
    public CustomCraftRecipeCTBuilder priority(int priority) {
        if(!this.jei)
            this.builder.withPriority(priority);
        else
            this.builder.withJeiPriority(priority);
        return this;
    }

    /** INFO **/

    @Method
    public CustomCraftRecipeCTBuilder info(Consumer<DisplayInfoTemplateCT> consumer) {
        if(this.lastRequirement != null) {
            DisplayInfoTemplateCT template = new DisplayInfoTemplateCT();
            consumer.accept(template);
            this.lastRequirement.setDisplayInfoTemplate(template);
        }
        else
            CraftTweakerAPI.LOGGER.error("Can't put info for null requirement");
        return this;
    }
}
