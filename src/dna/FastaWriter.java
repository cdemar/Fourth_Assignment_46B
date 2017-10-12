package dna;

import java.io.*;

/*
 * This writes fasta record and in a correct fasta format.
 */

public class FastaWriter {
	private PrintWriter thePrintWriter;

	public FastaWriter(PrintWriter pw) {
		this.thePrintWriter = pw;
	}

	public void writeRecord(FastaRecord rec) throws IOException {
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
}
