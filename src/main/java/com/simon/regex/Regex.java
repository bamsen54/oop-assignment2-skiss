package com.simon.regex;

import java.util.regex.Pattern;

public class Regex {

    public boolean isMatch( String string, String pattern ) {

        return Pattern.compile( pattern, Pattern.CASE_INSENSITIVE ).matcher( string ).matches();
    }

    public boolean isFound( String string, String pattern ) {

        return Pattern.compile( pattern, Pattern.CASE_INSENSITIVE ).matcher( string ).find();
    }
}
