package hu.progmatic.model;

public class Quiz {
    private String date;
    private String location;
    private int duration;
    private int winnerScore;
    private int numberOfTeams;
    private int numberOfParticipant;
    private int price;

    public Quiz() {

    }

    public Quiz(String date, String location, int duration, int winnerScore, int numberOfTeams, int numberOfParticipant, int price) {
        this.date = date;
        this.location = location;
        this.duration = duration;
        this.winnerScore = winnerScore;
        this.numberOfTeams = numberOfTeams;
        this.numberOfParticipant = numberOfParticipant;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public int getNumberOfParticipant() {
        return numberOfParticipant;
    }

    public void setNumberOfParticipant(int numberOfParticipant) {
        this.numberOfParticipant = numberOfParticipant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", duration=" + duration +
                ", winnerScore=" + winnerScore +
                ", numberOfTeams=" + numberOfTeams +
                ", numberOfParticipant=" + numberOfParticipant +
                ", price=" + price +
                '}';
    }
}
