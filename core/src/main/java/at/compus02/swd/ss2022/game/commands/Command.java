package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.DoraTheExplorer.Dora;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public interface Command {
    public GameObject execute();
}
