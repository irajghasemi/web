package se.datalayer.guards.main;

public class Personnummer
{
	public static void main(String[] args)
	{
		long pnr = 195511268996L;				// obs L sist för att det är en long constant

		if (kollaKontrollsiffra(pnr))
			System.out.println("Rätt kontrollsiffra");
		else
			System.out.println("Fel kontrollsiffra");
	}

	public static boolean kollaKontrollsiffra(long pnr)
	{
		// siffersumman för alla heltal mellan 0 och 18
		int [] siffersumma = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int kSiffra = (int)(pnr % 10);				// sista siffran är kontrollsiffra
		pnr = pnr / 10;								// ta bort den från personnumret

		int etttvå = 2;								// 'vikten' är 1 eller 2, börja med 2
		int summa = 0;								// vår beräknade kontrollsiffra

		for (int i = 0; i < 9; i++)
		{
			int siffra = (int)(pnr % 10);			// plocka ut närsta siffra från höger
			pnr = pnr / 10;							// ta bort sista siffran
			siffra = siffra * etttvå;				// * 1 eller * 2
			etttvå = 3 - etttvå;					// 2 blir ett och vice versa
			summa = summa + siffersumma[siffra]; 	// siffra är max 18 (2 * 9)
		}

		summa = (summa / 10) * 10 + 10 - summa;		// kontrollsiffran är summan:s närmast högre tiotal minus summan

		return kSiffra == summa;					// ok om de är lika
	}

}  