Old Mixer Tales [![Status Zero][status-zero]][andivionian-status-classifier]
===============

These're stories of one old man.

⚠ WARNING ⚠
------------

This repository **contains** spoilers. Do not read any of the following
materials if you want to avoid reading them.

Status
------

Will be implemented on [INSTEAD][instead] platform.

Quick start guide
-----------------

### Native INSTEAD client

1. [Get INSTEAD][download-instead].
2. Put this repo in `games` (`~/.instead/games/` on Linux,
   `path_to_instead\games` on Windows.)
3. Start interpreter (`instead` on Linux, `sdl-instead` on Windows.)
4. Choose “Select game” item from the menu (the button is in the lower right
   corner of the screen).
5. Choose “Сказки старого Миксера” item.
6. Have a nice game!

*Note to developers*: there doesn't seem to be a way to hot-reload the game, so
whenever you change the code, you have to choose “Restart game” menu item and
start from the very beginning.

Alternately you could start INSTEAD with preloaded game, for example:

```console
$ sdl-instead path/to/old-mixer-tales
```

### JavaScript INSTEAD Client

The game can also be run inside a web client provided by the [instead-js]
project. To do so, follow the instructions in the instead-js repository. Here's
an example command sequence:

```console
$ git clone git@github.com:instead-hub/instead-js.git
$ cd instead-js
$ git submodule init
$ git submodule update
$ npm install
$ npm run build

$ cp -r /path/to/old-rexim-tales ./build/games/old-rexim-tales
$ cd build
$ node list_games.js
```

After that, you could either publish the `build` directory to any web server or
start a local server with `npm start`.

Materials
---------

- [Epigraph][epigraph]
- [Scenic guide to universe][scenic-guide-to-universe]

Inactive:

- [Apocalypse][apocalypse]


License [![license-cc-by-4.0][]][cc-by-4.0]
-------

This work is licensed under a [Creative Commons Attribution 4.0 International
License][cc-by-4.0].

[apocalypse]: story/apocalypse.md
[epigraph]: story/epigraph.md
[scenic-guide-to-universe]: story/scenic-guide-to-universe.md

[andivionian-status-classifier]: https://github.com/ForNeVeR/andivionian-status-classifier#status-zero-
[cc-by-4.0]: http://creativecommons.org/licenses/by/4.0/
[instead]: https://instead.syscall.ru/
[download-instead]: https://instead.syscall.ru/ru/download/

[instead-js]: https://github.com/instead-hub/instead-js/
[license-cc-by-4.0]: https://i.creativecommons.org/l/by/4.0/80x15.png
[status-zero]: https://img.shields.io/badge/status-zero-lightgrey.svg
