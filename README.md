# Convergence Protocol
This repository defines the Convergence client-server, realtime, WebSocket protocol.  The protocol is specified using [Google Protocol Buffers](https://developers.google.com/protocol-buffers) version 3 messages. The protocol itself can be found in the [src/main/protobuf](src/main/protobuf) directory. 

Convergence supplies a JavaScript client with the server implemented in Scala. Thus this project builds JavaScript and Scala bindings.  The JavaScript bindings are provided by [protobuf.js](https://github.com/protobufjs/protobuf.js). The Scala bindings are provided by [ScalaPB](https://scalapb.github.io/).

# Dependencies
* [NodeJS](https://nodejs.org/) >= 10
* [sbt](https://www.scala-sbt.org/) >= 1.3

# Installation

## JavaScript
To use the JavaScript protocol bindings use the following command:
```shell
npm i -D @convergence/convergence-proto
```

## Scala
To use the Scala protocol bindings add the following dependency:

```shell
libraryDependencies += "com.convergencelabs" %% "convergence-proto-scala" % "1.0.0"
```

# Building
To build the JavaScript bindings use the following command:

```
npm run dist
```

To build the Scala bindings use the following command:
```$xslt
sbt compile
```
