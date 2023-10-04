document.addEventListener("DOMContentLoaded", function() {
    var popup = document.querySelector(".popup");
    var confirmButton = document.getElementById("confirm");
    var cancelButton = document.getElementById("cancel");
    var deleteButtons = document.querySelectorAll(".delete-btn"); // Use querySelectorAll to select all delete buttons
    var forms = document.querySelectorAll("form"); // Select all forms on the page
    var selectedIndex;
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


            // Handle form submission here or perform any other actions
            console.log("Form submitted with ID:", postedID);
        });
    });

    // Handle confirm button click
    confirmButton.addEventListener("click", function() {
        // Perform your confirm action here
        // For example, close the popup
        popup.style.display = "none";
        forms[selectedIndex].submit();
    });

    // Handle cancel button click
    cancelButton.addEventListener("click", function() {
        // Perform your cancel action here
        // For example, close the popup
        popup.style.display = "none";
        return false;
    });
});