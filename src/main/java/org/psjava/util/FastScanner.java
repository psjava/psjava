package org.psjava.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class FastScanner {

	private StringTokenizer tokenizer;

	public FastScanner(InputStream is) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024 * 1024);
			byte[] buf = new byte[1024];
			while (true) {
				int read = is.read(buf);
				if (read == -1)
					break;
				bos.write(buf, 0, read);
			}
			tokenizer = new StringTokenizer(new String(bos.toByteArray()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean hasNext() {
		return tokenizer.hasMoreTokens();
	}

	public int nextInt() {
		return Integer.parseInt(tokenizer.nextToken());
	}

	public long nextLong() {
		return Long.parseLong(tokenizer.nextToken());
	}

	public double nextDouble() {
		return Double.parseDouble(tokenizer.nextToken());
	}

	public String next() {
		return tokenizer.nextToken();
	}

}
