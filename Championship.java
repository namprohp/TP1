import java.util.*;

public class Championship {
    private final String name;
    private final Set<Team> teams = new HashSet<>();
    private final List<MatchResult> matches = new ArrayList<>();

    public Championship(String name) {
        this.name = name;
    }
    public Team getTeam(int id) {
        for (Team team : teams) {
            if (team.getId() == id) {
                return team;
            }
        }
        return null;
    }

    public Team getTeam(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }
    public void addTeam(Team team) {
        teams.add(team);
    }
    public void addMatchResult(MatchResult match) {
        matches.add(match);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name + "\n\n");
        builder.append("Liste des résultats\n");
        for (MatchResult match : matches) {
            builder.append("\n" + match);
        }
        return builder.toString();
    }
    public int computeTeamPoints(MatchEvaluator evaluator, int teamId) {
        int totalPoints = 0;
        for (MatchResult match : matches) {
            int matchPoints =
                    match.getHomeTeam().getId() == teamId ?
                            evaluator.getHomeTeamPoints(match) :
                            match.getVisitorTeam().getId() == teamId ?
                                    evaluator.getVisitorTeamPoints(match) :
                                    0;
            totalPoints = totalPoints + matchPoints;
        }
        return totalPoints;
    }
    public void printPoints(MatchEvaluator evaluator) {
        StringBuilder builder = new StringBuilder();
        builder.append("Points des clubs");
        for (Team team : teams) {
            int nbPoints = this.computeTeamPoints(evaluator, team.getId());
            builder.append("\n" + team.getName() + " " + nbPoints);
            builder.append(nbPoints > 1 ? "points" : "point");
        }
        System.out.println(builder.toString());
    }
    public void printranking(MatchEvaluator evaluator) {
        StringBuilder builder = new StringBuilder();
        builder.append("Classement " + this.name);
        int rank = 1;
        for (Team team : this.getRankedTeams()) {
            int points = computeTeamPoints(evaluator,1);
            builder.append("\n" + rank + " " + team.getName() + " " + points);
            builder.append(points > 1 ? " points" : " point");
            rank = rank + 1;
        }
        System.out.println(builder.toString());
    }


    public List<Team> getRankedTeams() {
        List<Team> rankedTeams = new ArrayList<>();
        rankedTeams.addAll(this.teams);
        MatchEvaluator evaluator = null;
        Collections.sort(rankedTeams, new TeamComparator(this,evaluator));
        return rankedTeams;
    }
    private static void appendColumn(StringBuilder builder, int columnLength,String text) {
        int padLength = Math.max(0, columnLength - text.length());
        builder.append(text);
        builder.append(" ".repeat(padLength));
    }
    private static final int RANK_COLUMN_LENGTH = 3;
    private static final int TEAM_COLUMN_LENGTH = 10;
    public void printRanking(MatchEvaluator evaluator) {
        StringBuilder builder = new StringBuilder();
        builder.append("Classement " + this.name);
        int rank = 1;
        for (Team team : this.getRankedTeams()) {
            int points = computeTeamPoints(evaluator,1);
            builder.append("\n");
            appendColumn(builder, RANK_COLUMN_LENGTH, "rank");
            rank = rank + 1;
            appendColumn(builder, TEAM_COLUMN_LENGTH, team.getName());
            builder.append(points + (points > 1 ? " points" : " point"));
        }
        System.out.println(builder.toString());
    }
}







