# CLAUDE.md

## Project overview

A deck of cards built on `ArrayList`s, plus a console simulation of the card game War between two computer players. It was written in December 2016 as a final project and is kept as an early program. There is no input; each run of `War` shuffles, deals 26 cards to each player, plays to the end and prints the number of rounds, the number of wars and the winner.

## Technology stack

- Java, six plain source files in the default package under `src/`, using only `java.util`.
- No build tool (no Maven, Gradle or Ant file), no dependencies, no README. CI (`.github/workflows/test.yml`, job `test`) runs on every PR and push to the default branch.
- Verified to compile and run with `javac`/`java` 17.

## Build and run commands

```bash
# Compile into a scratch directory (keeps .class files out of the repo)
javac -d out src/*.java

# Play a game of War (the real entry point)
java -cp out War

# Driver: an earlier entry point that deals 7 cards each and prints nothing
java -cp out Driver
```

## Test commands

There are no unit tests. CI (`.github/workflows/test.yml`, job `test`) runs on every PR and push to the default branch: it compiles on Temurin 17, plays `War` 25 times (each must exit 0 within 30s and print `Rounds:`, `Wars:` and a winner line) and runs `Driver`. To check a change locally, compile with `javac -d out src/*.java` and run `java -cp out War` several times (the game is random), confirming that it terminates and prints `Rounds:`, `Wars:` and a winner line.

## Repository layout

```
src/Card.java                 A card: num (1-13), suite, title (e.g. "Ace of Spades")
src/DeckOfCards.java          The 52-card originalDeck: build, print, shuffle, deal to / take back from a player
src/playerDeck.java           A player's hand (myDeck), with print and shuffle
src/War.java                  The War game and its main method
src/Driver.java               Earlier test driver with a main method
src/ComparableInterface.java  Empty marker interface that Card implements
```

## Coding conventions

- Tabs for indentation; opening braces on the same line.
- Default package, no access modifiers on most fields; game state in `War` is held in static fields (`rounds`, `wars`, `b`, `run`).
- Class names are as originally written, including the lower-case `playerDeck` and the field name `suite` (for suit). Renaming them is a refactor touching every file, not a drive-by change.

## Do / Don't

**Do:**
- Preserve the game's behaviour and output unless a change is deliberately about the rules; this is a preserved early program.
- Keep it compiling with plain `javac src/*.java`; if a build tool or tests are added, document the new commands here.
- Keep in mind that `DeckOfCards.removeCardFromMyDeck` returns a player's card to `originalDeck` and `addCardToMyDeck` deals from its front, so card transfers between players go through the shared deck.

**Don't:**
- Don't commit compiled `.class` files or IDE metadata (Eclipse files were deliberately deleted from history).
- Don't move the sources into a package or a different directory without updating every command above.
