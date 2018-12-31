import {src, dest, series} from 'gulp';
import bump from 'gulp-bump';

import del from 'del';
import fs from 'fs';

import pbjs from "protobufjs/cli/pbjs";
import pbts from "protobufjs/cli/pbts";

const packageJson = () => {
  const pkgJson = JSON.parse(fs.readFileSync('./package.json'));
  if (pkgJson.version.endsWith("SNAPSHOT")) {
    return src('./package.json')
      .pipe(bump({version: pkgJson.version + '.' + new Date().getTime()}))
      .pipe(dest('npm-dist/'));
  }
};

const createProtoJson = (cb) => {
  pbjs.main([
    "--target", "json",
    "-o", "npm-dist/convergence-proto.json",
    "./src/main/protobuf/message.proto"], function (err, output) {
    if (err) {
      throw err;
    }

    cb();
  });
};

const compileProtoJavaScript = (cb) => {
  pbjs.main([
    "--target", "static",
    "-o", "npm-dist/convergence-proto.js",
    "src/main/protobuf/message.proto"], function (err, output) {
    if (err) {
      throw err;
    }

    cb();
  });
};

const compileProtoTypeDefs = (cb) => {
  pbts.main([
    "-o", "npm-dist/convergence-proto.d.ts",
    "npm-dist/convergence-proto.js"], function (err, output) {
    if (err) {
      throw err;
    }

    cb();
  });
};

const dist = series(packageJson, createProtoJson, compileProtoJavaScript, compileProtoTypeDefs);

const clean = () => del(["dist"]);

export {
  clean,
  dist
};
