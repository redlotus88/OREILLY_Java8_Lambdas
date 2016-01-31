package cn.stsniper.ch07;

import java.util.List;
import java.util.function.ToLongFunction;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.Track;

/**
 * The Class Part1_Refactor.
 *
 * @author W.Dragon
 * @since 2016-1-30 19:37:37
 */
public class Part1_Refactor {
	
	private List<Album> albums;
	
	// Order类的命令式实现
	// ex7-5
//	public long countRunningTime() {
//		long count = 0;
//		for (Album album : albums) {
//			for (Track track : album.getTrackList()) {
//				count += track.getLength();
//			}
//		}
//		return count;
//	}
//	
//	public long countMusicians() {
//		long count = 0;
//		for (Album album : albums) {
//			count += album.getMusicianList().size();
//		}
//		return count;
//	}
//	
//	public long countTracks() {
//		long count = 0;
//		for (Album album : albums) {
//			count += album.getTrackList().size();
//		}
//		return count;
//	}
	
	// 使用流重构命令式的Order类
	public long countRunningTime() {
		return countFeature(album -> album.getTracks().mapToLong(Track::getLength).count());
	}
	
	public long countMusicians() {
		return countFeature(album -> album.getMusicians().count());
	}
	
	public long countTracks() {
		return countFeature(album -> album.getTracks().count());
	}
	
	public long countFeature(ToLongFunction<Album> function) {
		return albums.stream().mapToLong(function).sum();
	}
}
