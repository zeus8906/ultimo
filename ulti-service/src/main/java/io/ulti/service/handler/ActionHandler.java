package io.ulti.service.handler;

import io.ulti.service.domain.Player;

public interface ActionHandler {

    public void process(Player player, Action action);
}
