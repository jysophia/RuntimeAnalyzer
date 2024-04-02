/** @type {import('tailwindcss').Config} */

export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {},
  },
  daisyui: {
    themes: [
      {
        mytheme: {

          "primary": "#6195ad",

          "secondary": "#d6b1b6",

          "accent": "#9dcbba",

          "neutral": "#b5a8bb",

          "base-100": "#f3f4f6",

          "info": "#00c8ff",

          "success": "#00ffb1",

          "warning": "#eeb200",

          "error": "#ff888b",
        },
      },
    ],
  },
  plugins: [require("daisyui")]
}

