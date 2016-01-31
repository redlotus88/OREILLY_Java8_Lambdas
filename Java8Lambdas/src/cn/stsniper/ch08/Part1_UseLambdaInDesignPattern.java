package cn.stsniper.ch08;

import static cn.stsniper.ResourceUtils.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.mockito.Mockito;

import cn.stsniper.ch08.command.Editor;
import cn.stsniper.ch08.command.Macro;
import cn.stsniper.ch08.command.MockEditor;
import cn.stsniper.ch08.strategy.Compressor;
import cn.stsniper.ch08.strategy.GzipCompressionStrategy;
import cn.stsniper.ch08.strategy.ZipCompressionStrategy;

/**
 * The Class Part1_UseLambdaInDesignPattern.
 * Lambda表达式改变了设计模式
 *
 * @author W.Dragon
 * @since 2016-1-30 22:38:48
 */
public class Part1_UseLambdaInDesignPattern {
	
	
	/**
	 * Ex8_7 使用Lambda表达式构建宏.
	 */
	@Test
	public void ex8_7() {
		Editor editor = Mockito.mock(MockEditor.class);
		Macro macro = new Macro();
		macro.record(() -> editor.open());
		macro.record(() -> editor.save());
		macro.record(() -> editor.close());
	}
	
	/**
	 * Ex8_8 使用方法引用构建宏.
	 */
	@Test
	public void ex8_8() {
		Editor editor = Mockito.mock(MockEditor.class);
		Macro macro = new Macro();
		macro.record(editor::open);
		macro.record(editor::save);
		macro.record(editor::close);
	}
	
	/**
	 * Ex8-13 使用具体的策略类初始化Compressor.
	 * @throws IOException 
	 */
	@Test
	public void ex8_13() throws IOException {
		Path inFile = Paths.get(System.getProperty("user.dir"), TEST_FILE_FOR_COMPRESSION);
		File gzipOutFile = new File(System.getProperty("user.dir"), "data/gzip.gz");
		File zipOutFile = new File(System.getProperty("user.dir"), "data/test.zip");
		Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
		gzipCompressor.compress(inFile, gzipOutFile);
		
		Compressor zipCompressor = new Compressor(new ZipCompressionStrategy(inFile));
		zipCompressor.compress(inFile, zipOutFile);
		gzipOutFile.deleteOnExit();
		zipOutFile.deleteOnExit();
	}
}
