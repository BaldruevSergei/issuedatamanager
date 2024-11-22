package com.example.plugins.ao;

class DVD extends Media {
    private String director;
    private int duration; // Продолжительность в минутах

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getMediaType() {
        return "DVD";
    }
}
