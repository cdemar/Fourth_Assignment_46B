package dna;

import java.io.*;
import java.util.*;

/*
 * This changes all of the fastq file to
 * a fasta file.
 */

public class FileConverter {
	File fastq;
	File fasta;

	public FileConverter(File fastq, File fasta) {
		this.fasta = fasta;
		this.fastq = fastq;
	}

	// Opens the fasta writer and then opens a fasta
	// file to write the good records
	public void convert() throws IOException {

		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);

		// Read, translate, write.
		boolean done = false;
		FastqRecord fastqRec;

		// This correlates with the FastqReader
		while (!done) {
			try {
				fastqRec = fqr.readRecord();

				if (fastqRec == null) {
					done = true;
				}

				else if (!fastqRec.qualityIsLow()) {

					FastaRecord fataqr = new FastaRecord(fastqRec);

					faw.writeRecord(fataqr);
				}
			} catch (RecordFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}

	public static void main(String[] args) {
		System.out.println("Starting");
		try {
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists()) {
				System.out.println("Can't find input file "
						+ fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}