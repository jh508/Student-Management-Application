package com.studentmanagement.StudentManagementApp.Utilities;

public final class StudentControllerUtility {

    private static final String INVALID_CHARACTERS = "<>/.,'=+-_`@!#$%^&*()_+[]{}?;:~0123456789";

    public static boolean containsInvalidCharacters(String input){

        for (char c : input.toCharArray()) {
            if (INVALID_CHARACTERS.indexOf(c) != -1) {
                return true; // Input contains an invalid character
            }
        }

        return false;
    }

}
