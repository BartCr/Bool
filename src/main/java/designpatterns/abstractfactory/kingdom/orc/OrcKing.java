package designpatterns.abstractfactory.kingdom.orc;

import designpatterns.abstractfactory.kingdom.King;

public class OrcKing implements King {
    private static final String DESCRIPTION = "This is the Orcish king!";

    @Override
    public String getDesciption() {
        return DESCRIPTION;
    }
}
