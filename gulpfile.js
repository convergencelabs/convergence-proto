const gulp = require('gulp');

const del = require('del');
const fs = require('fs');
const bump = require('gulp-bump');

const packageJson = JSON.parse(fs.readFileSync('./package.json'));

gulp.task('default', []);

gulp.task('release', function () {
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
        .pipe(gulp.dest('./dist/'));
});

/**
 * Removes all build artifacts.
 */
gulp.task('clean', function () {
  return del(["dist"]);
});
