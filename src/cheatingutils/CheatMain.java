package cheatingutils;

import arc.*;
import arc.util.*;
import mindustry.*;
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
				new UnlockCheat().show();
            });
        });
    }

    @Override
    public void loadContent(){
		return;
    }

}