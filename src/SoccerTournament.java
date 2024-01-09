import java.text.CollationElementIterator;
import java.util.Collection;

public class SoccerTournament {
    private Collection<String> teams;
    private Collection<Match> matches;

    public SoccerTournament(Collection<Match> ms, Collection<String> ts) throws SoccerException {
        this.teams = ts;
        for (Match m : ms) {
            if (m instanceof SoccerMatch)
                this.matches.add(m);
            else if (!this.teams.contains(m.getTeam1()))
                throw new SoccerException(m.getTeam1()  + " not in team list for this tournament");
            else if (!this.teams.contains(m.getTeam2()))
                throw new SoccerException(m.getTeam2()  + " not in team list for this tournament");
            else
                throw new SoccerException("Match involving " + m.getTeam1() + " and " + m.getTeam2() + " is not a soccer match");
        }
    }

    public int getPoints(String t) {
        int sum = 0;
        for (Match m : this.matches) {
            if (((SoccerMatch) m).winner() == t)
                sum += 3;
            else if (m.getTeam2() == t || m.getTeam1() == t)
                sum += 1;
        }
        return sum;
    }

}


