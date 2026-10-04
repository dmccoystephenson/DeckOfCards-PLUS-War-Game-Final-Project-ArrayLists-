# DeckOfCards PLUS War Game

[![Play in your browser](https://img.shields.io/badge/Play-in%20your%20browser-2ea44f)](https://danielstephenson.dev/play/war)

For AP Computer Science class at RMHS (December 2016). It uses ArrayLists to build a deck of cards, shuffle it and deal half the deck to each of two players, who then play War until one of them has every card (ties go to a "war", handled with recursion). The program plays by itself and prints the number of rounds and wars and the winner.

It is part of the "First Programs" collection on [danielstephenson.dev/play](https://danielstephenson.dev/play).

## Running it
```
javac -d out src/*.java
java -cp out War
```

## Play in your browser
The game can be played at <https://war.play.danielstephenson.dev>. The classes in `src/` run unchanged in the browser with [CheerpJ](https://cheerpj.com) (Leaning Technologies), loaded from CheerpJ's official CDN under its Community License.

The browser build lives in `web/`:

- `web/java/BrowserMain.java` is a browser-only entry point. It sends `System.out` to the page, resets `War`'s static counters before each game, and waits for the page's "Deal another game" button between games.
- `web/build.sh` compiles `src/` and `BrowserMain` for Java 8 into `build/web/war.jar` and copies `web/index.html` next to it.
- Pushes to `master` deploy `build/web` to [arcade](https://github.com/Stephenson-Software/arcade) (`.github/workflows/browser.yml`).
