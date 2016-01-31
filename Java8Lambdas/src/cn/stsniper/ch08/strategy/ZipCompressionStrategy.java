package cn.stsniper.ch08.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * The Class ZipCompressionStrategy.
 * Ex8-11 使用zip算法压缩数据
 *
 * @author W.Dragon
 * @since 2016-1-30 23:15:16
 */
public class ZipCompressionStrategy implements CompressionStrategy {

	private final Path inFilePath;
	
	public ZipCompressionStrategy(Path inFilePath) {
		this.inFilePath = inFilePath;
	}
	
	@Override
	public OutputStream compress(OutputStream data) throws IOException {
		ZipOutputStream zos = new ZipOutputStream(data);
		zos.putNextEntry(new ZipEntry(inFilePath.getFileName().toString()));
		return zos;
	}

}
