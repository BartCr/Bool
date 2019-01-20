package designpatterns.abstractfactory.kingdom.orc;

import designpatterns.abstractfactory.kingdom.Castle;

public class OrcCastle implements Castle {
    private static final String DESCRIPTION = "This is the Orcish castle!";

    @Override
    public String getDesciption() {
        return DESCRIPTION;
    }
}
