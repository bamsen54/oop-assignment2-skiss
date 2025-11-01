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
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPEGIRating() {
        return this.PEGIRating;
    }

    public void setPEGIRating(String PEGIRating) {
        this.PEGIRating = PEGIRating;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( "|" );
        stringBuilder.append( this.getId() ).append( "|" );
        stringBuilder.append( this.getTitle() ).append( "|" );
        stringBuilder.append( this.getCategory() ).append( "|" );
        stringBuilder.append( this.getPlatform() ).append( "|" );
        stringBuilder.append( this.getPEGIRating() ).append( "|" );

        return stringBuilder.toString();
    }
}
