

$(document).ready(function() {
  // Check if there's an error message to display
  var errorMessageFirstName = $("#error-message-firstName").text().trim();
  var errorMessageLastName = $("#error-message-lastName").text().trim();
  var errorMessageAge = $("#error-message-age").text().trim();
  var errorMessageDegree = $("#error-message-degree").text().trim();


  // Function to show an error message if it's not empty
  function showErrorMessage(errorMessage, elementId) {
    if (errorMessage.length > 0) {
      $("#" + elementId).show();
    }
  }

  // Show error messages if they exist
  showErrorMessage(errorMessageFirstName, "error-message-firstName");
  showErrorMessage(errorMessageLastName, "error-message-lastName");
  showErrorMessage(errorMessageAge, "error-message-age");
  showErrorMessage(errorMessageDegree, "error-message-degree");
});