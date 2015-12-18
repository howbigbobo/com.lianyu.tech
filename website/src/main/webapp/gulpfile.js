/*!
 * gulp
 * $ npm install gulp-sass gulp-autoprefixer gulp-minify-css gulp-jshint gulp-concat gulp-uglify gulp-imagemin gulp-notify gulp-rename gulp-livereload gulp-cache --save-dev
 */
// Load plugins
var gulp = require('gulp'),
    sass = require('gulp-sass'),
    autoprefixer = require('gulp-autoprefixer'),
    minifycss = require('gulp-minify-css'),
    jshint = require('gulp-jshint'),
    uglify = require('gulp-uglify'),
    imagemin = require('gulp-imagemin'),
    rename = require('gulp-rename'),
    concat = require('gulp-concat'),
    notify = require('gulp-notify'),
    cache = require('gulp-cache'),
    livereload = require('gulp-livereload');
// Styles
gulp.task('styles', function() {
	var cssFiles = [];
	cssFiles.push("portfolio.css");
	cssFiles.push("foundation.css");
	cssFiles.push("normalize.css");
	cssFiles.push("supersized.css");
	cssFiles.push("supersized.shutter.css");
	cssFiles.push("prettyPhoto.css");
	cssFiles.push("style.css");
	for(var i = 0;i<cssFiles.length;i++){
		cssFiles[i] = 'static/css/dreamer/css/'+cssFiles[i];
	}
	
    return gulp.src(cssFiles)
    .pipe(concat('lianyu-web.css'))
    .pipe(rename({ suffix: '.min' }))
    .pipe(minifycss())
    .pipe(gulp.dest('static/css/dreamer/css/'))
    .pipe(notify({ message: 'Styles task complete' }));
});
// Scripts
gulp.task('scripts', function() {
	var jsFiles =[];
	jsFiles.push("modernizr.foundation.js");
	jsFiles.push("foundation.min.js");
	jsFiles.push("jquery.parallax-1.1.3.js");
	jsFiles.push("jquery.prettyPhoto.js");
	jsFiles.push("jquery.easing.min.js");
	jsFiles.push("jquery-css-transform.js");
	jsFiles.push("supersized.3.2.7.min.js");
	jsFiles.push("supersized.shutter.min.js");
	jsFiles.push("custom.js");
	jsFiles.push("raphael.js");
	jsFiles.push("init.js");
	jsFiles.push("app.js");
	jsFiles.push("ajax.common.js");
	
	for(var i = 0;i<jsFiles.length;i++){
		jsFiles[i] = 'static/js/dreamer/'+jsFiles[i];
	}
	
  return gulp.src(jsFiles)
    .pipe(jshint())
    .pipe(jshint.reporter('default'))
    .pipe(concat('lianyu-web.js'))
    .pipe(rename({ suffix: '.min' }))
    .pipe(uglify())
    .pipe(gulp.dest('static/js'))
    .pipe(notify({ message: 'Scripts task complete' }));
});
// Images
gulp.task('images', function() {
  return gulp.src('static/css/dreamer/images/parallax/*')
    .pipe(cache(imagemin({ optimizationLevel: 8, progressive: true, interlaced: true })))
    .pipe(gulp.dest('images'))
    .pipe(notify({ message: 'Images task complete' }));
});
// Default task
gulp.task('default', function() {
    gulp.start('styles', 'scripts');
});
// Watch
gulp.task('watch', function() {
  // Watch .scss files
  gulp.watch('stylesheets/*.scss', ['styles']);
  // Watch .js files
  gulp.watch('javascripts/*.js', ['scripts']);
  // Watch image files
  gulp.watch('images/*', ['images']);
  // Create LiveReload server
  livereload.listen();
  // Watch any files in assets/, reload on change
  gulp.watch(['assets/*']).on('change', livereload.changed);
});
