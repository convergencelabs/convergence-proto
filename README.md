<div align="center">
  <img  alt="Convergence Logo" height="80" src="assets/convergence-logo.png" >
</div>

# Convergence Protocol
![Build Status](https://travis-ci.org/convergencelabs/convergence-proto.svg?branch=master)

This repository defines the Convergence client-server, realtime, WebSocket protocol.  The protocol is specified using [Google Protocol Buffers](https://developers.google.com/protocol-buffers) version 3 messages. The protocol itself can be found in the [src/main/protobuf](src/main/protobuf) directory. 

Convergence supplies a JavaScript client with the server implemented in Scala. Thus this project builds JavaScript and Scala bindings.  The JavaScript bindings are provided by [protobuf.js](https://github.com/protobufjs/protobuf.js). The Scala bindings are provided by [ScalaPB](https://scalapb.github.io/).

# Dependencies
* [NodeJS](https://nodejs.org/) >= 10
* [protobuf.js](https://github.com/protobufjs/protobuf.js) = 6.8.8
* [sbt](https://www.scala-sbt.org/) >= 1.3
* [ScalaPB](https://scalapb.github.io/) = 0.9.4

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
There are different build commands for each language binding. They are as follows:

* **JavaScript**: `npm run dist`
* **Scala**: `sbt compile`

# Protocol
The Convergence client-server protocol is intended to be sent over a [WebSocket](https://en.wikipedia.org/wiki/WebSocket) connection between a Convergence client and the Convergence Server. Each message sent between the client and server is an instance of the [ConvergenceMessage](src/main/protobuf/convergenceMessage.proto) protocol buffer message. The rough structure of the message is as follows:

```proto
message ConvergenceMessage {
  google.protobuf.Int32Value requestId = 1;
  google.protobuf.Int32Value responseId = 2;

  oneof body {
    // messages
  }
}
``` 
The body field will contain a specific message sent or received. WebSockets are an asynchronous, bi-directional streaming communication channel. However, Convergence has several request / response style exchanges. The ConvergenceMessage structure implements a correlation id strategy to enable request / response behavior over WebSockets.

The best way to understand the protocol is to simply view the `.proto` files in the [src/main/protobuf](src/main/protobuf) directory.

## License
The Convergence Protocol is licensed under the [Apache 2.0](LICENSE) license. Refer to the [LICENSE.txt](LICENSE) for the specific terms and conditions of the license.

The Convergence Protocol is also available under a Commercial License. If you are interested in a non-open source license please contact us at [Convergence Labs](https://convergencelabs.com).
