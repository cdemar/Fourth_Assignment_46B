package dna;

/*
 * This is to check if the defline from your fastq
 * has the '>' symbol and if it doesn't than it is
 * passed through as good.
 */

public class FastaRecord implements DNARecord {
	String defline;
	String sequence;

	// This is to check if your first character is '>' in the doc
	public FastaRecord(String defline, String sequence)
			throws RecordFormatException {
		this.defline = defline;
		this.sequence = sequence;

		if (defline.charAt(0) != '>') {
			throw new RecordFormatException(
					"Bad 1st char in defline in fasta record: saw "
							+ defline.charAt(0) + ", expected >");
		}
	}

	// This is to change the character from '@' to '>'
	public FastaRecord(FastqRecord fastqRec) {
		this.defline = '>' + fastqRec.defline.substring(1);
		this.sequence = fastqRec.sequence;
	}

	public String getDefline() {
		return defline;
	}

	public String getSequence() {
		return sequence;
	}

	public boolean equals(FastaRecord that) {
		return (this.defline.equals(that.defline) && this.sequence
				.equals(that.sequence));
	}

	public int hashCode() {
		return defline.hashCode() + sequence.hashCode();
	}
}