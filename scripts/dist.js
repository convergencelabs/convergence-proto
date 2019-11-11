const pbjs = require("protobufjs/cli/pbjs");
const pbts = require("protobufjs/cli/pbts");
const fs = require('fs-extra');
const bump = require('bump-regex');

mkDist();
packageJson();
createProtoJson();
compileProtoJavaScript();
compileProtoTypeDefs();

function mkDist() {
  fs.ensureDirSync("npm-dist");
}

function packageJson() {
  const contents = String(fs.readFileSync('./package.json'));
  const pkgJson = JSON.parse(contents);
  if (pkgJson.version.endsWith("SNAPSHOT")) {
    const opts = {
      version: pkgJson.version + '.' + new Date().getTime(),
      str: contents
    };

    bump(opts, function(err, res) {
      fs.writeFileSync('npm-dist/package.json', res.str);
    });
  } else {
    fs.copySync('./package.json', 'npm-dist/package.json');
  }
}


function createProtoJson() {
  pbjs.main([
    "--target", "json",
    "-o", "npm-dist/convergence-proto.json",
    "-p", "src/main/protobuf",
    "./src/main/protobuf/convergence-protocol.proto"], function (err, output) {
    if (err) {
      throw err;
    }
  });
}

function compileProtoJavaScript() {
  pbjs.main([
    "--target", "static",
    "-o", "npm-dist/convergence-proto.js",
    "-p", "src/main/protobuf",
    "src/main/protobuf/convergence-protocol.proto"], function (err, output) {
    if (err) {
      throw err;
    }
  });
}

function compileProtoTypeDefs() {
  pbts.main([
    "-o", "npm-dist/convergence-proto.d.ts",
    "-p", "src/main/protobuf",
    "npm-dist/convergence-proto.js"], function (err, output) {
    if (err) {
      throw err;
    }
  });
}
