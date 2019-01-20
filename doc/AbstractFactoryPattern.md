## Explanation
Real world example

> To create a kingdom we need objects with common theme. Elven kingdom needs an Elven king, Elven castle and Elven army whereas Orcish kingdom needs an Orcish king, Orcish castle and Orcish army. There is a dependency between the objects in the kingdom.

In plain words

> A factory of factories; a factory that groups the individual but related/dependent factories together without specifying their concrete classes.

Wikipedia says

> The abstract factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes

**Programmatic Example**

Translating the kingdom example above. First of all we have some interfaces and implementation for the objects in the kingdom

```java
public interface Castle {
  String getDescription();
}
public interface King {
  String getDescription();
}
public interface Army {
  String getDescription();
}

// Elven implementations ->
public class ElfCastle implements Castle {
  static final String DESCRIPTION = "This is the Elven castle!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
public class ElfKing implements King {
  static final String DESCRIPTION = "This is the Elven king!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
public class ElfArmy implements Army {
  static final String DESCRIPTION = "This is the Elven Army!";
  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}

// Orcish implementations similarly...

```

## First step
Make a factory for the elves and one the Orcs.

## Second step
Make an abstract factory for those 2 factories.
Now we have the abstraction and implementations for the kingdom factory
We have our abstract factory that lets us make family of related objects i.e. Elven kingdom factory creates Elven castle, king and army etc.

```java
KingdomFactory factory = new ElfKingdomFactory();
Kingdom elvenKingdom = factory.createKingdom();
```

## Third step
Now, we can design a factory for our different kingdom factories. In this example, we created FactoryMaker, responsible for returning an instance of either ElfKingdomFactory or OrcKingdomFactory.
The client can use FactoryMaker to create the desired concrete factory which, in turn, will produce different concrete objects (Army, King, Castle).
In this example, we also used an enum to parameterize which type of kingdom factory the client will ask for.

```java
public static class FactoryMaker {

  public enum KingdomType {
    ELF, ORC
  }

  public static KingdomFactory makeFactory(KingdomType type) {
    switch (type) {
      case ELF:
        return new ElfKingdomFactory();
      case ORC:
        return new OrcKingdomFactory();
      default:
        throw new IllegalArgumentException("KingdomType not supported.");
    }
  }
}

public static void main(String[] args) {
  App app = new App();

  LOGGER.info("Elf Kingdom");
  app.createKingdom(FactoryMaker.makeFactory(KingdomType.ELF));
  LOGGER.info(app.getArmy().getDescription());
  LOGGER.info(app.getCastle().getDescription());
  LOGGER.info(app.getKing().getDescription());

  LOGGER.info("Orc Kingdom");
  app.createKingdom(FactoryMaker.makeFactory(KingdomType.ORC));
  -- similar use of the orc factory
}
```


## Applicability
Use the Abstract Factory pattern when

* a system should be independent of how its products are created, composed and represented
* a system should be configured with one of multiple families of products
* a family of related product objects is designed to be used together, and you need to enforce this constraint
* you want to provide a class library of products, and you want to reveal just their interfaces, not their implementations
* the lifetime of the dependency is conceptually shorter than the lifetime of the consumer.
* you need a run-time value to construct a particular dependency
* you want to decide which product to call from a family at runtime.
* you need to supply one or more parameters only known at run-time before you can resolve a dependency.
