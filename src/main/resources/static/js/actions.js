"use strict"
function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
};

const submit = document.querySelector("[type='submit']");
submit.addEventListener("mouseover",  function (event) {
     console.log(event.target.style);
});
