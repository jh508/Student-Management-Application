document.addEventListener("DOMContentLoaded", function() {
    var popup = document.querySelector(".popup");
    var confirmButton = document.getElementById("confirm");
    var cancelButton = document.getElementById("cancel");
    var deleteButtons = document.querySelectorAll(".delete-btn");
    var forms = document.querySelectorAll("#deleteForm"); // Select all forms on the page
    var selectedIndex;
    const nightModeToggleOff = document.getElementById("nightOn");
    const nightModeToggleOn = document.getElementById("nightOff");
    var theme = document.getElementById('cssLink');
    let nightModeActive = localStorage.getItem("nightMode");

    if(nightModeActive === "true"){
            theme.href ='/css/studentListNight.css';
            nightModeToggleOn.style.display = "none";
            nightModeToggleOff.style.display = "inline";
        }
        else{
            theme.href ='/css/studentList.css';
            nightModeToggleOn.style.display = "inline";
            nightModeToggleOff.style.display = "none";
        }

      nightModeToggleOn.addEventListener("click", function(){
              nightModeToggleOff.style.display = "inline";
              nightModeToggleOn.style.display = "none";
              theme.href ='/css/studentListNight.css';
              localStorage.setItem("nightMode", "true");

          })

          nightModeToggleOff.addEventListener("click", function(){
              nightModeToggleOff.style.display = "none";
              nightModeToggleOn.style.display = "inline";
              theme.href ='/css/studentList.css';
              localStorage.setItem("nightMode", "false");
          })

    // Attach an event listener to each form to prevent submission
    forms.forEach(function(form, index) {
        form.addEventListener("submit", function(event) {
            // Prevent the form from submitting immediately
            event.preventDefault();

            // Find the hidden input with name="id" within the form
            var idInput = form.querySelector("input[name='id']");
            // Get the value of the "id" input element
            var postedID = idInput.value;
            selectedIndex = index;
            popup.style.display = "block";

        });
    });

    // Handle confirm button click
    confirmButton.addEventListener("click", function() {
        popup.style.display = "none";
        forms[selectedIndex].submit();
    });

    // Handle cancel button click
    cancelButton.addEventListener("click", function() {
        popup.style.display = "none";
        return false;
    });
});