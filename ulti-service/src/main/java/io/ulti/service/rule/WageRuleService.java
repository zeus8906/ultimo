package io.ulti.service.rule;

import javax.annotation.Resource;

import org.drools.runtime.StatefulKnowledgeSession;

import io.ulti.service.domain.Game;
import io.ulti.service.domain.WageAction;

public class WageRuleService {

    private static final int MAX_NO_OF_RULE_ACTIVATIONS = 1;

    @Resource(name = "wagingKSession")
    private StatefulKnowledgeSession knowledgeSession;

    @Resource
    private Game game;

    public boolean isValidWage(WageAction action) {
        boolean valid = true;
        knowledgeSession.insert(game);
        knowledgeSession.insert(action);
        knowledgeSession.insert(valid);
        knowledgeSession.fireAllRules(MAX_NO_OF_RULE_ACTIVATIONS);
        return valid;
    }
}
