const gulp = require('gulp');

const del = require('del');
const gulpprotobuf = require('gulp-protobufjs');
const fs = require('fs');

const packageJson = JSON.parse(fs.readFileSync('./package.json'));

gulp.task('default', ["build"]);

gulp.task('build', function () {
  return gulp.src('src/**/*.proto')
    .pipe(gulpprotobuf({
		target: 'commonjs'
	}))
    .pipe(gulp.dest('build/'));
});


gulp.task('release', ['build'], function () {
  // you will need to have the environment var GITHUB_TOKEN set to a personal access token from
  // https://github.com/settings/tokens
  gulp.src(["build/*"])
    .pipe(release({
      manifest: require('./package.json')
    }))
    .on('error', function (err) {
      console.error(err)
    });
});

gulp.task('bump', function(){
    gulp.src('./package.json')
        .pipe(bump({version: packageJson.version + '.' + new Date().getTime()}))
        .pipe(gulp.dest('./'));
});

gulp.task('copyPackage', function(){
    gulp.src('./package.json')
        .pipe((gulp.dest('build')))
});

/**
 * Removes all build artifacts.
 */
gulp.task('clean', function () {
  return del(["build"]);
});
