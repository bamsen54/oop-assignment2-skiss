package com.simon.item;

public class Movie extends Item {

    private String runtime;
    private String format;

    public Movie() {
    }

    public Movie( int id,  String title, String category, String format, String runtime) {
        super( id, title, category );
        this.format  = format;
        this.runtime = runtime;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( "id:       " ).append( this.getId() ).append( "\n" );
        stringBuilder.append( "title:    " ).append( this.getTitle() ).append( "\n" );
        stringBuilder.append( "category: " ).append( this.getCategory() ).append( "\n" );
        stringBuilder.append( "runtime:  " ).append( this.getRuntime() ).append( "\n" );
        stringBuilder.append( "format:   " ).append( this.getFormat() ).append( "\n" );

        return stringBuilder.toString();
    }
}
