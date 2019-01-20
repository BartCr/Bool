package designpatterns.abstractfactory.kingdom.elf;

import designpatterns.abstractfactory.kingdom.Army;

public class ElfArmy implements Army {
    static final String DESCRIPTION = "This is the Elven army!";

    @Override
    public String getDesciption() {
        return DESCRIPTION;
    }
}
