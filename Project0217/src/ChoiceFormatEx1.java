import java.text.ChoiceFormat;

public class ChoiceFormatEx1 {

	public static void main(String[] args) {
		double[] limits = {60,70,80,90};
		String[] grades = {"D","C","B","A"};
		
		ChoiceFormat form = new ChoiceFormat(limits, grades);
		
		int[] scores = {100,95,88,79,52,60};
		
		for(int i=0; i <scores.length; i++) {
			System.out.println(scores[i]+":"+form.format(scores[i]));
		}
	}

}