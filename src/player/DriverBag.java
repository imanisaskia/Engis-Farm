import java.util.*;

import farm_products.*;
import side_products.*;
import player.*;

public class DriverBag{
	public static void main(String[] args){
		/*Membuat tas baru*/
		Bag<FarmProduct> FP = new Bag<FarmProduct>();
		Bag<SideProduct> SP = new Bag<SideProduct>();
		System.out.println("Sudah Buat tas baru");
		System.out.println();
		
		System.out.println("Mengecek isi tas seharusnya kosong");
		System.out.println("Ukuran FP : "+FP.getSize());
		System.out.println("Is FP empty : "+FP.isEmpty());
		System.out.println("Ukuran SP : "+SP.getSize());
		System.out.println("Is SP empty : "+SP.isEmpty());
		System.out.println();
		
		System.out.println("Menambahkan isi tas");
		ChickenEgg CE = new ChickenEgg();
		RabbitMeat RM = new RabbitMeat();
		PorkStew PS = new PorkStew();
		Omlette OM = new Omlette();
		FP.add(CE);
		FP.add(RM);
		SP.add(PS);
		SP.add(OM);
		System.out.println();

		System.out.println("Mengecek isi tas seharusnya tidak kosong");
		System.out.println("Ukuran FP : "+FP.getSize());
		System.out.println("Is FP empty : "+FP.isEmpty());
		System.out.println("Ukuran SP : "+SP.getSize());
		System.out.println("Is SP empty : "+SP.isEmpty());
		System.out.println();

		System.out.println("Mencari elemen");
		System.out.println("Indeks CE : "+FP.find(CE));
		System.out.println("Indeks RM : "+FP.find(RM));
		CowMeat CM = new CowMeat();
		System.out.println("Indeks CM : "+FP.find(CM));
		System.out.println("Indeks PS : "+SP.find(PS));
		System.out.println("Indeks OM : "+SP.find(OM));
		BeefStew BS = new BeefStew();
		System.out.println("Indeks BS : "+SP.find(BS));
		System.out.println();

		System.out.println("Mengeluarkan isi tas");
		FP.remove(CE);
		FP.remove(RM);
		FP.remove(CM);
		SP.remove(PS);
		SP.remove(OM);
		SP.remove(BS);
		System.out.println("Is FP empty : "+FP.isEmpty());
		System.out.println("Is SP empty : "+SP.isEmpty());

		

	}
}
