/** @type {import('tailwindcss').Config} */
module.exports = {
    content: ["./src/**/*.clj"],
    theme: {
        extend: {},
    },
    plugins: [
        require("@tailwindcss/forms"),
        require("@tailwindcss/aspect-ratio"),
        require("@tailwindcss/typography"),
        require("@tailwindcss/container-queries"),
    ],
};