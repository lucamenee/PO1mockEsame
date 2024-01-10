import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoccerTournament {
    private ArrayList<String> teams;
    private ArrayList<Match> matches;

    public SoccerTournament(List<Match> ms, List<String> ts) throws SoccerException {
        this.teams = new ArrayList<String>();
        this.matches = new ArrayList<Match>();

        this.teams.addAll(ts);

        for (Match m : ms) {
            if (m instanceof SoccerMatch) {
                this.matches.add(m);
                if (!this.teams.contains(m.getTeam1()))
                    throw new SoccerException(m.getTeam1() + " not in team list for this tournament");
                else if (!this.teams.contains(m.getTeam2()))
                    throw new SoccerException(m.getTeam2() + " not in team list for this tournament");
            } else
                throw new SoccerException("Match involving " + m.getTeam1() + " and " + m.getTeam2() + " is not a soccer match");
        }
    }

    public int getPoints(String t) {
        int sum = 0;
        for (Match m : this.matches) {
            if (((SoccerMatch) m).winner().equals(t))
                sum += 3;
            else if (m.getTeam2().equals(t) || m.getTeam1().equals(t))
                sum += 1;
        }
        return sum;
    }

}


