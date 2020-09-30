package com.cerebrobinario.servermatches;

public class Match {
    private int scoreA;
    private int scoreB;
    private String teamA;
    private String teamB;
    private boolean done;
    private String status;

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreA() {
        return this.scoreA;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public int getScoreB() {
        return this.scoreB;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamA() {
        return this.teamA;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getTeamB() {
        return this.teamB;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Status: " + this.status + "\n" + this.teamA + " " + this.scoreA + " - " + this.scoreB + " " + this.teamB
                + "\n\n";
    }
}
