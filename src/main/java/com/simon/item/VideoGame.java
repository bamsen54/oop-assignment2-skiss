package com.simon.item;

public class VideoGame extends Item{

    private String platform;
    private String PEGIRating; //

    public VideoGame() {
    }

    public VideoGame(int id, String title, String category, String platform, String PEGIRating) {
        super( id, title,  category );
        this.platform = platform;
        this.PEGIRating = PEGIRating;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPEGIRating() {
        return PEGIRating;
    }

    public void setPEGIRating(String PEGIRating) {
        this.PEGIRating = PEGIRating;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( "id:         " ).append( this.getId() ).append( "\n" );
        stringBuilder.append( "title:      " ).append( this.getTitle() ).append( "\n" );
        stringBuilder.append( "category:   " ).append( this.getCategory() ).append( "\n" );
        stringBuilder.append( "platform:   " ).append( this.getPlatform() ).append( "\n" );
        stringBuilder.append( "age rating: " ).append( this.getPEGIRating() ).append( "\n" );

        return stringBuilder.toString();
    }
}
