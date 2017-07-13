import java.util.Random;

class GenerateTwoNos
{
	public static int randomNumber()
	{
		int randNum = rand.nextInt(11);
		return randNum;
	}
	public static void main(String[] args)
	{
		System.out.println("Generating 2 random numbers between the range (0-10):-");
		int num1 = randomNumber();
		int num2 = randomNumber();
		System.out.println("Numbers generated are " + a + " & " + b);
	}
}