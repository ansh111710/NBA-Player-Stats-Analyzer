
public class NBAPlayer {

  private String name;
  private double points;
  private double percentage;
  private int attempts;

  /*
   * Creates a player with default statistics.
   */
  public NBAPlayer() {
    name = "Unknown";
    points = 0;
    percentage = 0;
    attempts = 0;
  }

  /*
   * Initializes a player with NBA statistics.
   */
  public NBAPlayer(String name, double points,
                   double percentage, int attempts) {
    this.name = name;
    this.points = points;
    this.percentage = percentage;
    this.attempts = attempts;
  }

  /*
   * Returns the player's name.
   */
  public String getName() {
    return name;
  }

  /*
   * Returns the player's points per game.
   */
  public double getPoints() {
    return points;
  }

  /*
   * Returns the player's field goal percentage as a decimal.
   */
  public double getPercentage() {
    return percentage;
  }

  /*
   * Returns the player's total field goal attempts.
   */
  public int getAttempts() {
    return attempts;
  }

  /*
   * Returns the player's statistics as readable text.
   */
  public String toString() {
    return name + " | PPG: " + points
         + " | FG%: " + (percentage * 100)
         + " | Attempts: " + attempts;
  }
}
