# Hello Tool

A simple greeting tool that displays a personalized hello message.

## Usage

```bash
# Basic usage (greets "World")
./run.sh

# Greet a specific person
./run.sh "John"

# Greet with a name containing spaces
./run.sh "John Doe"
```

## Features

- Displays a personalized greeting message
- Shows timestamp of when the greeting was made
- Accepts optional name parameter
- Defaults to "World" if no name is provided

## Requirements

- Bash shell
- Unix-like operating system (Linux, macOS, etc.)

## Examples

```bash
$ ./run.sh
Hello, World!
Greeted at: Mon Dec 25 07:25:55 PST 2023

$ ./run.sh Alice
Hello, Alice!
Greeted at: Mon Dec 25 07:25:55 PST 2023
``` 