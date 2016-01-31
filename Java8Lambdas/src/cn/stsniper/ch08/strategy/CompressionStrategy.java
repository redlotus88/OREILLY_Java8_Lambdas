package cn.stsniper.ch08.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The Interface CompressionStrategy.
 * Ex8-9 压缩算法策略
 *
 * @author W.Dragon
 * @since 2016-1-30 23:13:07
 */
public interface CompressionStrategy {
	
	public OutputStream compress(OutputStream data) throws IOException;
	
}
