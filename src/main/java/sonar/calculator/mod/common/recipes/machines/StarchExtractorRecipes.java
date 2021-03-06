package sonar.calculator.mod.common.recipes.machines;

import net.minecraft.init.Items;
import sonar.calculator.mod.Calculator;
import sonar.core.helpers.ValueHelper;

public class StarchExtractorRecipes extends ValueHelper {
	
	private static final StarchExtractorRecipes recipes = new StarchExtractorRecipes();

	public static final ValueHelper instance() {
		return recipes;
	}	
	@Override
	public void addRecipes() {

		addRecipe(Items.APPLE, 2000);
		addRecipe("cropPotato", 1000);
		addRecipe("cropCarrot", 1000);
		addRecipe("cropWheat", 800);
		addRecipe(Calculator.broccoli, 1000);
		addRecipe(Calculator.broccoliSeeds, 800);
		addRecipe(Calculator.fiddledewFruit, 5000);
		addRecipe(Calculator.prunaeSeeds, 1500);
		addRecipe(Items.WHEAT_SEEDS, 600);
		addRecipe(Items.MELON, 1000);
		addRecipe(Items.MELON_SEEDS, 800);
		addRecipe(Items.REEDS, 1000);
		addRecipe("treeSapling", 1000);
		addRecipe("calculatorLeaves", 2500);
		addRecipe("treeLeaves", 200);
		
	}
	@Override
	public String getRecipeID() {
		return "Starch Values";
	}

}
