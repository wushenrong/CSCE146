/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 */

package homework.homework02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class VideoGamesDatabase {
  private GenericLinkedList<VideoGame> videoGamesList;
  private GenericLinkedList<VideoGame> searchResults;

  public VideoGamesDatabase() {
    videoGamesList = null;
    searchResults = null;
  }

  /**
   * Print out search results by checking if there is already results saved. If there is no results,
   * return false for not being able to print out the results. Else reset the current reference of
   * searchResults back to the head, then iterate through the list and print out each result. Lastly
   * return true as all of the results was printed.
   */
  public boolean printVideoGamesSearchResults() {
    if (searchResults == null) {
      return false;
    }

    searchResults.resetCurrent();

    while (searchResults.hasNext()) {
      System.out.println(searchResults.getCurrent());
      searchResults.next();
    }

    return true;
  }

  public void readVideoGameCollectionFile(String filename) {
    videoGamesList = new GenericLinkedList<>();

    try (Scanner fileScanner = new Scanner(new File(filename))) {
      while (fileScanner.hasNext()) {
        String entry = fileScanner.nextLine();
        String[] fields = entry.split(VideoGame.DELIMITER);

        if (fields.length != VideoGame.NUMBER_OF_FIELDS) {
          continue;
        }

        String videoGameName = fields[0];
        String videoGameConsole = fields[1];

        VideoGame newVideoGame = new VideoGame(videoGameName, videoGameConsole);
        videoGamesList.add(newVideoGame);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Search the video game database by checking if the video games list, the game's name, or the
   * game's console name is `null`, and if it passes return false for not being able to search the
   * database. Else, create a new linked list that contains the results for the search. Next set the
   * current reference of the videoGamesList back to the head, then iterate through the list and
   * getting the current game's name and console. Next check if the game's name and console contains
   * the queries provided or if either query of the game or the console, return all game name or
   * game console respectively. If the previous checks are true, then add it to the search result.
   * Lastly return true as the search was successful.
   */
  public boolean searchVideoGames(String gameQuery, String consoleQuery) {
    if (videoGamesList == null || gameQuery == null || consoleQuery == null) {
      return false;
    }

    searchResults = new GenericLinkedList<>();

    videoGamesList.resetCurrent();

    while (videoGamesList.hasNext()) {
      VideoGame game = videoGamesList.getCurrent();

      if (game == null) {
        continue;
      }

      String gameName = game.getName().toLowerCase();
      String gameConsole = game.getConsole().toLowerCase();

      boolean matchedGameName = false;
      boolean matchedGameConsole = false;

      if (gameQuery.equals("*") || gameName.contains(gameQuery.toLowerCase())) {
        matchedGameName = true;
      }

      if (consoleQuery.equals("*") || gameConsole.contains(consoleQuery.toLowerCase())) {
        matchedGameConsole = true;
      }

      if (matchedGameName && matchedGameConsole) {
        searchResults.add(game);
      }

      videoGamesList.next();
    }

    return true;
  }

  public boolean writeVideoGamesSearchResults(String filename, boolean append) {
    if (searchResults == null) {
      return false;
    }

    try (PrintWriter fileWriter = new PrintWriter(new FileOutputStream(filename, append))) {
      searchResults.resetCurrent();

      while (searchResults.hasNext()) {
        fileWriter.println(searchResults.getCurrent());
        searchResults.next();
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }
}
