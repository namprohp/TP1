import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {
    private final Championship championship;
    private final MatchEvaluator evaluator;
    public TeamComparator(Championship championship, MatchEvaluator evaluator) {
        this.championship = championship;
        this.evaluator = evaluator;
    }
    public int compare(Team team1, Team team2) {
        return championship.computeTeamPoints(evaluator, team2.getId())
                - championship.computeTeamPoints(evaluator, team1.getId());
    }
}

