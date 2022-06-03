package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.DoraTheExplorer.Dora;

public class CommandRight implements Command{
    Dora dora;
    public CommandRight(Dora dora) { this.dora = dora; }
    @Override
    public Dora execute() {
        if(dora.getX() < 180){
            dora.setPosition(dora.getX() + 60, dora.getY());
        }
        return dora;
    }
}
