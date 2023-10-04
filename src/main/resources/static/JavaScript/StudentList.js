document.addEventListener("DOMContentLoaded", function() {
    var popup = document.querySelector(".popup");
    var confirmButton = document.getElementById("confirm");
    var cancelButton = document.getElementById("cancel");
    var deleteButtons = document.querySelectorAll(".delete-btn");
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