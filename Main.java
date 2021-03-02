public class Main {
    public static void main(String[] args) {
        Championship ligue1 = new Championship("Championnat de France de football");
        Team om = new Team("OM", 1);
        Team monaco = new Team("MONACO", 2);
        Team psg = new Team("PSG", 3);
        ligue1.addTeam(om);
        ligue1.addTeam(monaco);
        ligue1.addTeam(psg);
        ligue1.addMatchResult(new MatchResult(om, psg, 3, 2));
        ligue1.addMatchResult(new MatchResult(psg, om, 0, 5));
        ligue1.addMatchResult(new MatchResult(monaco, om, 6, 1));
        ligue1.addMatchResult(new MatchResult(om, monaco, 2, 2));
        ligue1.addMatchResult(new MatchResult(psg,monaco,0,0));
        ligue1.addMatchResult(new MatchResult(monaco, psg, 1, 2));
        System.out.println(ligue1);
    }
    public interface MatchEvaluator {
        int getHomeTeamPoints(MatchResult match);
        int getVisitorTeamPoints(MatchResult match);
    }


}
