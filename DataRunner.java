
public class DataRunner {

  /*
   * Runs the NBA analysis and displays the results.
   */
  public static void main(String[] args) {

    UserStory nba = new UserStory(
      "player_names.txt",
      "points_pg.txt",
      "field_goal_pct.txt",
      "field_goal_attempts.txt"
    );

    System.out.println(nba);

    // Question 1: Find the highest-scoring player.
    NBAPlayer scorer = nba.findTopScorer();

    if (scorer != null) {
      System.out.println("\nQUESTION 1: Highest PPG");
      System.out.println(scorer);
    }

    // Question 2: Find the most accurate shooter
    // with at least 100 field goal attempts.
    NBAPlayer shooter = nba.findBestShooter(100);

    if (shooter != null) {
      System.out.println("\nQUESTION 2: Best FG%");
      System.out.println(shooter);
    }

    // Create a new array of players averaging 20+ PPG.
    NBAPlayer[] highScorers = nba.findHighScorers(20);

    System.out.println("\nPlayers averaging 20+ PPG:");
    System.out.println(highScorers.length);

    for (int i = 0; i < highScorers.length; i++) {
      System.out.println(highScorers[i].getName());
    }
  }
}
