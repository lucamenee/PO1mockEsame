abstract public class Match {
    private String team1;
    private String team2;

    public String winner;

    public Match(String t1, String t2) {
        setTeams(t1, t2);
    }

    private void setTeams(String t1, String t2) {
        this.team1 = t1;
        this.team2 = t2;
    }

    public String getTeam1() {
        return this.team1;
    }

    public String getTeam2() {
        return this.team2;
    }

    public abstract String winner();
}
