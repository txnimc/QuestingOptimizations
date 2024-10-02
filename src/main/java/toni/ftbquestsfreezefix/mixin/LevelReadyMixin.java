package toni.ftbquestsfreezefix.mixin;

import dev.ftb.mods.ftbquests.client.ClientQuestFile;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import toni.ftbquestsfreezefix.FTBQuestsFreezeFix;

@Mixin(ReceivingLevelScreen.class)
public class LevelReadyMixin {

    @Inject(method = "onClose", at = @At(value = "HEAD"))
    private void onClose(CallbackInfo ci) {
        if (FTBQuestsFreezeFix.hasInitialized)
            return;

        FTBQuestsFreezeFix.hasInitialized = true;
        var gui = ClientQuestFile.openGui();
        if (gui != null)
            gui.closeGui(true);
        else
            FTBQuestsFreezeFix.LOGGER.error("[" + FTBQuestsFreezeFix.MODNAME + "] ERROR! Could not get FTB Quests GUI!");
    }
}
