package io.ulti.service.domain;

import java.util.Collection;

public class WageAction extends GameAction {

    private TargetSet target;

    public WageAction(Player underTheGun, Collection<GameTarget> target, boolean isRed) {
        this.underTheGun = underTheGun;
        this.target = new TargetSet(target, isRed);
    }

    public TargetSet getTarget() {
        return target;
    }

}
