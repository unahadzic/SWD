package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.DoraTheExplorer.Dora;

public class CommandLeft implements Command{
    Dora dora;

    public CommandLeft(Dora dora) { this.dora = dora; }
    @Override
    public Dora execute() {
        if(dora.getX() > -240){
            dora.setPosition(dora.getX() - 60, dora.getY());
        }
        return dora;
    }
}
