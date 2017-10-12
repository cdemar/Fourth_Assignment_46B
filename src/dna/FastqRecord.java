package dna;

/*
 * This is to check if the defline from your fastq
 * has the '@' symbol and if it doesn't than it is
 * passed through as good.
 */

public class FastqRecord implements DNARecord {
	String defline;
	String sequence;
	String quality;

	public FastqRecord(String defline, String sequence, String quality)
			throws RecordFormatException {
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;

		// This is to check if your first character has '@' in the doc
		if (defline.charAt(0) != '@') {
			throw new RecordFormatException(
					"Bad 1st char in defline in fastq record: saw "
							+ defline.charAt(0) + ", expected @");
		}
	}

	public String getDefline() {
		return defline;
	}

	public String getSequence() {
		return sequence;
	}
	
	public String getQuality() {
		return quality;
	}

	// This makes shore that all of the files are all the same
	public boolean equals(FastqRecord that) {
		return (this.defline.equals(that.defline)
				&& this.sequence.equals(that.sequence) && this.quality
					.equals(that.quality));
	}

	public boolean qualityIsLow() {
		return this.quality.contains("!");
	}

	public int hashCode() {
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
