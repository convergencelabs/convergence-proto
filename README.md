# Convergence Protocol Buffer Messages

This is the central repository for the messages passed between Convergence clients and a Convergence Server.  The [protocol buffer[(https://developers.google.com/protocol-buffers)] messages themselves are defined in `src/main/protobuf`.

Changes to the messages themselves should happen in this repository, which is a dependency of all the Convergence clients and the Server.  All the serialization and deserialization logic is provided by Protobuf's [various language implementations](https://developers.google.com/protocol-buffers/docs/reference/overview) in a content-agnostic manner.

## Building

`npm run dist` builds a distribution package that can be published to npm.
