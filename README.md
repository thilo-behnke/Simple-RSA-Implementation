# Simple-RSA-Implementation

Implementation of the RSA algorithm (https://simple.wikipedia.org/wiki/RSA_(algorithm)) in Java.
Architecture separates model from control and provides flexible interfaces for swapping algorithm implementations.

## Features:
- Encrypt and decrypt messages provided by user through input scanner
- JUnit test coverage

## Current issues:

- Encrypting and decrypting methods can cause crashes due to BigInteger implementation