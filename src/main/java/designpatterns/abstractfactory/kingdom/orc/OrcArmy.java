package designpatterns.abstractfactory.kingdom.orc;

import designpatterns.abstractfactory.kingdom.Army;

public class OrcArmy implements Army {
    private static final String DESCRIPTION = "This is the Orcish army!";

    @Override
    public String getDesciption() {
        return DESCRIPTION;
    }
}
