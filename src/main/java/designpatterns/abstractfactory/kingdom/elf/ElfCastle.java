package designpatterns.abstractfactory.kingdom.elf;

import designpatterns.abstractfactory.kingdom.Castle;

public class ElfCastle implements Castle{
    private static final String DESCRIPTION = "This is the Elven castle!";

    @Override
    public String getDesciption() {
        return DESCRIPTION;
    }
}
