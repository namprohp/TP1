public class FootballEvaluator implements MatchEvaluator {
    private static final int VICTORY = 3;
    private static final int DEFEAT = 0;
    private static final int DRAW = 1;
    public int getHomeTeamPoints(MatchResult match) {
        return (match.getHomeTeamScore() > match.getVisitorTeamScore()) ? VICTORY :
                (match.getHomeTeamScore() < match.getVisitorTeamScore()) ? DEFEAT :
                        DRAW;
    }
    public int getVisitorTeamPoints(MatchResult match) {
        return (match.getVisitorTeamScore() > match.getHomeTeamScore()) ? VICTORY :
                (match.getVisitorTeamScore() < match.getHomeTeamScore()) ? DEFEAT :
                        DRAW;
    }
}
