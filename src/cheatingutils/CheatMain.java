package cheatingutils;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

import cheatingutils.cheats.*;

public class CheatMain extends Mod{

    public CheatMain (){
        Log.info("CheatUtils Loaded");

        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                new ModCheatMenu((table) -> {
                    table.button("Cheat Menu", () -> {
                        BaseDialog dialog = new BaseDialog("Cheat Menu");
                        dialog.cont.table((t) -> {
                            t.defaults().size(280.0F, 60.0F);
                           //if (!Vars.net.client()) t.button("Rules Edit", RuleCheat::openRulesEditDialog).growX().row();
                            t.button("Items Hack", CheatMain::openModCheatItemsMenu).growX().row();
                            t.button("Research Hack", CheatMain::openUnlockContentDialog).growX().row();
                        });
                        dialog.addCloseListener();
                        dialog.addCloseButton();
                        dialog.show();
        
                    }).size(280.0f / 2f, 60.0F);
                    table.visibility = () -> true;
                });
            });
        });
    }
    public static void openUnlockContentDialog() {
        new UnlockCheat().show();
    }
    public static void openModCheatItemsMenu() {
        if (Vars.net.client()) return;
        new ItemCheat().show(() -> {
        }, () -> {
        });
    }
    @Override
    public void loadContent(){
		return;
    }

}