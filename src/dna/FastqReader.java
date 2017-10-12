package dna;

import java.io.*;

/*
 * This looks at your method reads a line from your
 * buffered reader and if there is something in it than 
 * execute by looking at the other three lines 
 */

public class FastqReader {
	BufferedReader theBufferedReader;

	public FastqReader(BufferedReader br) {
		this.theBufferedReader = new BufferedReader(br);
	}

	public FastqRecord readRecord() throws IOException, RecordFormatException {

		String defline = theBufferedReader.readLine();
		if (defline == null) {
			return null;
		}

		String sequence = theBufferedReader.readLine();

		// This sees the weird “+” line
		theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();

		return new FastqRecord(defline, sequence, quality);
	}
}
