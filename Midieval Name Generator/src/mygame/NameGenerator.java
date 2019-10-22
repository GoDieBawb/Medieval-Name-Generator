/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author Bob
 */
public class NameGenerator {

public String generateName(String originalName) {
    
    String newName;
    
    if (originalName.length() < 3)    
    originalName   = "abc";
    
    String fc      = originalName.toLowerCase().substring(1,2);
    String sc      = originalName.toLowerCase().substring(originalName.length()-2,originalName.length()-1);
    String tc      = originalName.toLowerCase().substring(originalName.length()-1);
    newName        = (getTitle(fc) + " " + getName(sc) + " " + getSuffix(tc));
    
    return newName;
    
}

private String getTitle(String letter) {
  
  String syl = "";
  
  if (letter.equals("a")) {
      syl = "Baron Von";
  }
  
  else if (letter.equals("b")) {
      syl = "Count";   
  }
  
  else if (letter.equals("c")) {
      syl = "Sir";
  }

  else if (letter.equals("d")) {
      syl = "Sire";
  }
  
  else if (letter.equals("e")) {
      syl = "Noble";
  }
  
  else if (letter.equals("f")) {
      syl = "Page";
  }
  
  else if (letter.equals("g")) {
      syl = "Squire";
  }
  
  else if (letter.equals("h")) {
      syl = "Sherriff";
  }
  
  else if (letter.equals("i")) {
      syl = "Dutchess";
  }
  
  else if (letter.equals("j")) {
      syl = "Countess";
  }
  
  else if (letter.equals("k")) {
      syl = "Lord";
  }
  
  else if (letter.equals("l")) {
      syl = "Monk";
  }
  
  else if (letter.equals("m")) {
      syl = "Priest";
  }
  
  else if (letter.equals("n")) {
      syl = "Bishop";
  }
  
  else if (letter.equals("o")) {
      syl = "ArchBishop";
  }
  
  else if (letter.equals("p")) {
      syl = "Cardinal";
  }
  
  else if (letter.equals("q")) {
      syl = "Pope";
  }
  
  else if (letter.equals("r")) {
      syl = "King";
  }
  
  else if (letter.equals("s")) {
      syl = "Queen";
  }
  
  else if (letter.equals("t")) {
      syl = "Admiral";
  }
  
  else if (letter.equals("u")) {
      syl = "General";
  }
  
  else if (letter.equals("v")) {
      syl = "Private";
  }
  
  else if (letter.equals("w")) {
      syl = "Colonel";
  }
  
  else if (letter.equals("x")) {
      syl = "Abbot";
  }
  
  else if (letter.equals("y")) {
      syl = "Friar";
  }
  
  else if (letter.equals("z")) {
      syl = "Lady";
  }
  
  return syl;
  }

private String getName(String letter) {
  
  String syl = "";
  
  if (letter.equals("a")) {
      syl = "James";
  }
  
  else if (letter.equals("b")) {
      syl = "Thomas";   
  }
  
  else if (letter.equals("c")) {
      syl = "Mark";
  }

  else if (letter.equals("d")) {
      syl = "John";
  }
  
  else if (letter.equals("e")) {
      syl = "Robin";
  }
  
  else if (letter.equals("f")) {
      syl = "Alfred";
  }
  
  else if (letter.equals("g")) {
      syl = "Henry";
  }
  
  else if (letter.equals("h")) {
      syl = "Colton";
  }
  
  else if (letter.equals("i")) {
      syl = "Edgar";
  }
  
  else if (letter.equals("j")) {
      syl = "Richard";
  }
  
  else if (letter.equals("k")) {
      syl = "Edward";
  }
  
  else if (letter.equals("l")) {
      syl = "William";
  }
  
  else if (letter.equals("m")) {
      syl = "Barney";
  }
  
  else if (letter.equals("n")) {
      syl = "Carl";
  }
  
  else if (letter.equals("o")) {
      syl = "Dudley";
  }
  
  else if (letter.equals("p")) {
      syl = "Dunston";
  }
  
  else if (letter.equals("q")) {
      syl = "Elmer";
  }
  
  else if (letter.equals("r")) {
      syl = "George";
  }
  
  else if (letter.equals("s")) {
      syl = "Ronald";
  }
  
  else if (letter.equals("t")) {
      syl = "Harry";
  }
  
  else if (letter.equals("u")) {
      syl = "Irvin";
  }
  
  else if (letter.equals("v")) {
      syl = "Erwin";
  }
  
  else if (letter.equals("w")) {
      syl = "Jerome";
  }
  
  else if (letter.equals("x")) {
      syl = "Luther";
  }
  
  else if (letter.equals("y")) {
      syl = "Lucius";
  }
  
  else if (letter.equals("z")) {
      syl = "Luke";
  }
  
  return syl;
  }

private String getSuffix(String letter) {
  
  String syl = "";
  
  if (letter.equals("a")) {
      syl = "the Dirty";
  }
  
  else if (letter.equals("b")) {
      syl = "of Mustard";   
  }
  
  else if (letter.equals("c")) {
      syl = "the Worthless";
  }

  else if (letter.equals("d")) {
      syl = "the Hated";
  }
  
  else if (letter.equals("e")) {
      syl = "the Loved";
  }
  
  else if (letter.equals("f")) {
      syl = "of the Caves";
  }
  
  else if (letter.equals("g")) {
      syl = "the Queer";
  }
  
  else if (letter.equals("h")) {
      syl = "the Drinker";
  }
  
  else if (letter.equals("i")) {
      syl = "the Holy";
  }
  
  else if (letter.equals("j")) {
      syl = "the Unholy";
  }
  
  else if (letter.equals("k")) {
      syl = "the Undecided";
  }
  
  else if (letter.equals("l")) {
      syl = "the Saint";
  }
  
  else if (letter.equals("m")) {
      syl = "the Demon";
  }
  
  else if (letter.equals("n")) {
      syl = "of the Swamp";
  }
  
  else if (letter.equals("o")) {
      syl = "the Just";
  }
  
  else if (letter.equals("p")) {
      syl = "the Callous";
  }
  
  else if (letter.equals("q")) {
      syl = "the Jester";
  }
  
  else if (letter.equals("r")) {
      syl = "the Wise";
  }
  
  else if (letter.equals("s")) {
      syl = "the Quick";
  }
  
  else if (letter.equals("t")) {
      syl = "the Slow";
  }
  
  else if (letter.equals("u")) {
      syl = "the Deaf";
  }
  
  else if (letter.equals("v")) {
      syl = "the Blind";
  }
  
  else if (letter.equals("w")) {
      syl = "the Bard";
  }
  
  else if (letter.equals("x")) {
      syl = "the Strong";
  }
  
  else if (letter.equals("y")) {
      syl = "the Weak";
  }
  
  else if (letter.equals("z")) {
      syl = "the Unwanted";
  }
  
  return syl;
  }
    
}
