package cn.stsniper.ch08.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * The Class GzipCompressionStrategy.
 * Ex8-10 Gzip算法实现
 *
 * @author W.Dragon
 * @since 2016-1-30 23:14:05
 */
public class GzipCompressionStrategy implements CompressionStrategy {

	@Override
	public OutputStream compress(OutputStream data) throws IOException {
		return new GZIPOutputStream(data);
	}

}
