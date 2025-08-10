/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/**/*.html", "./src/main/resources/static/**/*.{css,js}"],
  theme: {
    /*screens:{
      "sm": "250px",
      "md" : "600"
    },*/
    extend: {
      colors: {
        "black" : "#222831",
        "grey": "#393E46",
        "glass-blue": "#00ADB5",
        "white": "#EEEEEE"
      }
    },
  },
  plugins: [],
}

