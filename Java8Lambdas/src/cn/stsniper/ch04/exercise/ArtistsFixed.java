package cn.stsniper.ch04.exercise;

import java.util.List;
import java.util.Optional;

import cn.stsniper.bean.Artist;

public class ArtistsFixed {
	
	private List<Artist> artists;

    public ArtistsFixed(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
        	return Optional.empty();
        }
        return Optional.ofNullable(artists.get(index));
    }

    private IllegalArgumentException indexException(int index) {
        return new IllegalArgumentException(index + 
                                           " doesn't correspond to an Artist");
    }

    public String getArtistName(int index) {
        try {
            Optional<Artist> artist = getArtist(index);
            return artist.orElseThrow(() -> indexException(index)).getName();
        } catch (IllegalArgumentException e) {
            return "unknown";
        }
    }
}
