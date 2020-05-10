package com.redi.listeingstats;

import com.redi.listeingstats.tracks.Album;
import com.redi.listeingstats.tracks.Artist;
import com.redi.listeingstats.tracks.Track;

public class RediStreaming {
  private static Player player = new Player();

  public static void main(String[] args) {
    User flo = new User("Flo");
    User alina = new User("Alina");
    Artist acdc = new Artist("AC/DC");
    Artist offspring = new Artist("The Offspring");
    Artist nirvana = new Artist("Nirvana");
    Album nevermind = new Album("Nevermind", nirvana);

    Track highwayToHell = new Track("Highway to hell", acdc);
    Track smellsLikeTeenSpirit = new Track("Smells Like Teen Spirit", nirvana, nevermind);
    Track theKidsArentAlright = new Track("The Kids aren't alright", offspring);

    player.play(highwayToHell, flo);
    player.play(highwayToHell, flo);
    player.play(highwayToHell, alina);
    player.play(highwayToHell, alina);
    player.play(highwayToHell, flo);
    player.play(smellsLikeTeenSpirit, flo);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, alina);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, alina);
    player.play(theKidsArentAlright, alina);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, flo);
    player.play(theKidsArentAlright, flo);


    System.out.println();
    System.out.println("Artist statistics: ");
    System.out.println("AC/DC's top fan: " + player.getTopFanForArtist(acdc));
    System.out.println("Nirvana's top fan: " + player.getTopFanForArtist(nirvana));
    System.out.println("The Offspring's top fan: " + player.getTopFanForArtist(offspring));
    System.out.println("AC/DC fans: " + player.getArtistUserCount(acdc));
    System.out.println("Nirvana fans: " + player.getArtistUserCount(nirvana));
    System.out.println("The Offspring fans: " + player.getArtistUserCount(offspring));

    System.out.println();
    System.out.println("User statistics: ");
    System.out.println("Flo's top Artist: " + player.getTopArtistForFan(flo));
    System.out.println("Alina's top Artist: " + player.getTopArtistForFan(alina));
    System.out.println("Flo's top Track: " + player.getTopTrackForFan(flo));
    System.out.println("Alina's top Track: " + player.getTopTrackForFan(alina));
  }
}
