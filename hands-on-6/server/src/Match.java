public class Match {

    private int scoreA;
    private int scoreB;
    private String teamA;
    private String teamB;
    private boolean done;
    private String status;

    // Getters and setters

    public void setScoreA(int score) {
        this.scoreA = score;
    }

    public void setScoreB(int score) {
        this.scoreB = score;
    }

    public int getScoreA() {
        return this.scoreA;
    }

    public int getScoreB() {
        return this.scoreB;
    }

    public void setTeamA(String team) {
        this.teamA = team;
    }

    public void setTeamB(String team) {
        this.teamB = team;
    }

    public String getTeamA() {
        return this.teamA;
    }

    public String getTeamB() {
        return this.teamB;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean getDone() {
        return this.done;
    }

}
