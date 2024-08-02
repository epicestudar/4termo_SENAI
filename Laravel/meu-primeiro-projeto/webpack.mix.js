const mix = require('laravel-mix');

mix.js('resources/js/app.js', 'public/js')
   .sass('resources/css/style.scss', 'public/css')	
   .postCss('resources/css/style.css', 'public/css', [
       require('postcss-import'),
       require('tailwindcss'),
       require('autoprefixer'),
   ]);