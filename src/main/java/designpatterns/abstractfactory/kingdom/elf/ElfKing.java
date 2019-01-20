package designpatterns.abstractfactory.kingdom.elf;

import designpatterns.abstractfactory.kingdom.King;

public class ElfKing implements King {
    private static final String DESCRIPTION = "This is the Elven king!";

    @Override
    public String getDesciption() {
        return DESCRIPTION;
    }
}
