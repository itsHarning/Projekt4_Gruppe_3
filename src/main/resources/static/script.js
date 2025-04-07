const showPopupBtn = document.querySelector(".login-btn")
const showSignupBtn = document.querySelector(".signup-btn")
const formPopup = document.querySelector(".form-container")
const hidePopupBtn = document.querySelector(".form-container .close-btn")
const loginSignupLink = document.querySelectorAll(".form-box .bottom-link a")

// show form popup
showPopupBtn.addEventListener("click", () => {
    formPopup.classList.remove("show-signup")
    document.body.classList.toggle("show-popup")
});

showSignupBtn.addEventListener("click", () => {
    formPopup.classList.add("show-signup")
    document.body.classList.toggle("show-popup")
});

// hide form popup
hidePopupBtn.addEventListener("click", () => showPopupBtn.click());

loginSignupLink.forEach(link => {
    link.addEventListener("click", (e) => {
        e.preventDefault();

        // if the clicked link is signup, then add "show-signup" class to the form popup, else remove the class
        formPopup.classList[link.id === "signup-link" ? 'add' : 'remove']("show-signup")
    })
});