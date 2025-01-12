package frigidoven.betterspikes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class BetterSpikes implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "betterspikes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("BetterSpikes initialized. Yippee!");
    }

	@Override
	public void beforeGameStart() {
	}

	@Override
	public void afterGameStart() {
	}

	@Override
	public void onRecipesReady() {
	}

	@Override
	public void initNamespaces() {
	}
}
