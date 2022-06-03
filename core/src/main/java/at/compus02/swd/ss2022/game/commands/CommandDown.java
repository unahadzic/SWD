package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.DoraTheExplorer.Dora;

public class CommandDown implements Command{
    Dora dora;
    public CommandDown(Dora dora) { this.dora = dora; }

    @Override
    public Dora execute() {
        if(dora.getY() > -240){
            dora.setPosition(dora.getX(), dora.getY() - 60);
        }
        return dora;
    }
}
