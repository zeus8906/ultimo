package io.ulti.service.domain;

public abstract class GameAction {

    protected Player underTheGun;
    protected boolean validAction;

    protected String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GameAction() {
        this.validAction = true;
    }

    public Player getPlayer() {
        return this.underTheGun;
    }

    public boolean isValidAction() {
        return this.validAction;
    }

    public void setValidAction(boolean validAction) {
        this.validAction = validAction;
    }
}
