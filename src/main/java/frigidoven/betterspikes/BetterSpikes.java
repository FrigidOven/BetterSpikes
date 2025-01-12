package frigidoven.betterspikes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BetterSpikes implements ModInitializer {
    public static final String MOD_ID = "betterspikes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("BetterSpikes initialized. Yippee!");
    }
}
