package designpatterns.abstractfactory.kingdom;

import designpatterns.abstractfactory.kingdom.elf.ElfArmy;
import designpatterns.abstractfactory.kingdom.elf.ElfCastle;
import designpatterns.abstractfactory.kingdom.elf.ElfKing;
import designpatterns.abstractfactory.kingdom.orc.OrcArmy;
import designpatterns.abstractfactory.kingdom.orc.OrcCastle;
import designpatterns.abstractfactory.kingdom.orc.OrcKing;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KingdomTest {

    private Kingdom kingdom;

    @Test
    public void orcKingdom() throws Exception {
        kingdom = new Kingdom(new OrcKing(), new OrcCastle(), new OrcArmy());

        assertThat(kingdom.getArmy().getDesciption()).isEqualTo("This is the Orcish army!");
        assertThat(kingdom.getKing().getDesciption()).isEqualTo("This is the Orcish king!");
        assertThat(kingdom.getCastle().getDesciption()).isEqualTo("This is the Orcish castle!");
    }

    @Test
    public void elfKingdom() throws Exception {
        kingdom = new Kingdom(new ElfKing(), new ElfCastle(), new ElfArmy());

        assertThat(kingdom.getArmy().getDesciption()).isEqualTo("This is the Elven army!");
        assertThat(kingdom.getKing().getDesciption()).isEqualTo("This is the Elven king!");
        assertThat(kingdom.getCastle().getDesciption()).isEqualTo("This is the Elven castle!");
    }

    @Test
    public void mixedKingdom_sayWhat() throws Exception {
        kingdom = new Kingdom(new OrcKing(), new ElfCastle(), new ElfArmy());

        assertThat(kingdom.getArmy().getDesciption()).isEqualTo("This is the Elven army!");
        assertThat(kingdom.getKing().getDesciption()).isEqualTo("This is the Orcish king!");
        assertThat(kingdom.getCastle().getDesciption()).isEqualTo("This is the Elven castle!");
    }
}