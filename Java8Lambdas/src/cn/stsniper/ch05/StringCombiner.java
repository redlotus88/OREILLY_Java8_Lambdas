package cn.stsniper.ch05;

public class StringCombiner {
	
	private final String prefix;
	private final String delim;
	private final String suffix;
	private final StringBuilder builder;
	
	public StringCombiner(String delim, String prefix, String suffix) {
		this.prefix = prefix;
		this.delim = delim;
		this.suffix = suffix;
		builder = new StringBuilder();
	}
	
	public StringCombiner add(String element) {
		if (areAtStart()) {
			builder.append(prefix);
		} else {
			builder.append(delim);
		}
		builder.append(element);
		return this;
	}
	
	public StringCombiner merge(StringCombiner other) {
		if (other.builder.length() > 0) {
	        if (areAtStart()) {
	        	builder.append(prefix);
	        } else {
	        	builder.append(delim);
	        }
	        builder.append(other.builder, prefix.length(), other.builder.length());
	    }
	    return this;
	}
	
	public String toString() {
		if (areAtStart()) {
            builder.append(prefix);
        }
        builder.append(suffix);
        return builder.toString();
	}
	
	private boolean areAtStart() {
		return builder.length() == 0;
	}
}
