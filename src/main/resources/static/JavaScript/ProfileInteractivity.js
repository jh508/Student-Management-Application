document.addEventListener("DOMContentLoaded", function() {
    const userProfile = document.querySelector(".dropdown");
    const userProfileDropdownContent = document.querySelector(".dropdown-content");
    const toggleArrowUp = document.getElementById("toggleArrowUp");
    const toggleArrowDown = document.getElementById("toggleArrowDown");

    userProfile.addEventListener("click", function(event){
        userProfileDropdownContent.style.display = "block";
        toggleArrowUp.style.display = "none";
        toggleArrowDown.style.display = "inline";
    })

    document.addEventListener("click", function(event){
        if(!userProfile.contains(event.target) && !userProfileDropdownContent.contains(event.target)){
            userProfileDropdownContent.style.display = "none";
            toggleArrowUp.style.display="inline";
            toggleArrowDown.style.display="none";
        }
        else{
        return false;
        }

    })

});