S592 program
============

This is a simple program to prepare images containing texts.

Usage:

```console
$ sbt 'run examples/test.conf' # Will prepare examples/test.png
```

Configuration format
--------------------

Every input file will be converted to an image. The `conf` file should be in
[HOCON][hocon] format. Here's a file example:

```
width = 800
height = 600
texts = [{
    coords = [0, 100]
    width = 800
    text = "Hello world"
}]

```

### Root level

Root level have the following properties:

- `height`: height of the image.
- `texts`: an array of `TextInfo`, see below.
- `width`: width of the image.

### `TextInfo`

`TextInfo` should be an object with the following properties:

- `coords`: an array of exactly two integers (`x` and `y`).
- `text`: the text string.
- `width`: (optional) text width. If defined, the text will be centered.

[hocon]: https://github.com/typesafehub/config#using-hocon-the-json-superset
