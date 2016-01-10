/*
 * 
 */
package cn.stsniper.ch03;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import cn.stsniper.bean.Album;
import cn.stsniper.bean.Artist;
import cn.stsniper.bean.SampleData;

/**
 * The Class Part5_MultiInvokeStream.
 * 
 * @author W.Dragon
 * @since 2016-1-9 20:13:16
 * @version 0.0.1-SNAPSHOT
 */
public class Part5_MultiInvokeStream {
	
	/**
	 * Ex3_24 误用Stream的例子.
	 */
	@Test
	public void ex3_24() {
		Album album = SampleData.aLoveSupreme;
		List<Artist> musicians = album.getMusicians()
									  .collect(Collectors.toList());
		List<Artist> bands = musicians.stream()
									  .filter(artist -> artist.getName().startsWith("The"))
									  .collect(Collectors.toList());
		Set<String> origins = bands.stream()
								   .map(artist -> artist.getNationality())
								   .collect(Collectors.toSet());
		
		// 误用：
		// 代码可读性差， 样板代码太多，隐藏了真正的业务逻辑
		// 效率差，每一步都要对流及早求值，生成新的集合
		// 代码充斥一堆垃圾变量，它们只能用来保存中间结果，除此之外毫无用处。
		// 难于自动并行化处理
	}
	
	/**
	 * Ex3_25 符合Stream使用习惯的链式调用.
	 */
	@Test
	public void ex3_25() {
		Album album = SampleData.aLoveSupreme;
		Set<String> origins = album.getMusicians()
									.filter(artist -> artist.getName().startsWith("The"))
									.map(artist -> artist.getNationality())
									.collect(Collectors.toSet());
	}
}
