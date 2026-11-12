
import org.code.theater.*;
import org.code.media.*;

public class UserStory {

  private String[] names;
  private double[] points;
  private double[] percentages;
  private int[] attempts;
  private NBAPlayer[] players;

  /*
   * Creates an empty NBA dataset.
   */
  public UserStory() {
    names = new String[0];
    points = new double[0];
    percentages = new double[0];
    attempts = new int[0];
    players = new NBAPlayer[0];
  }

  /*
   * Loads NBA statistics from four text files.
   * Precondition: All files have matching row counts.
   * Postcondition: Creates one NBAPlayer per row.
   */
  public UserStory(String namesFile, String pointsFile,
                   String pctFile, String attemptsFile) {
    names = FileReader.toStringArray(namesFile);
    points = FileReader.toDoubleArray(pointsFile);
    percentages = FileReader.toDoubleArray(pctFile);
    attempts = FileReader.toIntArray(attemptsFile);

    players = new NBAPlayer[names.length];

    for (int i = 0; i < players.length; i++) {
      players[i] = new NBAPlayer(names[i], points[i],
                                 percentages[i], attempts[i]);
    }
  }

  /*
   * Returns the player with the highest points per game.
   */
  public NBAPlayer findTopScorer() {
    if (players.length == 0) {
      return null;
    }

    NBAPlayer best = players[0];

    for (int i = 1; i < players.length; i++) {
      if (players[i].getPoints() > best.getPoints()) {
        best = players[i];
      }
    }

    return best;
  }

  /*
   * Finds the highest shooting percentage among players
   * with at least the specified number of attempts.
   */
  public NBAPlayer findBestShooter(int minimumAttempts) {
    NBAPlayer best = null;

    for (int i = 0; i < players.length; i++) {
      if (players[i].getAttempts() >= minimumAttempts) {
        if (best == null ||
            players[i].getPercentage() > best.getPercentage()) {
          best = players[i];
        }
      }
    }

    return best;
  }

  /*
   * Creates a new array containing players who average
   * at least the specified number of points per game.
   */
  public NBAPlayer[] findHighScorers(double minimumPoints) {
    int count = 0;

    for (int i = 0; i < players.length; i++) {
      if (players[i].getPoints() >= minimumPoints) {
        count++;
      }
    }

    NBAPlayer[] result = new NBAPlayer[count];
    int index = 0;

    for (int i = 0; i < players.length; i++) {
      if (players[i].getPoints() >= minimumPoints) {
        result[index] = players[i];
        index++;
      }
    }

    return result;
  }

  /*
   * Returns a detailed summary of the NBA dataset.
   */
  public String toString() {
    return "NBA Player Performance Analyzer\n"
         + "Players analyzed: " + players.length + "\n"
         + "Data: Points per game, FG%, and shot attempts";
  }
}
