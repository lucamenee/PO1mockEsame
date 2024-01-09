
public class SoccerMatch extends Match {
    private int goal1;
    private int goal2;

    public SoccerMatch(String t1, String t2, int g1, int g2) {
        super(t1, t2);
        this.goal1 = g1;
        this.goal2 = g2;
    }



    public String winner() {
        if (this.goal1 > this.goal2)
            return this.getTeam1();
        else if (this.goal2 > this.goal1)
            return this.getTeam2();
        else
            return null;
    }
}
