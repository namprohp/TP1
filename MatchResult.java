public class MatchResult {
    private final Team homeTeam;
    private final Team visitorTeam;
    private final int homeTeamScore;
    private final int visitorTeamScore;
    public MatchResult(
            Team homeTeam,
            Team visitorTeam,
            int homeTeamScore,
            int visitorTeamScore
    ) {
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
        this.homeTeamScore = homeTeamScore;
        this.visitorTeamScore = visitorTeamScore;
    }
    public Team getHomeTeam() {
        return homeTeam;
    }
    public Team getVisitorTeam() {
        return visitorTeam;
    }
    public int getHomeTeamScore() {
        return homeTeamScore;
    }
    public int getVisitorTeamScore() {
        return visitorTeamScore;
    }
    @Override
    public String toString() {
        return homeTeam + "/" + visitorTeam + " "
                + homeTeamScore + "-" + visitorTeamScore;
    }
}