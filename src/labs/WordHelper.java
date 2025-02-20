/*
 * SPDX-FileCopyrightText: 2024 Samuel Wu
 *
 * SPDX-License-Identifier: MIT
 *
 * Project: Lab 01
 */

package labs;

public class WordHelper {
  /**
   * Sorting a String array by length through first copying the original array and then sorting the
   * copy by using bubble sort from Lab00 and comparing the number of vowels each string has using
   * countVowels before returning the sorted copy.
   */
  public static String[] sortByVowels(String[] words) {
    String[] sortedWords = copyStringArray(words);

    boolean hasSwapped;

    do {
      hasSwapped = false;

      for (int i = 0; i < sortedWords.length - 1; i++) {
        if (countVowels(sortedWords[i]) > countVowels(sortedWords[i + 1])) {
          String temp = sortedWords[i];
          sortedWords[i] = sortedWords[i + 1];
          sortedWords[i + 1] = temp;
          hasSwapped = true;
        }
      }
    } while (hasSwapped);

    return sortedWords;
  }

  /**
   * Sorting a String array by length through first copying the original array and then sorting the
   * copy by using bubble sort from Lab00 and comparing the number of consonants each string has
   * using countConsonants before returning the sorted copy.
   */
  public static String[] sortByConsonants(String[] words) {
    String[] sortedWords = copyStringArray(words);

    boolean hasSwapped;

    do {
      hasSwapped = false;

      for (int i = 0; i < sortedWords.length - 1; i++) {
        if (countConsonants(sortedWords[i]) > countConsonants(sortedWords[i + 1])) {
          String temp = sortedWords[i];
          sortedWords[i] = sortedWords[i + 1];
          sortedWords[i + 1] = temp;
          hasSwapped = true;
        }
      }
    } while (hasSwapped);

    return sortedWords;
  }

  /**
   * Sorting a String array by length through first copying the original array and then sorting the
   * copy by using bubble sort from Lab00 and comparing the length of the string using length()
   * before returning the sorted copy.
   */
  public static String[] sortByLength(String[] words) {
    String[] sortedWords = copyStringArray(words);

    boolean hasSwapped;

    do {
      hasSwapped = false;

      for (int i = 0; i < sortedWords.length - 1; i++) {
        if (sortedWords[i].length() > sortedWords[i + 1].length()) {
          String temp = sortedWords[i];
          sortedWords[i] = sortedWords[i + 1];
          sortedWords[i + 1] = temp;
          hasSwapped = true;
        }
      }
    } while (hasSwapped);

    return sortedWords;
  }

  /**
   * Copying a String array by creating a new String array of the same length as the original array
   * and then copying every element of the original array into the new array.
   */
  private static String[] copyStringArray(String[] original) {
    String[] copy = new String[original.length];

    for (int i = 0; i < original.length; i++) {
      copy[i] = original[i];
    }

    return copy;
  }

  /**
   * Count the number of consonants in a string by checking if a character is a vowel using
   * isCharacterVowel.
   */
  private static int countVowels(String word) {
    int count = 0;

    for (int i = 0; i < word.length(); i++) {
      if (isCharVowel(word.charAt(i))) {
        count++;
      }
    }

    return count;
  }

  /**
   * Count the number of consonants in a string by checking if a character is not a vowel by
   * inverting isCharacterVowel.
   */
  private static int countConsonants(String word) {
    int count = 0;

    for (int i = 0; i < word.length(); i++) {
      if (!isCharVowel(word.charAt(i))) {
        count++;
      }
    }

    return count;
  }

  /**
   * Check and returns true if a character is a vowel (a, e, i, o, u, and y) or false if the
   * character is a consonant.
   */
  private static boolean isCharVowel(char character) {
    return character == 'a'
        || character == 'e'
        || character == 'i'
        || character == 'o'
        || character == 'u'
        || character == 'y';
  }
}
