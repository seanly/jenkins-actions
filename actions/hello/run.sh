#!/bin/bash

# Hello Tool - A simple greeting tool
# Usage: INPUT_NAME=value ./run.sh

# Set default name if none provided
NAME=${INPUT_NAME:-"World"}

# Display greeting
echo "Hello, $NAME!"

# Optional: Add timestamp
echo "Greeted at: $(date)"

# Exit with success
exit 0 