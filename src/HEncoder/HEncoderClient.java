package HEncoder;

public class HEncoderClient {

	public static void main(String[] args) {
		
		HEncoderClass client = new HEncoderClass("aaabbbbabbbbaabbababaccccddddaaabbbbabbbbaabbababaccccddddaaabbbbabbbbaabbababaccccddddaaabbbbabbbbaabbababaccccdddd");
		
		System.out.println(client.encodeData("ababababbabbba"));
		System.out.println(client.decodeData("11011011011001100011"));
		
		
	}

}
