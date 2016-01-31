package cn.stsniper.ch08.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The Class CompressionStrategy.
 * 策略模式来实现文件压缩
 *
 * @author W.Dragon
 * @since 2016-1-30 23:09:39
 */
public class Compressor {
	
	private final CompressionStrategy strategy;
	
	public Compressor(CompressionStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void compress(Path inFile, File outFile) throws IOException {
		try (OutputStream outStream = new FileOutputStream(outFile)) {
			Files.copy(inFile, strategy.compress(outStream));
		}
	}
}
