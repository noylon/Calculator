package sonar.calculator.mod.integration.minetweaker;

import com.google.common.collect.Lists;

import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import sonar.calculator.mod.common.recipes.machines.StoneSeparatorRecipes;
import sonar.core.integration.minetweaker.SonarAddRecipe;
import sonar.core.integration.minetweaker.SonarRemoveRecipe;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.calculator.stoneSeparator")
public class StoneSeparatorHandler {

	@ZenMethod
	public static void addRecipe(IIngredient input, IItemStack output1, IItemStack output2) {
		MineTweakerAPI.apply(new SonarAddRecipe(StoneSeparatorRecipes.instance(), Lists.newArrayList(input), Lists.newArrayList(MineTweakerMC.getItemStack(output1), MineTweakerMC.getItemStack(output2))));
	}

	@ZenMethod
	public static void removeRecipe(IIngredient input) {
		MineTweakerAPI.apply(new SonarRemoveRecipe(StoneSeparatorRecipes.instance(), Lists.newArrayList(input), false));
	}
}
