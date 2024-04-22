/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html", // paths to all html files
    "./src/main/resources/static/js/**/*.js" // if you have custom js files using Tailwind
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
